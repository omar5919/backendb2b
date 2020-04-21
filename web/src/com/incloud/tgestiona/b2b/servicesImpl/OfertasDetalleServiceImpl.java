package com.incloud.tgestiona.b2b.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.incloud.tgestiona.b2b.model.OfertasDetalle;
import com.incloud.tgestiona.b2b.repository.OfertasDetalleRepository;
import com.incloud.tgestiona.b2b.serices.OfertasDetalleService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class OfertasDetalleServiceImpl implements OfertasDetalleService {

	@Autowired
	private OfertasDetalleRepository<OfertasDetalle> repository;

	@Transactional
	public List<OfertasDetalle> getAll() {
		return (List<OfertasDetalle>) repository.findAll();
	}

	@Transactional
	public Optional<OfertasDetalle> findByID(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public List<OfertasDetalle> saveAll(List<OfertasDetalle> entities) {
		return (List<OfertasDetalle>) repository.saveAll(entities);
	}

	@Transactional
	public OfertasDetalle save(OfertasDetalle entities) {
		return repository.save(entities);
	}

	@Transactional
	public OfertasDetalle deleteById(Integer id) {
		if (repository.existsById(id))
			repository.deleteById(id);
		return new OfertasDetalle();
	}

	@Transactional
	public OfertasDetalle deleteAll() {
		repository.deleteAll();
		return new OfertasDetalle();
	}

}
