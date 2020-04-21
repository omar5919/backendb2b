package com.incloud.tgestiona.b2b.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.incloud.tgestiona.b2b.model.SegmentoNegocio;
import com.incloud.tgestiona.b2b.repository.SegmentoNegocioRepository;
import com.incloud.tgestiona.b2b.serices.SegmentoNegocioService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class SegmentoNegocioServiceImpl implements SegmentoNegocioService {

	@Autowired
	private SegmentoNegocioRepository<SegmentoNegocio> repository;

	@Transactional
	public List<SegmentoNegocio> getAll() {
		return (List<SegmentoNegocio>) repository.findAll();
	}

	@Transactional
	public Optional<SegmentoNegocio> findByID(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public List<SegmentoNegocio> saveAll(List<SegmentoNegocio> entities) {
		return (List<SegmentoNegocio>) repository.saveAll(entities);
	}

	@Transactional
	public SegmentoNegocio save(SegmentoNegocio entities) {
		return repository.save(entities);
	}

	@Transactional
	public SegmentoNegocio deleteById(Integer id) {
		if (repository.existsById(id))
			repository.deleteById(id);
		return new SegmentoNegocio();
	}

	@Transactional
	public SegmentoNegocio deleteAll() {
		repository.deleteAll();
		return new SegmentoNegocio();
	}

}
