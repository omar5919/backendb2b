package com.incloud.tgestiona.b2b.serices;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.incloud.tgestiona.b2b.model.oferta.OfertasDetalle;
import com.incloud.tgestiona.b2b.service.dto.BaseBandejaResponse;
import com.incloud.tgestiona.b2b.service.dto.OfertasDetalleDto;


public interface OfertasDetalleService {
    BaseBandejaResponse<List<OfertasDetalleDto>> getOfertasDetalle(Integer ofertaId, Pageable pageable);

	
	//List<OfertasDetalle> getAll();

	//Optional<OfertasDetalle> findByID(Integer id);

	//List<OfertasDetalle> saveAll(List<OfertasDetalle> entities);

	//OfertasDetalle save(OfertasDetalle entities);

	//OfertasDetalle deleteById(Integer id);
	
	//OfertasDetalle deleteAll();

	//List<OfertasDetalle> listaOfertaDetalle(Integer ofertaId) ;
}
