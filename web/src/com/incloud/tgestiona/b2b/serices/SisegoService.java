package com.incloud.tgestiona.b2b.serices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.incloud.tgestiona.b2b.model.Sisego;

@Component
public interface SisegoService {

	public List<Sisego> getAll();

	public Optional<Sisego> findByID(Integer id);

	public List<Sisego> saveAll(List<Sisego> entities);

	public Sisego save(Sisego entities);

	public Sisego deleteById(Integer id);

	public Sisego deleteAll();
}
