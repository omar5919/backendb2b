package com.incloud.tgestiona.b2b.service.dto.isis;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TargetIntIsisDto {
    private String proyecto;
    private String version;
    private BigDecimal pago_unico;
    private BigDecimal pago_recurrente;
}