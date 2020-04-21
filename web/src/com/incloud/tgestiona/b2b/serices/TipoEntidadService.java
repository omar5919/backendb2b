package com.incloud.tgestiona.b2b.serices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.incloud.tgestiona.b2b.model.TipoEntidad;

@Component
public interface TipoEntidadService {

	public List<TipoEntidad> getAll();

	public Optional<TipoEntidad> findByID(Integer id);

	public List<TipoEntidad> saveAll(List<TipoEntidad> entities);

	public TipoEntidad save(TipoEntidad entities);

	public TipoEntidad deleteById(Integer id);

	public TipoEntidad deleteAll();
}
