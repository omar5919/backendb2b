package com.incloud.tgestiona.b2b.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.incloud.tgestiona.b2b.model.TipoContrato;
import com.incloud.tgestiona.b2b.repository.TipoContratoRepository;
import com.incloud.tgestiona.b2b.serices.TipoContratoService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class TipoContratoServiceImpl implements TipoContratoService {

	@Autowired
	private TipoContratoRepository<TipoContrato> repository;

	@Transactional
	public List<TipoContrato> getAll() {
		return (List<TipoContrato>) repository.findAll();
	}

	@Transactional
	public Optional<TipoContrato> findByID(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public List<TipoContrato> saveAll(List<TipoContrato> entities) {
		return (List<TipoContrato>) repository.saveAll(entities);
	}

	@Transactional
	public TipoContrato save(TipoContrato entities) {
		return repository.save(entities);
	}

	@Transactional
	public TipoContrato deleteById(Integer id) {
		if (repository.existsById(id))
			repository.deleteById(id);
		return new TipoContrato();
	}

	@Transactional
	public TipoContrato deleteAll() {
		repository.deleteAll();
		return new TipoContrato();
	}
}