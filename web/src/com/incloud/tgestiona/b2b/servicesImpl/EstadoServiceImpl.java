package com.incloud.tgestiona.b2b.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.incloud.tgestiona.b2b.model.Estado;
import com.incloud.tgestiona.b2b.repository.EstadoRepository;
import com.incloud.tgestiona.b2b.serices.EstadoService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class EstadoServiceImpl implements EstadoService {

	@Autowired
	private EstadoRepository<?> repository;

	@Transactional
	public List<Estado> getAll() {
		return (List<Estado>) repository.findAll();
	}

	@Transactional
	public Optional<Estado> findByID(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public List<Estado> saveAll(List<Estado> entities) {
		return (List<Estado>) repository.saveAll(entities);
	}

	@Transactional
	public Estado save(Estado entities) {
		return repository.save(entities);
	}

	@Transactional
	public Estado deleteById(Integer id) {
		if (repository.existsById(id))
			repository.deleteById(id);
		return new Estado();
	}

	@Transactional
	public Estado deleteAll() {
		repository.deleteAll();
		return new Estado();
	}

}
