package com.incloud.tgestiona.b2b.servicesImpl;

import com.incloud.tgestiona.b2b.converter.ofertasConverter;
import com.incloud.tgestiona.b2b.model.Cliente;
import com.incloud.tgestiona.b2b.model.Complejidad;
import com.incloud.tgestiona.b2b.model.oferta.Estado;
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
        Page<Ofertas> pOfertas = oRepo.findAll((Specification<Ofertas>) (root, cq, cb) -> {
            Predicate p = cb.conjunction();
            Join<Ofertas, Cliente> clienteOfertas = root.join("cliente");
            Join<Ofertas, Estado> estadoOfertas = root.join("estado");
            Join<Ofertas, Complejidad> complejidadOfertas = root.join("complejidad");

            if (!StringUtils.isEmpty(codoportunidad)) {
                p = cb.and(p, cb.like(root.get("oportunidad"), "%" + codoportunidad + "%"));
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
        }, pageable);
        return ofertasConverter.convertToOfertaDTO(pOfertas.getContent(),pOfertas.getTotalElements());
    }

    @Override
    public void addOferta(ofertaDto o) {
        oRepo.save(ofertasConverter.convertToOferta(o));
    }
    
    public int copiarOferta(Integer ofertaId,Integer usuarioId,String usuario) {
     return	this.oRepo.copiarOferta(ofertaId,  usuarioId,  usuario);
    	
    }
    public int anularOferta(Integer ofertaId,Integer usuarioId,String usuario){
        return	this.oRepo.anularOferta(ofertaId,  usuarioId,  usuario);
       	
    }
    public int versionarOferta(Integer ofertaId,Integer usuarioId,String usuario) {
    	return this.oRepo.versionarOferta(ofertaId, usuarioId, usuario);
    }
    
    public  int ganarOferta(Integer ofertaId,Integer usuarioId,String usuario) {
    	return this.oRepo.ganarOferta(ofertaId, usuarioId, usuario);
    }
}
