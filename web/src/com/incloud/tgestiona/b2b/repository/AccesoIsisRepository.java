package com.incloud.tgestiona.b2b.repository;

import org.springframework.data.repository.CrudRepository;

import com.incloud.tgestiona.b2b.model.Cliente;
import com.incloud.tgestiona.b2b.model.isis.Acceso;

public interface AccesoIsisRepository<P> extends CrudRepository<Acceso, Integer> {

}
