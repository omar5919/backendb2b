package com.incloud.tgestiona.b2b.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfertaReq {
    private Integer poferta_id;
    private Integer pcliente_id;
    private Integer poportunidad_id;
    private String pcontacto;
    private String ptelefono_contacto;
    private String pcorreo_contacto;
    private String pnumero_caso_salesforce;
    private String pdescripcion;
    private Integer ppreventa_id;
    private Integer ptipo_proyecto_id;
    private Integer pcomplejidad_id;
    private Integer ptipo_contrato_id;
    private Integer ptiempo_implantacion;
    private Integer pperiodo_contrato;
    private Integer pmoneda_id;
    private BigDecimal ppago_unico;
    private BigDecimal ppago_recurrente;
    private BigDecimal ppago_recurrente_actual;
    private String pobservaciones;
    private String pusuario;
}
