package com.incloud.tgestiona.b2b.serices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.incloud.tgestiona.b2b.model.*;

@Component
public interface EstadoService {

	public List<EstadoOferta> getAll();

	public Optional<EstadoOferta> findByID(Integer id);

	public List<EstadoOferta> saveAll(List<EstadoOferta> entities);

	public EstadoOferta save(EstadoOferta entities);

	public EstadoOferta deleteById(Integer id);

	public EstadoOferta deleteAll();

}
