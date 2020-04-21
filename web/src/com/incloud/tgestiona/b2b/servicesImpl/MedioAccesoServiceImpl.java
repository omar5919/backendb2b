package com.incloud.tgestiona.b2b.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.incloud.tgestiona.b2b.model.MedioAcceso;
import com.incloud.tgestiona.b2b.repository.MedioAccesoRepository;
import com.incloud.tgestiona.b2b.serices.MedioAccesoService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class MedioAccesoServiceImpl implements MedioAccesoService {

	@Autowired
	private MedioAccesoRepository<?> repository;

	@Transactional
	public List<MedioAcceso> getAll() {
		return (List<MedioAcceso>) repository.findAll();
	}

	@Transactional
	public Optional<MedioAcceso> findByID(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public List<MedioAcceso> saveAll(List<MedioAcceso> entities) {
		return (List<MedioAcceso>) repository.saveAll(entities);
	}

	@Transactional
	public MedioAcceso save(MedioAcceso entities) {
		return repository.save(entities);
	}

	@Transactional
	public MedioAcceso deleteById(Integer id) {
		if (repository.existsById(id))
			repository.deleteById(id);
		return new MedioAcceso();
	}

	@Transactional
	public MedioAcceso deleteAll() {
		repository.deleteAll();
		return new MedioAcceso();
	}
}