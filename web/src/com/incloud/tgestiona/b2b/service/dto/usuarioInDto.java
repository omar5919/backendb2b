package com.incloud.tgestiona.b2b.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class usuarioInDto {
	 
	private int id;
	private String usuario;
	private String clave;
	private String passwordActual;
	private String confirmPassword;
}
