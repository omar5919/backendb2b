package com.incloud.tgestiona.b2b.repository;

import com.incloud.tgestiona.b2b.model.oferta.Ofertas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
@Repository
public interface OfertasRepository extends JpaRepository<Ofertas, Integer>, JpaSpecificationExecutor<Ofertas> {
    @Procedure("sp_guardar_oferta")
    int guardarOferta(Integer poferta_id,
                      Integer pcliente_id,
                      Integer poportunidad_id,
                      String pcontacto,
                      String ptelefono_contacto,
                      String pcorreo_contacto,
                      String pnumero_caso_salesforce,
                      String pdescripcion,
                      Integer ppreventa_id,
                      Integer ptipo_proyecto_id,
                      Integer pcomplejidad_id,
                      Integer ptipo_contrato_id,
                      Integer ptiempo_implantacion,
                      Integer pperiodo_contrato,
                      Integer pmoneda_id,
                      BigDecimal ppago_unico,
                      BigDecimal ppago_recurrente,
                      BigDecimal ppago_recurrente_actual,
                      String pobservaciones,
                      String pusuario);

    @Procedure("sp_copiar_oferta")
    int copiarOferta(Integer poferta_id, Integer pusuario_id, String pusuario);

    @Procedure("sp_anular_oferta")
    int anularOferta(Integer poferta_id, Integer pusuario_id, String pusuario);

    @Procedure("sp_versionar_oferta")
    int versionarOferta(Integer poferta_id, Integer pusuario_id, String pusuario);

    @Procedure("sp_ganar_oferta")
    int ganarOferta(Integer poferta_id, Integer pusuario_id, String pusuario);

    @Procedure("sp_derivar_oferta")
    String derivarOferta(Integer poferta_id, Integer pusuario_id, Integer pestado,Integer panalistafinanciero_id);

    @Query(value = "select * from oferta.sp_reporte_plantilla_implantacion(:p_oferta_id);", nativeQuery = true)
    List<Object[]> plantillaImpantacion(@Param("p_oferta_id") Integer p_oferta_id);


}