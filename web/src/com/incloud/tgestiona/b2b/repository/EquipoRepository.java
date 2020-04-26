package com.incloud.tgestiona.b2b.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.incloud.tgestiona.b2b.model.Equipo;

@Repository
public interface EquipoRepository<P> extends CrudRepository<Equipo, Integer>  {

}
