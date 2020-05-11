package com.incloud.tgestiona.b2b.servicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.incloud.tgestiona.b2b.model.Cliente;
import com.incloud.tgestiona.b2b.model.ConceptosOpex;
import com.incloud.tgestiona.b2b.model.oferta.Ofertas;
import com.incloud.tgestiona.b2b.model.Moneda;
import com.incloud.tgestiona.b2b.model.oferta.OfertasOpex;
import com.incloud.tgestiona.b2b.repository.OfertasOpexRepository;
import com.incloud.tgestiona.b2b.serices.OfertasOpexService;
import com.incloud.tgestiona.b2b.service.dto.BaseBandejaResponse;
import com.incloud.tgestiona.b2b.service.dto.OfertasDetalleDto;
import com.incloud.tgestiona.b2b.service.dto.OfertasOpexDto;
@Service
public class OfertasOpexServiceImpl  implements OfertasOpexService {

	 private final OfertasOpexRepository oRepo;

	    public OfertasOpexServiceImpl(OfertasOpexRepository oRepo) {
	        this.oRepo = oRepo;
	    }
	
	
	public  BaseBandejaResponse<List<OfertasOpexDto>> getOfertasOpex(Integer ofertaId, Pageable pageable){
		Page<OfertasOpex> pOfertasOpex = oRepo.findAll((Specification<OfertasOpex>) (root, cq, cb) -> {
            Predicate p = cb.conjunction();
            Join<OfertasOpex, Ofertas> OfertasOpexOfertas = root.join("ofertas");
            Join<OfertasOpex, ConceptosOpex> OfertasOpexConceptosOpex = root.join("conceptosOpex");
            Join<OfertasOpex, Moneda> OfertasOpexMoneda = root.join("moneda");
          //Join<OfertasDetalle, TipoServicio> OfertasDetalleTipoServicio = root.join("",JoinType.LEFT_OUTER_JOIN);
          
            
            if (!StringUtils.isEmpty(ofertaId)) {
                p = cb.and(p, cb.equal(OfertasOpexOfertas.get("oferta_id"), ofertaId));
            }
            
           cq.orderBy( cb.asc(root.get("ofertaOpexId")));
           return p;
       }, pageable);


       return CargarDtoOfertaOpex(pOfertasOpex.getContent(),pOfertasOpex.getTotalElements()) ;//ofertasConverter.convertToOfertaDTO(pOfertas.getContent(),pOfertas.getTotalElements());

	}
	
	private  BaseBandejaResponse<List<OfertasOpexDto>>  CargarDtoOfertaOpex(List<OfertasOpex>  list,long total) {
		 BaseBandejaResponse<List<OfertasOpexDto>> oDto = new BaseBandejaResponse<>();
	        oDto.setMsj("200");
	        oDto.setRows(total);
	   	 List<OfertasOpexDto> ol = list.stream().map(s ->
	   	OfertasOpexDto.builder()
				   		.ofertaOpexId(s.getId())
					    .ofertaId(s.getOfertas().getId() )
					    .conceptoId(s.getConceptosOpex().getId())
					    .cantidad(s.getCantidad())
					    .factor(s.getFactor())
					    .meses(s.getMeses())
					    .nombre(s.getNombre())
				        .totalMensual(s.getTotalMensual())
				        .unitarioMensual(s.getUnitarioMensual())
				        .activo(s.getActivo())
				        .moneda_id(s.getMoneda().getId())
              	  .build()
              	  ).collect(Collectors.toList());
		 
		  oDto.setData(ol);
	        return oDto;	
	}
}
