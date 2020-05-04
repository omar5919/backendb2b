package com.incloud.tgestiona.b2b.repository;

import com.incloud.tgestiona.b2b.model.isis.IsisEquipo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository<P> extends CrudRepository<IsisEquipo, Integer>  {

}
