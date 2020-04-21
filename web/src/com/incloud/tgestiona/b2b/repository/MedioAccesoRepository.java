package com.incloud.tgestiona.b2b.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.incloud.tgestiona.b2b.model.MedioAcceso;

@Repository
public interface MedioAccesoRepository<P> extends CrudRepository<MedioAcceso, Integer> {

}
