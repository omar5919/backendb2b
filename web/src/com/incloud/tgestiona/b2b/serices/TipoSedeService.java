package com.incloud.tgestiona.b2b.serices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.incloud.tgestiona.b2b.model.TipoSede;

@Component
public interface TipoSedeService {

	public List<TipoSede> getAll();

	public Optional<TipoSede> findByID(Integer id);

	public List<TipoSede> saveAll(List<TipoSede> entities);

	public TipoSede save(TipoSede entities);

	public TipoSede deleteById(Integer id);

	public TipoSede deleteAll();
}
