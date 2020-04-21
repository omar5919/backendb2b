package com.incloud.tgestiona.b2b.serices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.incloud.tgestiona.b2b.model.CondicionCircuito;

@Component
public interface CondicionCircuitoService {

	public List<CondicionCircuito> getAll();

	public Optional<CondicionCircuito> findByID(Integer id);

	public List<CondicionCircuito> saveAll(List<CondicionCircuito> entities);

	public CondicionCircuito save(CondicionCircuito entities);

	public CondicionCircuito deleteById(Integer id);

	public CondicionCircuito deleteAll();

}
