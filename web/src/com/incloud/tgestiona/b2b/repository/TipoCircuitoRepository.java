package com.incloud.tgestiona.b2b.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.incloud.tgestiona.b2b.model.TipoCircuito;

@Repository
public interface TipoCircuitoRepository<P> extends CrudRepository<TipoCircuito, Integer> {

}
