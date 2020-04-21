package com.incloud.tgestiona.b2b.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.incloud.tgestiona.b2b.model.CondicionCircuito;
import com.incloud.tgestiona.b2b.repository.CondicionCircuitoRepository;
import com.incloud.tgestiona.b2b.serices.CondicionCircuitoService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class CondicionCircuitoServiceImpl implements CondicionCircuitoService {

	@Autowired
	private CondicionCircuitoRepository<CondicionCircuito> repository;

	@Transactional
	public List<CondicionCircuito> getAll() {
		return (List<CondicionCircuito>) repository.findAll();
	}

	@Transactional
	public Optional<CondicionCircuito> findByID(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public List<CondicionCircuito> saveAll(List<CondicionCircuito> entities) {
		return (List<CondicionCircuito>) repository.saveAll(entities);
	}

	@Transactional
	public CondicionCircuito save(CondicionCircuito entities) {
		return repository.save(entities);
	}

	@Transactional
	public CondicionCircuito deleteById(Integer id) {
		if (repository.existsById(id))
			repository.deleteById(id);
		return new CondicionCircuito();
	}

	@Transactional
	public CondicionCircuito deleteAll() {
		repository.deleteAll();
		return new CondicionCircuito();
	}

}
