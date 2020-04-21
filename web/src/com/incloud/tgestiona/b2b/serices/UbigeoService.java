package com.incloud.tgestiona.b2b.serices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.incloud.tgestiona.b2b.model.Ubigeo;

@Component
public interface UbigeoService {

	public List<Ubigeo> getAll();

	public Optional<Ubigeo> findByID(Integer id);

	public List<Ubigeo> saveAll(List<Ubigeo> entities);

	public Ubigeo save(Ubigeo entities);

	public Ubigeo deleteById(Integer id);

	public Ubigeo deleteAll();
}
