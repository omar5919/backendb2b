package com.incloud.tgestiona.b2b.serices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.incloud.tgestiona.b2b.model.Circuito;

@Component
public interface CircuitoService {

	public List<Circuito> getAll();

	public Optional<Circuito> findByID(Integer id);

	public List<Circuito> saveAll(List<Circuito> entities);

	public Circuito save(Circuito entities);

	public Circuito deleteById(Integer id);

	public Circuito deleteAll();

}
