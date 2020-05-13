package com.incloud.tgestiona.b2b.repository;

import com.incloud.tgestiona.b2b.model.oferta.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio,Integer>, JpaSpecificationExecutor<Servicio> {

}
