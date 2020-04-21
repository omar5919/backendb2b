package com.incloud.tgestiona.b2b.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.incloud.tgestiona.b2b.model.ContactoSede;
import com.incloud.tgestiona.b2b.repository.ContactoSedeRepository;
import com.incloud.tgestiona.b2b.serices.ContactoSedeService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ContactoSedeServiceImpl implements ContactoSedeService {

	@Autowired
	private ContactoSedeRepository<ContactoSede> repository;

	@Transactional
	public List<ContactoSede> getAll() {
		return (List<ContactoSede>) repository.findAll();
	}

	@Transactional
	public Optional<ContactoSede> findByID(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public List<ContactoSede> saveAll(List<ContactoSede> entities) {
		return (List<ContactoSede>) repository.saveAll(entities);
	}

	@Transactional
	public ContactoSede save(ContactoSede entities) {
		return repository.save(entities);
	}

	@Transactional
	public ContactoSede deleteById(Integer id) {
		if (repository.existsById(id))
			repository.deleteById(id);
		return new ContactoSede();
	}

	@Transactional
	public ContactoSede deleteAll() {
		repository.deleteAll();
		return new ContactoSede();
	}
}
