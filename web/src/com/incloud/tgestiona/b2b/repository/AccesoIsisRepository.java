package com.incloud.tgestiona.b2b.repository;

import com.incloud.tgestiona.b2b.model.isis.IsisAcceso;
import org.springframework.data.repository.CrudRepository;

public interface AccesoIsisRepository<P> extends CrudRepository<IsisAcceso, Integer> {

}
