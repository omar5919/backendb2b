package com.incloud.tgestiona.b2b.service.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.incloud.tgestiona.b2b.model.AccionIsis;
import com.incloud.tgestiona.b2b.model.Cliente;
import com.incloud.tgestiona.b2b.model.TipoCircuito;
import com.incloud.tgestiona.b2b.model.oferta.Ofertas;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OfertasDetalleDto {

	
	private Integer ofertasDetalleId; 
 	private Integer ofertaId;	   
    private Integer clienteId; 
	private Integer secuencia;
	private String nombreSede; 
	private String direccion;
	private Integer departamentoId;	
	private Integer provinciaId;	
	private Integer distritoId;
	private String latitud;	
	private String longitud;
	private String zoom;	
	private String contacto;	
	private String telefono;
	
	private String tipoCircuitoActual;
	private String numeroCdActual;
	private Integer tipoServicioIdActual;
	
	private String bwActualActual;
	private String caudalBronceActual;
	private String caudal_plata_actual;
	private String caudalOroActual;
	private String caudalPlatinumActual;
	private String caudalVozActual;
	private String caudalVideoActual;
	private String caudalLdnActual;
	private Integer ultimaMillaActual;
	private String routerSwitchActual;
	private Integer dteActual;
	private String equipo_adicional_actual;
	private String equipoTerminalActual;
	private String recursoTransporteActual;
	private String tipoAntenaActual;
	private Integer segmentoSatelitalActual;
	private String pozoTierraActual;
	private String upsActual;
	private BigDecimal facturacion_actual;
	private String vrf_actual;
	private String ofertaIsisPropuesto;
		
	private Integer accionIsisIdPropuesto;
	private Integer tipoCircuitoIdPropuesto;
	private Integer tipoServicioIdPropuesto;
		
	private String svaPropuesto;
	private String descripcionSvaPropuesto;
	private String bwPropuesto;
	private String caudalBroncePropuesto;
	private String caudalPlataPropuesto;
	private String caudalOroPropuesto;
	private String caudalPlatinumPropuesto;
	private String caudalVozPropuesto;
	private String caudalVideoPropuesto;
	private String CaudalLdnPropuesto;
	
	private Integer viaAccesoIdPropuesto;
	
	private String equipoTerminalPropuesto;
	private String routerPropuesto;
	private String equipoStockPropuesto;
	private String fechaLlegadaPropuesto;
	private String otrosEquiposPropuesto;
	private String componentesPropuesto;
	private String vrfPropuesto;
		
	private String detalleAccionEnlacePropuesto;
	private String observacionesPropuesto;
	private BigDecimal precioPropuesto;
	private String codigoSisego;
	private String zonaSisego;
	
	//@Column(name = "sisego_condicion_id" )
	//private Integer sisegoCondicionId;
	
	//@Column(name = "antiguedad" )
	//private Integer antiguedad;
	
	
	//@Column(name = "antiguedad_costo")
	//private BigDecimal antiguedadCosto;
	
	//@Column(name = "valor_residual" )
	//private BigDecimal valorResidual;
	
	private Integer diasEjecucion;
	private BigDecimal costoUltimaMilla;
	
	
	//@Column(name = "costo_transmision")
	//private BigDecimal costoTransmision;
	
	
	//@Column(name = "costo_planta_externa" )
	//private BigDecimal costoPlantaExterna;


	//@Column(name = "costo_opex")
	//private BigDecimal costoOpex;

	private Boolean activo;
	

	

}
