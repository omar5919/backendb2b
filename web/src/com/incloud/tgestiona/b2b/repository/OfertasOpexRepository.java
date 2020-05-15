package com.incloud.tgestiona.b2b.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.incloud.tgestiona.b2b.model.oferta.OfertasOpex;

import java.math.BigDecimal;

@Repository
public interface OfertasOpexRepository  extends JpaRepository<OfertasOpex, Integer>, JpaSpecificationExecutor<OfertasOpex>  {
    @Procedure("sp_guardar_opex")
    int guardarOpex(
            Integer popex_id,
            Boolean pactivo,
            Integer pcantidad,
            BigDecimal pfactor,
            Integer pmeses,
            String pnombre,
            BigDecimal ptotal_mensual,
            BigDecimal punitario_mensual,
            Integer pconcepto_id,
            Integer pmoneda_id,
            Integer poferta_id
    );
}
