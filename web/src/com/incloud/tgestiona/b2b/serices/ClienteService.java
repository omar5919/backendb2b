package com.incloud.tgestiona.b2b.serices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.incloud.tgestiona.b2b.model.Cliente;

@Component
public interface ClienteService {

	public List<Cliente> getAll();

	public Optional<Cliente> findByID(Integer id);

	public List<Cliente> saveAll(List<Cliente> entities);

	public Cliente save(Cliente entities);

	public Cliente deleteById(Integer id);

	public Cliente deleteAll();

	public String agregarDocumentoCliente(MultipartFile file) throws Exception;

}
