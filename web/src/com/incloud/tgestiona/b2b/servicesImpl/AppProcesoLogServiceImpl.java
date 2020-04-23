package com.incloud.tgestiona.b2b.servicesImpl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.incloud.tgestiona.b2b.model.AppProcesoLog;
import com.incloud.tgestiona.b2b.repository.AppProcesoLogRepository;
import com.incloud.tgestiona.b2b.serices.AppProcesoLogService;

//@Service
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class AppProcesoLogServiceImpl implements AppProcesoLogService {

	@Autowired
	private AppProcesoLogRepository<AppProcesoLog> repository;

	@Transactional
	public List<AppProcesoLog> getAll() {
		return (List<AppProcesoLog>) repository.findAll();
	}

	@Transactional
	public Optional<AppProcesoLog> findByID(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public AppProcesoLog save(AppProcesoLog entities) {
		return  repository.save(entities);
	}

	@Transactional
	public AppProcesoLog deleteById(Integer id) {
		if (repository.existsById(id))
			repository.deleteById(id);
		return new AppProcesoLog();

	}

	@Transactional
	public AppProcesoLog deleteAll() {
		repository.deleteAll();
		return new AppProcesoLog();
	}

}
