package com.incloud.tgestiona.b2b.serices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.incloud.tgestiona.b2b.model.AnalistaFinaciero;

@Component
public interface AnalistaFinacieroService {

	public List<AnalistaFinaciero> getAll();

	public Optional<AnalistaFinaciero> findByID(Integer id);

	public List<AnalistaFinaciero> saveAll(List<AnalistaFinaciero> entities);

	public AnalistaFinaciero save(AnalistaFinaciero entities);

	public AnalistaFinaciero deleteById(Integer id);

	public AnalistaFinaciero deleteAll();

}
