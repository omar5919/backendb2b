package com.incloud.tgestiona.b2b.core.service;

import javax.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import com.incloud.tgestiona.b2b.model.isis.Acceso;

public class AccesoService extends SimpleJpaRepository<Acceso, Integer>{

	public AccesoService(Class<Acceso> domainClass, EntityManager em) {
		super(domainClass, em);
		// TODO Auto-generated constructor stub
	}
}
