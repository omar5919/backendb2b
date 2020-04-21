package com.incloud.tgestiona.b2b.serices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.incloud.tgestiona.b2b.model.Moneda;

@Component
public interface MonedaService {

	public List<Moneda> getAll();

	public Optional<Moneda> findByID(Integer id);

	public List<Moneda> saveAll(List<Moneda> entities);

	public Moneda save(Moneda entities);

	public Moneda deleteById(Integer id);

	public Moneda deleteAll();

}
