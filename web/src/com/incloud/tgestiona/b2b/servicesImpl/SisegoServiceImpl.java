package com.incloud.tgestiona.b2b.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.incloud.tgestiona.b2b.model.Sisego;
import com.incloud.tgestiona.b2b.repository.SisegoRepository;
import com.incloud.tgestiona.b2b.serices.SisegoService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class SisegoServiceImpl implements SisegoService {

	@Autowired
	private SisegoRepository<Sisego> repository;

	@Transactional
	public List<Sisego> getAll() {
		return (List<Sisego>) repository.findAll();
	}

	@Transactional
	public Optional<Sisego> findByID(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public List<Sisego> saveAll(List<Sisego> entities) {
		return (List<Sisego>) repository.saveAll(entities);
	}

	@Transactional
	public Sisego save(Sisego entities) {
		return repository.save(entities);
	}

	@Transactional
	public Sisego deleteById(Integer id) {
		if (repository.existsById(id))
			repository.deleteById(id);
		return new Sisego();
	}

	@Transactional
	public Sisego deleteAll() {
		repository.deleteAll();
		return new Sisego();
	}

}
