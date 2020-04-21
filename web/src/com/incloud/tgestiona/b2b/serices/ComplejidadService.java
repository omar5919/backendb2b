package com.incloud.tgestiona.b2b.serices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import com.incloud.tgestiona.b2b.model.Complejidad;

@Component
public interface ComplejidadService {

	public List<Complejidad> getAll();

	public Optional<Complejidad> findByID(Integer id);

	public List<Complejidad> saveAll(List<Complejidad> entities);

	public Complejidad save(Complejidad entities);

	public Complejidad deleteById(Integer id);

	public Complejidad deleteAll();

}
