package com.incloud.tgestiona.b2b.service.dto.finanzas;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlujocajaDto {
    private Integer concepto_id;
    private Integer periodo;
    private Integer anio;
    private Integer mes;
    private BigDecimal montosoles;
    private BigDecimal montodolares;
    private String nombre;
    private String parametros;
}
