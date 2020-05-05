package com.incloud.tgestiona.b2b.servicesImpl;

import com.incloud.tgestiona.b2b.converter.ofertasConverter;
import com.incloud.tgestiona.b2b.model.Cliente;
import com.incloud.tgestiona.b2b.model.Complejidad;
import com.incloud.tgestiona.b2b.model.Estado;
import com.incloud.tgestiona.b2b.model.oferta.Ofertas;
import com.incloud.tgestiona.b2b.repository.OfertasRepository;
import com.incloud.tgestiona.b2b.serices.OfertasService;
import com.incloud.tgestiona.b2b.service.dto.BaseBandejaResponse;
import com.incloud.tgestiona.b2b.service.dto.ofertaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class OfertasServiceImpl implements OfertasService {

    private final OfertasRepository oRepo;

    public OfertasServiceImpl(OfertasRepository oRepo) {
        this.oRepo = oRepo;
    }

    @Override
    public BaseBandejaResponse<List<ofertaDto>> getOfertas(String codoportunidad, String cliente, String descripcion, Integer complejidad, Integer estado, Date desde, Date hasta, Pageable pageable) {
//        Page<Ofertas> pOfertas = oRepo.findAll((Specification<Ofertas>) (root, cq, cb) -> {
//            Predicate p = cb.conjunction();
//            if (Objects.nonNull(desde) && Objects.nonNull(hasta) && desde.before(hasta)) {
//                p = cb.and(p, cb.between(root.get("fecha_reg"), desde, hasta));
//            }
//            if (!StringUtils.isEmpty(desc)) {
//                p = cb.and(p, cb.like(root.get("descripcion"), "%" + desc + "%"));
//            }
//            cq.orderBy(cb.desc(root.get("descripcion")), cb.asc(root.get("oferta_id")));
//            return p;
//        }, pageable);
        List<Ofertas> oList = oRepo.findAll((Specification<Ofertas>) (root, cq, cb) -> {
            Predicate p = cb.conjunction();
            Join<Ofertas, Cliente> clienteOfertas = root.join("cliente");
            Join<Ofertas, Estado> estadoOfertas = root.join("estado");
            Join<Ofertas, Complejidad> complejidadOfertas = root.join("complejidad");

            if (!StringUtils.isEmpty(codoportunidad)) {
                p = cb.and(p, cb.like(root.get("codigo"), "%" + codoportunidad + "%"));
            }
            if (!StringUtils.isEmpty(cliente)) {
                p = cb.and(p, cb.like(clienteOfertas.get("descripcion"), "%" + cliente + "%"));
            }
            if (!StringUtils.isEmpty(descripcion)) {
                p = cb.and(p, cb.like(root.get("descripcion"), "%" + descripcion + "%"));
            }
            if (complejidad != null) {
                p = cb.and(p, cb.equal(complejidadOfertas.get("id"), complejidad));
            }
            if (estado != null) {
                p = cb.and(p, cb.equal(estadoOfertas.get("id"), estado));
            }
            if (Objects.nonNull(desde) && Objects.nonNull(hasta) && desde.before(hasta)) {
                p = cb.and(p, cb.between(root.get("fecha_reg"), desde, hasta));
            }
            cq.orderBy(cb.desc(root.get("descripcion")), cb.asc(root.get("oferta_id")));
            return p;
        }, pageable).getContent();
        return ofertasConverter.convertToOfertaDTO(oList);
    }

    @Override
    public void addOferta(ofertaDto o) {
        oRepo.save(ofertasConverter.convertToOferta(o));
    }
}
