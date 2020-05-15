package com.incloud.tgestiona.b2b.repository;

import com.incloud.tgestiona.b2b.model.Distrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DistritoRepository extends JpaRepository<Distrito, Integer>, JpaSpecificationExecutor<Distrito> {
    @Query(value = "select * from oferta.sp_filtrar_distrito(:pbuscar);", nativeQuery = true)
    List<Object[]> buscarDistrito(@Param("pbuscar") String buscar);
}
