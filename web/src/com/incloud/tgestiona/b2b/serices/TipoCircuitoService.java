package com.incloud.tgestiona.b2b.serices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.incloud.tgestiona.b2b.model.TipoCircuito;

@Component
public interface TipoCircuitoService {

	public List<TipoCircuito> getAll();

	public Optional<TipoCircuito> findByID(Integer id);

	public List<TipoCircuito> saveAll(List<TipoCircuito> entities);

	public TipoCircuito save(TipoCircuito entities);

	public TipoCircuito deleteById(Integer id);

	public TipoCircuito deleteAll();
}
