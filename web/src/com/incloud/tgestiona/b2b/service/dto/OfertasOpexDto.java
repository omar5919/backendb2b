package com.incloud.tgestiona.b2b.service.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.incloud.tgestiona.b2b.model.ConceptosOpex;
import com.incloud.tgestiona.b2b.model.Moneda;
import com.incloud.tgestiona.b2b.model.oferta.Ofertas;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OfertasOpexDto {
    private Integer id;
    private Boolean activo;
	private Integer cantidad;
	private BigDecimal factor;
	private Integer meses;
	private String nombre;
	private BigDecimal totalMensual;
	private BigDecimal unitarioMensual;
	private Integer conceptoId;
	private Integer moneda_id;
    private Integer ofertaId;
}
