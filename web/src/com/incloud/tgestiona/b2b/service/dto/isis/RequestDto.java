package com.incloud.tgestiona.b2b.service.dto.isis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.formula.functions.T;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
    String ofe_sdio;
    String cod_cliente;
    String cod_fact;
    String descripcion;
    String cod_oportunidad;
    String tipo_oportunidad;
    String contacto;
    String telefono;
    Integer moneda;
    String tipo;
    String usuario;
}
