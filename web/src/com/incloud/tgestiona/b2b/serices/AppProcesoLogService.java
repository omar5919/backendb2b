package com.incloud.tgestiona.b2b.serices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.incloud.tgestiona.b2b.model.AppProcesoLog;

@Component
public interface AppProcesoLogService {

	public List<AppProcesoLog> getAll();

	public Optional<AppProcesoLog> findByID(Integer id);

	public AppProcesoLog save(AppProcesoLog entities);

	public AppProcesoLog deleteById(Integer id);
	
	public AppProcesoLog deleteAll();

}
