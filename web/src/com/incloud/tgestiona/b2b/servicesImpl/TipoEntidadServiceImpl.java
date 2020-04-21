package com.incloud.tgestiona.b2b.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.incloud.tgestiona.b2b.model.TipoEntidad;
import com.incloud.tgestiona.b2b.repository.TipoEntidadRepository;
import com.incloud.tgestiona.b2b.serices.TipoEntidadService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class TipoEntidadServiceImpl implements TipoEntidadService {

	@Autowired
	private TipoEntidadRepository<TipoEntidad> repository;

	@Transactional
	public List<TipoEntidad> getAll() {
		return (List<TipoEntidad>) repository.findAll();
	}

	@Transactional
	public Optional<TipoEntidad> findByID(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public List<TipoEntidad> saveAll(List<TipoEntidad> entities) {
		return (List<TipoEntidad>) repository.saveAll(entities);
	}

	@Transactional
	public TipoEntidad save(TipoEntidad entities) {
		return repository.save(entities);
	}

	@Transactional
	public TipoEntidad deleteById(Integer id) {
		if (repository.existsById(id))
			repository.deleteById(id);
		return new TipoEntidad();
	}

	@Transactional
	public TipoEntidad deleteAll() {
		repository.deleteAll();
		return new TipoEntidad();
	}

}
