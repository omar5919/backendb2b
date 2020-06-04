package com.incloud.tgestiona.b2b.service.dto.finanzas;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CmiDto {
    private String linea;
    private String sublinea;
    private String servicio;
    private String producto;
    private BigDecimal porcentaje;
}
