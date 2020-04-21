package com.incloud.tgestiona.b2b.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.incloud.tgestiona.b2b.model.Ubigeo;
import com.incloud.tgestiona.b2b.repository.UbigeoRepository;
import com.incloud.tgestiona.b2b.serices.UbigeoService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UbigeoServiceImpl implements UbigeoService {

	@Autowired
	private UbigeoRepository<Ubigeo> repository;

	@Transactional
	public List<Ubigeo> getAll() {
		return (List<Ubigeo>) repository.findAll();
	}

	@Transactional
	public Optional<Ubigeo> findByID(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public List<Ubigeo> saveAll(List<Ubigeo> entities) {
		return (List<Ubigeo>) repository.saveAll(entities);
	}

	@Transactional
	public Ubigeo save(Ubigeo entities) {
		return repository.save(entities);
	}

	@Transactional
	public Ubigeo deleteById(Integer id) {
		if (repository.existsById(id))
			repository.deleteById(id);
		return new Ubigeo();
	}

	@Transactional
	public Ubigeo deleteAll() {
		repository.deleteAll();
		return new Ubigeo();
	}

}
