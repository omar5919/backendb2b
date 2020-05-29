package com.incloud.tgestiona.b2b.service.dto.isis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImplantacionNoStandarIntIsisDto {
    private String proyecto;
    private String version;
    private Integer sec_grupo; 
    private Integer sec_direccion;
    private Integer sec_prod;
    private String cod_prod;
    private String tipo_estudio;
    private String codigo_sisego;
    private String descripcion;
    private Integer cantidad;
    private Integer moneda;
    private String codigo_tarifa;
    private Integer secuencia_tarifa;
}