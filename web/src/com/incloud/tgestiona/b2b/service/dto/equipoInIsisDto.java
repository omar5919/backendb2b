package com.incloud.tgestiona.b2b.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class equipoInIsisDto {

	private String url;
	private int tipo;
	private String usuario;
	private String fecha;
}