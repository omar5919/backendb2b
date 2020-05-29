package com.incloud.tgestiona.b2b.service.dto.isis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatosGeneralesIntIsisDto {
    private String ofe_sdio;
   // private String numero_proyecto_isis;
   // private String version_oferta;
    private String cod_cliente;
    private String cod_fact;
    private String descripcion;
    
    private String cod_oportunidad;
    private String tipo_oportunidad;
    private String contacto;
    private String telefono;
    private String moneda;
    private String tipo;
    private String usuario;
}
