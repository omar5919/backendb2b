package com.incloud.tgestiona.b2b.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import com.incloud.tgestiona.b2b.model.Ofertas;
import com.incloud.tgestiona.b2b.repository.OfertaRepository;
import com.incloud.tgestiona.b2b.serices.OfertaService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class OfertaServiceImpl implements OfertaService {

	@Autowired
	private OfertaRepository<Ofertas> repository;

	@Transactional
	public List<Ofertas> getAll() {
		return (List<Ofertas>) repository.findAll();
	}

	@Transactional
	public Optional<Ofertas> findByID(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public List<Ofertas> saveAll(List<Ofertas> entities) {
		return (List<Ofertas>) repository.saveAll(entities);
	}

	@Transactional
	public Ofertas save(Ofertas entities) {
		return repository.save(entities);
	}

	@Transactional
	public Ofertas deleteById(Integer id) {
		if (repository.existsById(id))
			repository.deleteById(id);
		return new Ofertas();
	}

	@Transactional
	public Ofertas deleteAll() {
		repository.deleteAll();
		return new Ofertas();
	}
}
