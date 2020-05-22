package com.incloud.tgestiona.b2b.service.dto.isis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipoNoStandarIntIsisDto {
    private String numero_proyecto_sdio;
    private String version_oferta;
    private Integer sec_grupo;
    private Integer sec_direccion;
    private Integer sec_producto;
    private String producto;
    private String destino;
    private String tipo_equipo;
    private String codigo_equipo_std;
    private Integer anio_contrato;
}