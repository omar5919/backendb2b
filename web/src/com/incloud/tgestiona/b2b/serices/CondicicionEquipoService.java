package com.incloud.tgestiona.b2b.serices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.incloud.tgestiona.b2b.model.CondicicionEquipo;

@Component
public interface CondicicionEquipoService {

	public List<CondicicionEquipo> getAll();

	public Optional<CondicicionEquipo> findByID(Integer id);

	public List<CondicicionEquipo> saveAll(List<CondicicionEquipo> entities);

	public CondicicionEquipo save(CondicicionEquipo entities);

	public CondicicionEquipo deleteById(Integer id);

	public CondicicionEquipo deleteAll();

}
