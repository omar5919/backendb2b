package com.incloud.tgestiona.b2b.service.dto.isis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TargetIntIsisDto {
    private String numero_proyecto_isis;
    private String version_oferta;
    private float pago_unico;
    private float pago_recurrente;
}