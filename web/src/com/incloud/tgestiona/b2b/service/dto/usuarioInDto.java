package com.incloud.tgestiona.b2b.service.dto;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class usuarioInDto {
	private int id;
	private String usuario;
	private String clave;
	private String passwordActual;
	private String confirmPassword;
}
