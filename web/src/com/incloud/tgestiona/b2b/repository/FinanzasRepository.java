package com.incloud.tgestiona.b2b.repository;

import com.incloud.tgestiona.b2b.model.finanza.FlujoCaja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FinanzasRepository extends JpaRepository<FlujoCaja,Integer> {
    @Query(value = "select * from finanzas.sp_obtener_flujocaja(:poferta_id);", nativeQuery = true)
    List<Object[]> obtenerFlujoCaja(@Param("poferta_id") Integer poferta_id);
}
