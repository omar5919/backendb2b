package com.incloud.tgestiona.b2b.service.dto.finanzas;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParametrosDto {
    private Integer parametro_id;
    private String nombre;
    protected String descripcion;
    private BigDecimal valor;
}
