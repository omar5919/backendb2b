package com.incloud.tgestiona.b2b.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.incloud.tgestiona.b2b.model.Oportunidad;

@Repository
public interface OportunidadRepository<P> extends CrudRepository<Oportunidad, Integer> {

}
