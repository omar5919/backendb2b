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

	
		private Integer ofertaOpexId;

	  	private Integer ofertaId;
	  	private Integer conceptoId;

	    private String nombre;
	    private Integer cantidad;
	    private Integer meses;
	    private BigDecimal factor;

	    private Integer 	moneda_id;
	    private BigDecimal unitarioMensual;
	    private BigDecimal totalMensual;
	    private Boolean activo;
	     

	    
}
