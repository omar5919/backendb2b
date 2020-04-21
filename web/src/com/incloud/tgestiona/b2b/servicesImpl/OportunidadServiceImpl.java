package com.incloud.tgestiona.b2b.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.incloud.tgestiona.b2b.model.Oportunidad;
import com.incloud.tgestiona.b2b.repository.OportunidadRepository;
import com.incloud.tgestiona.b2b.serices.OportunidadService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class OportunidadServiceImpl implements OportunidadService {

	@Autowired
	private OportunidadRepository<?> repository;

	@Transactional
	public List<Oportunidad> getAll() {
		return (List<Oportunidad>) repository.findAll();
	}

	@Transactional
	public Optional<Oportunidad> findByID(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public List<Oportunidad> saveAll(List<Oportunidad> entities) {
		return (List<Oportunidad>) repository.saveAll(entities);
	}

	@Transactional
	public Oportunidad save(Oportunidad entities) {
		return repository.save(entities);
	}

	@Transactional
	public Oportunidad deleteById(Integer id) {
		if (repository.existsById(id))
			repository.deleteById(id);
		return new Oportunidad();
	}

	@Transactional
	public Oportunidad deleteAll() {
		repository.deleteAll();
		return new Oportunidad();
	}
}
