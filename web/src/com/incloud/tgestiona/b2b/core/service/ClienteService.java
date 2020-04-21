package com.incloud.tgestiona.b2b.core.service;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.incloud.tgestiona.b2b.model.Cliente;

public class ClienteService extends SimpleJpaRepository<Cliente, Integer>{

	public ClienteService(Class<Cliente> domainClass, EntityManager em) {
		super(domainClass, em);
	}

	 
}
