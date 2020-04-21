package com.incloud.tgestiona.b2b.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.incloud.tgestiona.b2b.model.CondicicionEquipo;
import com.incloud.tgestiona.b2b.repository.CondicicionEquipoRepository;
import com.incloud.tgestiona.b2b.serices.CondicicionEquipoService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class CondicicionEquipoServiceImpl implements CondicicionEquipoService {

	@Autowired
	private CondicicionEquipoRepository<CondicicionEquipo> repository;

	@Transactional
	public List<CondicicionEquipo> getAll() {
		return (List<CondicicionEquipo>) repository.findAll();
	}

	@Transactional
	public Optional<CondicicionEquipo> findByID(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public List<CondicicionEquipo> saveAll(List<CondicicionEquipo> entities) {
		return (List<CondicicionEquipo>) repository.saveAll(entities);
	}

	@Transactional
	public CondicicionEquipo save(CondicicionEquipo entities) {
		return repository.save(entities);
	}

	@Transactional
	public CondicicionEquipo deleteById(Integer id) {
		if (repository.existsById(id))
			repository.deleteById(id);
		return new CondicicionEquipo();
	}

	@Transactional
	public CondicicionEquipo deleteAll() {
		repository.deleteAll();
		return new CondicicionEquipo();
	}

}