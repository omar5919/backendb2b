package com.incloud.tgestiona.b2b.servicesImpl;

import com.incloud.tgestiona.b2b.converter.ofertasConverter;
import com.incloud.tgestiona.b2b.model.oferta.Ofertas;
import com.incloud.tgestiona.b2b.repository.OfertasRepository;
import com.incloud.tgestiona.b2b.serices.OfertasService;
import com.incloud.tgestiona.b2b.service.dto.ofertaDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    public List<ofertaDto> getOfertas(Date desde, Date hasta, String name, Pageable pageable) {
        List<Ofertas> oList = oRepo.findAll((Specification<Ofertas>) (root, cq, cb) -> {
            Predicate p = cb.conjunction();
            if (Objects.nonNull(desde) && Objects.nonNull(hasta) && desde.before(hasta)) {
                p = cb.and(p, cb.between(root.get("fechareg"), desde, hasta));
            }
            if (!StringUtils.isEmpty(name)) {
                p = cb.and(p, cb.like(root.get("nombre"), "%" + name + "%"));
            }
            cq.orderBy(cb.desc(root.get("nombre")), cb.asc(root.get("id")));
            return p;
        }, pageable).getContent();
        return ofertasConverter.convertToOfertaDTO(oList);
    }

    @Override
    public void addOferta(ofertaDto o) {
        oRepo.save(ofertasConverter.convertToOferta(o));
    }
}
