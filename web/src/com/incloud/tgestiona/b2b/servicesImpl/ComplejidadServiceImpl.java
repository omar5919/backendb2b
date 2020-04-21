package com.incloud.tgestiona.b2b.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.incloud.tgestiona.b2b.model.Complejidad;
import com.incloud.tgestiona.b2b.repository.ComplejidadRepository;
import com.incloud.tgestiona.b2b.serices.ComplejidadService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ComplejidadServiceImpl implements ComplejidadService {

	@Autowired
	private ComplejidadRepository<Complejidad> repository;

	@Transactional
	public List<Complejidad> getAll() {
		return (List<Complejidad>) repository.findAll();
	}

	@Transactional
	public Optional<Complejidad> findByID(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public List<Complejidad> saveAll(List<Complejidad> entities) {
		return (List<Complejidad>) repository.saveAll(entities);
	}

	@Transactional
	public Complejidad save(Complejidad entities) {
		return repository.save(entities);
	}

	@Transactional
	public Complejidad deleteById(Integer id) {
		if (repository.existsById(id))
			repository.deleteById(id);
		return new Complejidad();
	}

	@Transactional
	public Complejidad deleteAll() {
		repository.deleteAll();
		return new Complejidad();
	}

}
