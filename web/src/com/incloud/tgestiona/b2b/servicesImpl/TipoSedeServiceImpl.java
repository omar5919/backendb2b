package com.incloud.tgestiona.b2b.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.incloud.tgestiona.b2b.model.TipoSede;
import com.incloud.tgestiona.b2b.repository.TipoSedeRepository;
import com.incloud.tgestiona.b2b.serices.TipoSedeService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class TipoSedeServiceImpl implements TipoSedeService {

	@Autowired
	private TipoSedeRepository<TipoSede> repository;

	@Transactional
	public List<TipoSede> getAll() {
		return (List<TipoSede>) repository.findAll();
	}

	@Transactional
	public Optional<TipoSede> findByID(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public List<TipoSede> saveAll(List<TipoSede> entities) {
		return (List<TipoSede>) repository.saveAll(entities);
	}

	@Transactional
	public TipoSede save(TipoSede entities) {
		return repository.save(entities);
	}

	@Transactional
	public TipoSede deleteById(Integer id) {
		if (repository.existsById(id))
			repository.deleteById(id);
		return new TipoSede();
	}
	
	@Transactional
	public TipoSede deleteAll() {
		repository.deleteAll();
		return new TipoSede();
	}

}
