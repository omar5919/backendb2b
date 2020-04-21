package com.incloud.tgestiona.b2b.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.incloud.tgestiona.b2b.model.AccionIsis;
import com.incloud.tgestiona.b2b.repository.AccionIsisRepository;
import com.incloud.tgestiona.b2b.serices.AccionIsisService;

//@Service("AccionIsisServiceImpl")
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class AccionIsisServiceImpl implements AccionIsisService {

	@Autowired
	private AccionIsisRepository<AccionIsis> repository;

	@Transactional
	public List<AccionIsis> getAll() {
		return (List<AccionIsis>) repository.findAll();
	}

	@Transactional
	public Optional<AccionIsis> findByID(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public List<AccionIsis> saveAll(List<AccionIsis> entities) {
		return (List<AccionIsis>) repository.saveAll(entities);
	}

	@Transactional
	public AccionIsis save(AccionIsis entities) {
		return repository.save(entities);
	}

	@Transactional
	public AccionIsis deleteById(Integer id) {
		if (repository.existsById(id))
			repository.deleteById(id);
		return new AccionIsis();

	}

	@Transactional
	public AccionIsis deleteAll() {
		repository.deleteAll();
		return new AccionIsis();
	}
}
