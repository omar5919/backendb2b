package com.incloud.tgestiona.b2b.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.incloud.tgestiona.b2b.model.Cliente;
import com.incloud.tgestiona.b2b.repository.ClienteRepository;
import com.incloud.tgestiona.b2b.serices.ClienteService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository<Cliente> repository;

	@Transactional
	public List<Cliente> getAll() {
		return (List<Cliente>) repository.findAll();
	}

	@Transactional
	public Optional<Cliente> findByID(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	public List<Cliente> saveAll(List<Cliente> entities) {
		return (List<Cliente>) repository.saveAll(entities);
	}

	@Transactional
	public Cliente save(Cliente entities) {
		return repository.save(entities);
	}

	@Transactional
	public Cliente deleteById(Integer id) {
		if (repository.existsById(id))
			repository.deleteById(id);
		return new Cliente();
	}

	@Transactional
	public Cliente deleteAll() {
		repository.deleteAll();
		return new Cliente();
	}

	@Transactional
	public String agregarDocumentoCliente(MultipartFile file) throws Exception {
		System.out.println("Adjuntando..." + file);
		return "OK";
	}

}
