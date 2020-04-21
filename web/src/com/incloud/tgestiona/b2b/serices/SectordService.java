package com.incloud.tgestiona.b2b.serices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.incloud.tgestiona.b2b.model.Sector;

@Component
public interface SectordService {

	public List<Sector> getAll();

	public Optional<Sector> findByID(Integer id);

	public List<Sector> saveAll(List<Sector> entities);

	public Sector save(Sector entities);

	public Sector deleteById(Integer id);
	
	public Sector deleteAll();

}
