package com.incloud.tgestiona.b2b.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.incloud.tgestiona.b2b.model.oferta.Ofertas;
import com.incloud.tgestiona.b2b.model.oferta.OfertasDetalle;

import java.math.BigDecimal;

@Repository
public interface OfertasDetalleRepository  extends JpaRepository<OfertasDetalle, Integer>, JpaSpecificationExecutor<OfertasDetalle>  {
    @Procedure("sp_guardar_servicio")
    int guardarServicio();
}
