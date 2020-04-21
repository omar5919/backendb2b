package com.incloud.tgestiona.b2b.serices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.incloud.tgestiona.b2b.model.Oportunidad;

@Component
public interface OportunidadService {

	public List<Oportunidad> getAll();

	public Optional<Oportunidad> findByID(Integer id);

	public List<Oportunidad> saveAll(List<Oportunidad> entities);

	public Oportunidad save(Oportunidad entities);

	public Oportunidad deleteById(Integer id);
	
	public Oportunidad deleteAll();

}
