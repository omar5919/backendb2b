package com.incloud.tgestiona.b2b.service.dto.isis;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarifarioIntIsisDto {
    private String proyecto;
    private String version;
    private Integer sec_grupo;
    private Integer sec_direccion;
    private Integer sec_prod;
    private String cod_prod;
    private String cod_conc;
    private Integer sec_concep;
    private String tipo_pago;
    private String codigo_tarifa;
    private Integer seq_tarifa;
    private String ind_dscto;
    private String tipo_dscto;
    private BigDecimal mon_dscto;
    private String destino;
    private String origen_concepto;
}