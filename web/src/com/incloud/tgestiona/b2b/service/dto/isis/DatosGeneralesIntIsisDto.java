package com.incloud.tgestiona.b2b.service.dto.isis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatosGeneralesIntIsisDto {
    private String codigo_proyecto_sdio;
    private String numero_proyecto_isis;
    private String version_oferta;
    private String codigo_cliente;
    private String codigo_facturacion;
    private String descripcion;
    private String codigo_oportunidad;
    private String tipo_oportunidad;
    private String contacto;
    private String telefono;
    private String moneda;
    private String tipo_contrato;
    private String usuario_sdio;
}
