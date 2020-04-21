package com.incloud.tgestiona.b2b.serices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.incloud.tgestiona.b2b.model.OfertasDetalle;

@Component
public interface OfertasDetalleService {

	public List<OfertasDetalle> getAll();

	public Optional<OfertasDetalle> findByID(Integer id);

	public List<OfertasDetalle> saveAll(List<OfertasDetalle> entities);

	public OfertasDetalle save(OfertasDetalle entities);

	public OfertasDetalle deleteById(Integer id);
	
	public OfertasDetalle deleteAll();

}
