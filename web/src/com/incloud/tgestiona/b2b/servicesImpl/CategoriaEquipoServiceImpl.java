package com.incloud.tgestiona.b2b.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.incloud.tgestiona.b2b.model.CategoriaEquipo;
import com.incloud.tgestiona.b2b.repository.CategoriaEquipoRepository;
import com.incloud.tgestiona.b2b.serices.CategoriaEquipoService;

//@Service("CategoriaEquipoServiceImpl")
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class CategoriaEquipoServiceImpl implements CategoriaEquipoService {

	@Autowired
	private CategoriaEquipoRepository<CategoriaEquipo> repository;

	@Transactional
	public List<CategoriaEquipo> getAll() {
		return (List<CategoriaEquipo>) repository.findAll();
	}

	@Transactional
	public Optional<CategoriaEquipo> findByID(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public List<CategoriaEquipo> saveAll(List<CategoriaEquipo> entities) {
		return (List<CategoriaEquipo>) repository.saveAll(entities);
	}

	@Transactional
	public CategoriaEquipo save(CategoriaEquipo entities) {
		return repository.save(entities);
	}

	@Transactional
	public CategoriaEquipo deleteById(Integer id) {
		if (repository.existsById(id))
			repository.deleteById(id);
		return new CategoriaEquipo();
	}

	@Transactional
	public CategoriaEquipo deleteAll() {
		repository.deleteAll();
		return new CategoriaEquipo();
	}
}