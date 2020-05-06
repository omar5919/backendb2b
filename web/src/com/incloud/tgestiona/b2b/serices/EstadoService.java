package com.incloud.tgestiona.b2b.serices;

import java.util.List;
import java.util.Optional;

import com.incloud.tgestiona.b2b.model.oferta.Estado;
import org.springframework.stereotype.Component;

import com.incloud.tgestiona.b2b.model.*;

@Component
public interface EstadoService {

	public List<Estado> getAll();

	public Optional<Estado> findByID(Integer id);

	public List<Estado> saveAll(List<Estado> entities);

	public Estado save(Estado entities);

	public Estado deleteById(Integer id);

	public Estado deleteAll();

}
