package com.incloud.tgestiona.b2b.service.dto.isis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarifarioIntIsisDto {
    private String numero_proyecto_sdio;
    private String version_oferta;
    private Integer sec_grupo;
    private Integer sec_direccion;
    private Integer sec_producto;
    private String producto;
    private String concepto;
    private String sec_concepto;
    private String tipo_pago;
    private String codigo_tarifa;
    private Integer sec_tarifa;
    private String ind_dscto;
    private String tipo_dscto;
    private String codigo_clasificacion;
    private String origen_concepto;
}