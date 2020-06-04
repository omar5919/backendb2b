package com.incloud.tgestiona.b2b.service.dto.finanzas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParametrosOfertaDto {
    private Integer parametro_oferta_id;
    private Integer oferta_id;
    private Integer parametro_id;
    private Integer concepto_id;
    private String descripcion;
    private String nombre;
    private BigDecimal valor;
    private Integer usuario_id;
}
