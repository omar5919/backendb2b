package com.incloud.tgestiona.b2b.service.dto.isis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DireccionIntIsisDto {
    private String proyecto;
    private String version;
    private Integer sec_grupo;
    private Integer sec_direccion;
    private String cod_departamento;
    private String cod_provincia;
    private String cod_ciudad;
    private String cod_distrito;

    private String cod_urbanizacion;
    private String cod_via;
    private String codigo;
    private String direccion;
    private String numero;
    private String manzana;
    private String lote;
    private String piso;
    private String interior;
}