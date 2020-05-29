package com.incloud.tgestiona.b2b.service.dto.isis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipoNoStandarIntIsisDto {
    private String proyecto;
    private String version;
    private Integer sec_grupo;
    private Integer sec_direccion;
    private Integer sec_prod;
    private String cod_prod;
    private String destino;
    private String tipo_de_equipo;
    private String descripcion;
    private Integer anos_de_contrato;
}