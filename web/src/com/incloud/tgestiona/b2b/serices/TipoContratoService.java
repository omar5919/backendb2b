package com.incloud.tgestiona.b2b.serices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.incloud.tgestiona.b2b.model.TipoContrato;

@Component
public interface TipoContratoService {

	public List<TipoContrato> getAll();

	public Optional<TipoContrato> findByID(Integer id);

	public List<TipoContrato> saveAll(List<TipoContrato> entities);

	public TipoContrato save(TipoContrato entities);

	public TipoContrato deleteById(Integer id);

	public TipoContrato deleteAll();
}
