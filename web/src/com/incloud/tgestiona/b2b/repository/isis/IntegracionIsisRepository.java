package com.incloud.tgestiona.b2b.repository.isis;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntegracionIsisRepository {
    @Query(value = "select * from isis.sp_isis_oferta_secuencia_grupo_sede(:p_oferta_id);", nativeQuery = true)
    List<Object[]> ofertaPorGrupoSede(@Param("p_oferta_id") Integer oferta_id);

    @Query(value = "select * from isis.sp_isis_datos_generales(:p_oferta_id);", nativeQuery = true)
    List<Object[]> datosGenerales(@Param("p_oferta_id") Integer oferta_id);

    @Query(value = "select * from isis.sp_isis_target(:p_oferta_id,:p_nombre_sede);", nativeQuery = true)
    List<Object[]> target(@Param("p_oferta_id") Integer oferta_id,@Param("p_nombre_sede") String nombre_sede);

    @Query(value = "select * from isis.sp_isis_direccion(:p_oferta_id,:p_nombre_sede);", nativeQuery = true)
    List<Object[]> direccion(@Param("p_oferta_id") Integer oferta_id,@Param("p_nombre_sede") String nombre_sede);

    @Query(value = "select * from isis.sp_isis_grupo_parametros(:p_oferta_id,:p_nombre_sede,:p_oferta_isis,:p_version_isis);", nativeQuery = true)
    List<Object[]> gruposParametros(@Param("p_oferta_id") Integer oferta_id,
                                    @Param("p_nombre_sede") String nombre_sede,
                                    @Param("p_oferta_isis") String oferta_isis,
                                    @Param("p_version_isis") String version_isis);

    @Query(value = "select * from isis.sp_isis_equipos_noestandar(:p_oferta_id,:p_nombre_sede);", nativeQuery = true)
    List<Object[]> equipoNoEstandar(@Param("p_oferta_id") Integer oferta_id,@Param("p_nombre_sede") String nombre_sede);

    @Query(value = "select * from isis.sp_isis_equipos_estandar(:p_oferta_id,:p_nombre_sede);", nativeQuery = true)
    List<Object[]> equipoEstandar(@Param("p_oferta_id") Integer oferta_id,@Param("p_nombre_sede") String nombre_sede);

    @Query(value = "select * from isis.sp_isis_implantacion_noestandar(:p_oferta_id,:p_nombre_sede);", nativeQuery = true)
    List<Object[]> implantacionNoEstandar(@Param("p_oferta_id") Integer oferta_id,@Param("p_nombre_sede") String nombre_sede);

    @Query(value = "select * from isis.sp_isis_tarifario(:p_oferta_id,:p_nombre_sede);", nativeQuery = true)
    List<Object[]> tarifario(@Param("p_oferta_id") Integer oferta_id,@Param("p_nombre_sede") String nombre_sede);
}
