package com.incloud.tgestiona.b2b.serices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.incloud.tgestiona.b2b.model.CategoriaEquipo;

@Component
public interface CategoriaEquipoService {

	public List<CategoriaEquipo> getAll();

	public Optional<CategoriaEquipo> findByID(Integer id);

	public List<CategoriaEquipo> saveAll(List<CategoriaEquipo> entities);

	public CategoriaEquipo save(CategoriaEquipo entities);

	public CategoriaEquipo deleteById(Integer id);

	public CategoriaEquipo deleteAll();
}
