package com.incloud.tgestiona.b2b.serices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.incloud.tgestiona.b2b.model.Ofertas;

@Component
public interface OfertaService {

	public List<Ofertas> getAll();

	public Optional<Ofertas> findByID(Integer idoferta);

	public List<Ofertas> saveAll(List<Ofertas> entities);

	public Ofertas save(Ofertas entities);

	public Ofertas deleteById(Integer id);

	public Ofertas deleteAll();

}
