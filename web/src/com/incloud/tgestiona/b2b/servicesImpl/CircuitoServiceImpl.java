package com.incloud.tgestiona.b2b.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.incloud.tgestiona.b2b.model.Circuito;
import com.incloud.tgestiona.b2b.repository.CircuitoRepository;
import com.incloud.tgestiona.b2b.serices.CircuitoService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class CircuitoServiceImpl implements CircuitoService {

	@Autowired
	private CircuitoRepository<Circuito> repository;

	@Transactional
	public List<Circuito> getAll() {
		return (List<Circuito>) repository.findAll();
	}

	@Transactional
	public Optional<Circuito> findByID(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public List<Circuito> saveAll(List<Circuito> entities) {
		return (List<Circuito>) repository.saveAll(entities);
	}

	@Transactional
	public Circuito save(Circuito entities) {
		return repository.save(entities);
	}

	@Transactional
	public Circuito deleteById(Integer id) {
		if (repository.existsById(id))
			repository.deleteById(id);
		return new Circuito();
	}

	@Transactional
	public Circuito deleteAll() {
		repository.deleteAll();
		return new Circuito();
	}

}
