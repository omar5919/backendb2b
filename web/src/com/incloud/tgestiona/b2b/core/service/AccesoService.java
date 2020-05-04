package com.incloud.tgestiona.b2b.core.service;

import javax.persistence.EntityManager;

import com.incloud.tgestiona.b2b.model.isis.IsisAcceso;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class AccesoService extends SimpleJpaRepository<IsisAcceso, Integer>{

	public AccesoService(Class<IsisAcceso> domainClass, EntityManager em) {
		super(domainClass, em);
		// TODO Auto-generated constructor stub
	}
}
