package com.incloud.tgestiona.b2b.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfertasCapexDto {
    private Integer id;
    private Boolean activo;
    private Integer antiguedad;
    private Integer cantidad;
    private String modelo;
    private BigDecimal total;
    private BigDecimal unitario;
    private Integer condicion;
    private Integer marca;
    private Integer moneda;
    private Integer tipo;
    private Integer idoferta;
}