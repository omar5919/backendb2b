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
public class MatrizEscalamientoDto {
    private Integer matriz_escalamiento_id;
    private String aprobador;
    private BigDecimal fullcontracvalue;
    private BigDecimal vanvaimayor;
    private BigDecimal vanvaimenor;
    private BigDecimal paybackmayor;
    private BigDecimal paybackmenor;
}
