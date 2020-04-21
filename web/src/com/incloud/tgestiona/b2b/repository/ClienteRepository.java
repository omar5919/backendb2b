package com.incloud.tgestiona.b2b.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.incloud.tgestiona.b2b.model.Cliente;

@Repository
public interface ClienteRepository<P> extends CrudRepository<Cliente, Integer> {

	// public String agregarDocumentoCliente(MultipartFile file) throws Exception;

}
