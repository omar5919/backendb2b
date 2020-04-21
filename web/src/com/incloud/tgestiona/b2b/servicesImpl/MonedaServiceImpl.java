package com.incloud.tgestiona.b2b.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.incloud.tgestiona.b2b.model.Moneda;
import com.incloud.tgestiona.b2b.repository.MonedaRepository;
import com.incloud.tgestiona.b2b.serices.MonedaService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class MonedaServiceImpl implements MonedaService {

	@Autowired
	private MonedaRepository<Moneda> repository;

	@Transactional
	public List<Moneda> getAll() {
		return (List<Moneda>) repository.findAll();
	}

	@Transactional
	public Optional<Moneda> findByID(Integer idoferta) {
		return repository.findById(idoferta);
	}

	@Transactional
	public List<Moneda> saveAll(List<Moneda> entities) {
		return (List<Moneda>) repository.saveAll(entities);
	}

	@Transactional
	public Moneda save(Moneda moneda) {
		return repository.save(moneda);
	}

	@Transactional
	public Moneda deleteById(Integer id) {
		if (repository.existsById(id))
			repository.deleteById(id);
		return new Moneda();
	}
	
	@Transactional
	public Moneda deleteAll() {
		repository.deleteAll();
		return new Moneda();
	}
}
