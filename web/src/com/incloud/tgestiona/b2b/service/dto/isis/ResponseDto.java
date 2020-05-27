package com.incloud.tgestiona.b2b.service.dto.isis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    Integer proyecto;
    Integer version;
    Integer transaccion;
    Integer error_bd;
    String mensaje_transaccion;
}
