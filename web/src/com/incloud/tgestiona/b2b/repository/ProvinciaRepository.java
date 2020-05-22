package com.incloud.tgestiona.b2b.repository;

import com.incloud.tgestiona.b2b.model.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinciaRepository<P> extends CrudRepository<Provincia, Integer> {
}
