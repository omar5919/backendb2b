package com.incloud.tgestiona.b2b.service.dto.isis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImplantacionNoStandarIntIsisDto {
    private String numero_proyecto_sdio;
    private String version_oferta;
    private Integer sec_grupo;
    private Integer sec_direccion;
    private Integer sec_producto;
    private String producto;
    private String tipo_compra;
    private String codigo;
    private String descripcion;
    private Integer cantidad;
    private Integer moneda;
    private String codigo_tarifa;
    private String seq_tarifa;
}