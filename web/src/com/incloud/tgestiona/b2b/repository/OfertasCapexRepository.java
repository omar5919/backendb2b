package com.incloud.tgestiona.b2b.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.incloud.tgestiona.b2b.model.oferta.OfertasCapex;

import java.math.BigDecimal;

@Repository
public interface OfertasCapexRepository  extends JpaRepository<OfertasCapex, Integer>, JpaSpecificationExecutor<OfertasCapex>  {
    @Procedure("sp_guardar_capex")
    int guardarCapex(
            Integer pcapex_id,
            Boolean pactivo,
            Integer pantiguedad,
            Integer pcantidad,
            String pmodelo,
            BigDecimal ptotal,
            BigDecimal punitario,
            Integer pcondicion_id,
            Integer pmarca_id,
            Integer pmoneda_id,
            Integer ptipo_id,
            Integer poferta_id
    );
}