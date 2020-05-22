package com.incloud.tgestiona.b2b.service.dto.isis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DireccionIntIsisDto {
    private String numero_proyecto_isis;
    private String version_oferta;
    private Integer sec_grupo;
    private Integer secuencia_direccion;
    private String departamento_codigo;
    private String provincia_codigo;
    private String codigo_ciudad;
    private String distrito_codigo;

    private String urbanizacion;
    private String via;
    private String codigo_direccion;
    private String direccion;
    private String numero;
    private String manzana;
    private String lote;
    private String piso;
    private String interior;
}