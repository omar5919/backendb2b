package com.incloud.tgestiona.b2b.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseBandejaResponse<T> {
    private String msj;
    private Long rows;
    private T data;
}
