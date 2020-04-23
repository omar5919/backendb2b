package com.incloud.tgestiona.b2b.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.incloud.tgestiona.b2b.model.AccionIsis;

@Repository
public interface AccionIsisRepository<P> extends CrudRepository<AccionIsis, Integer>  {

}
