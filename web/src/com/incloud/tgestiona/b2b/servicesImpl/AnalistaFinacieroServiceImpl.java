package com.incloud.tgestiona.b2b.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.incloud.tgestiona.b2b.model.AnalistaFinaciero;
import com.incloud.tgestiona.b2b.repository.AnalistaFinacieroRepository;
import com.incloud.tgestiona.b2b.serices.AnalistaFinacieroService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class AnalistaFinacieroServiceImpl implements AnalistaFinacieroService {

	@Autowired
	private AnalistaFinacieroRepository<AnalistaFinaciero> repository;

	@Transactional
	public List<AnalistaFinaciero> getAll() {
		return (List<AnalistaFinaciero>) repository.findAll();
	}

	@Transactional
	public Optional<AnalistaFinaciero> findByID(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public List<AnalistaFinaciero> saveAll(List<AnalistaFinaciero> entities) {
		return (List<AnalistaFinaciero>) repository.saveAll(entities);
	}

	@Transactional
	public AnalistaFinaciero save(AnalistaFinaciero entities) {
		return repository.save(entities);
	}

	@Transactional
	public AnalistaFinaciero deleteById(Integer id) {
		if (repository.existsById(id))
			repository.deleteById(id);
		return new AnalistaFinaciero();

	}

	@Transactional
	public AnalistaFinaciero deleteAll() {
		repository.deleteAll();
		return new AnalistaFinaciero();
	}
}
