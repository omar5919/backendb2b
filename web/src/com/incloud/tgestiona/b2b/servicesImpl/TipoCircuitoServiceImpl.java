package com.incloud.tgestiona.b2b.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.incloud.tgestiona.b2b.model.TipoCircuito;
import com.incloud.tgestiona.b2b.repository.TipoCircuitoRepository;
import com.incloud.tgestiona.b2b.serices.TipoCircuitoService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class TipoCircuitoServiceImpl implements TipoCircuitoService {

	@Autowired
	private TipoCircuitoRepository<TipoCircuito> repository;

	@Transactional
	public List<TipoCircuito> getAll() {
		return (List<TipoCircuito>) repository.findAll();
	}

	@Transactional
	public Optional<TipoCircuito> findByID(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public List<TipoCircuito> saveAll(List<TipoCircuito> entities) {
		return (List<TipoCircuito>) repository.saveAll(entities);
	}

	@Transactional
	public TipoCircuito save(TipoCircuito entities) {
		return repository.save(entities);
	}

	@Transactional
	public TipoCircuito deleteById(Integer id) {
		if (repository.existsById(id))
			repository.deleteById(id);
		return new TipoCircuito();
	}
	
	@Transactional
	public TipoCircuito deleteAll() {
		repository.deleteAll();
		return new TipoCircuito();
	}
	
	

}
