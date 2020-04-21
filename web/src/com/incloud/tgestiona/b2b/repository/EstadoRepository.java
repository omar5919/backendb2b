package com.incloud.tgestiona.b2b.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.incloud.tgestiona.b2b.model.Estado;

@Repository
public interface EstadoRepository<P> extends CrudRepository<Estado, Integer> {

}
