package com.incloud.tgestiona.b2b.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.incloud.tgestiona.b2b.model.oferta.OfertasDetalle;

@Repository
public interface OfertasDetalleRepository<P> extends CrudRepository<OfertasDetalle, Integer> {

}
