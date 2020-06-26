package com.incloud.tgestiona.b2b.repository;

import com.incloud.tgestiona.b2b.model.finanza.FlujoCaja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface FinanzasRepository extends JpaRepository<FlujoCaja, Integer> {
    @Query(value = "select * from finanzas.sp_obtener_flujocaja(:poferta_id);", nativeQuery = true)
    List<Object[]> obtenerFlujoCaja(@Param("poferta_id") Integer poferta_id);

    @Query(value = "select * from finanzas.sp_obtener_matriz_escalamiento();", nativeQuery = true)
    List<Object[]> obtenerMatrizEscalamiento();

    @Query(value = "select * from finanzas.sp_obtener_parametros();", nativeQuery = true)
    List<Object[]> obtenerParametros();

    @Query(value = "select * from finanzas.sp_actualizar_parametro(:pparametro_id,:pvalor,:pusuario_id,:pusuario);", nativeQuery = true)
    Integer guardarparametro(@Param("pparametro_id") Integer pparametro_id,
                             @Param("pvalor") BigDecimal pvalor,
                             @Param("pusuario_id") Integer pusuario_id,
                             @Param("pusuario") String pusuario);

    @Query(value = "select * from finanzas.sp_guardar_parametro_oferta(:pparametro_oferta_id,:poferta_id,:pparametro_id,:pconcepto_id,:pdescripcion,:pnombre,:pvalor,:pusuario_id);", nativeQuery = true)
    Integer guardarparametrooferta(@Param("pparametro_oferta_id") Integer pparametro_oferta_id,
                                   @Param("poferta_id") Integer poferta_id,
                                   @Param("pparametro_id") Integer pparametro_id,
                                   @Param("pconcepto_id") Integer pconcepto_id,
                                   @Param("pdescripcion") String pdescripcion,
                                   @Param("pnombre") String pnombre,
                                   @Param("pvalor") BigDecimal pvalor,
                                   @Param("pusuario_id") Integer pusuario_id
    );

    @Query(value = "select * from finanzas.sp_obtener_cmi(:poferta_id);", nativeQuery = true)
    List<Object[]> obtenerCmi(@Param("poferta_id") Integer poferta_id);

    @Query(value = "select * from finanzas.sp_guardar_matriz_escalamiento(:pmatriz_escalamiento_id,:paprobador,:pfullcontracvalue,:pvanvaimayor,:pvanvaimenor,:ppaybackmayor,:ppaybackmenor,:pusuario_id);", nativeQuery = true)
    Integer guardarmatrizescalamiento(
            @Param("pmatriz_escalamiento_id") Integer pmatriz_escalamiento_id,
            @Param("paprobador") String paprobador,
            @Param("pfullcontracvalue") BigDecimal pfullcontracvalue,
            @Param("pvanvaimayor") BigDecimal pvanvaimayor,
            @Param("pvanvaimenor") BigDecimal pvanvaimenor,
            @Param("ppaybackmayor") BigDecimal ppaybackmayor,
            @Param("ppaybackmenor") BigDecimal ppaybackmenor,
            @Param("pusuario_id") Integer pusuario_id
    );
    
    @Query(value = "select * from finanzas.flujocaja_genera_calculos_cmi_carga(:p_oferta_id);", nativeQuery = true)
    List<Object[]> flujocaja_genera_calculos_cmi_carga(@Param("p_oferta_id") Integer poferta_id);
    
    @Query(value = "select * from finanzas.flujocaja_genera_calculos_cmi_consolidado(:p_oferta_id);", nativeQuery = true)
    List<Object[]> flujocaja_genera_calculos_cmi_consolidado(@Param("p_oferta_id") Integer poferta_id);
}
