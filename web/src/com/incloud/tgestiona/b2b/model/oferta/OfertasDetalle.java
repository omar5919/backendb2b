package com.incloud.tgestiona.b2b.model.oferta;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.logging.Logger;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import com.google.common.base.MoreObjects;
import com.incloud.tgestiona.b2b.model.AccionIsis;
import com.incloud.tgestiona.b2b.model.Cliente;
import com.incloud.tgestiona.b2b.model.Identifiable;
import com.incloud.tgestiona.b2b.model.TipoCircuito;
import com.incloud.tgestiona.domain.BaseDomain;
import com.sun.istack.NotNull;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "ofertas_detalle")
//@Audited
//@AuditTable("_audi_ofertas_detalle")
public class OfertasDetalle extends BaseDomain implements Identifiable<Integer>, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(OfertasDetalle.class.getName());

	/***************************/
	/* Atributos de la Entidad */
	/***************************/

	// Raw attributes
	@Column(name = "ofertas_detalle_id" , nullable = false, precision = 10)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer ofertasDetalleId;
	
	
	//@Column(name = "ofertas_id",nullable = false, precision = 10).
	//@JoinColumn(name = "ofertas_id")
 	//private Integer ofertaId;
	
	 
    @ManyToOne
    @JoinColumn(name = "oferta Id",referencedColumnName = "oferta Id")
    private Ofertas ofertas;
	
	//@Column(name = "cliente_id",nullable = false, precision = 10)
	//private Integer clienteId;
	
	 @ManyToOne
	 @JoinColumn(name = "cliente_id",referencedColumnName = "cliente_id")
	 private Cliente cliente;
	
	@Column(name = "secuencia",nullable = false, precision = 10)
	private Integer secuencia;
	@Column(name = "nombre_sede", length = 100  )
	private String nombreSede;
	@Column(name = "direccion", length = 400)
	private String direccion;
	@Column(name = "departamento_id" , length = 2)
	private String departamentoId;
	@Column(name = "provincia_id", length = 2  )
	private String provinciaId;
	@Column(name = "distrito_id", length = 2  )
	private String distritoId;

	@Column(name = "latidud", length = 20)
	private String latidud;
	@Column(name = "latidud", length = 20  )
	private String longitud;
	@Column(name = "zoom",  length = 1 )
	private String zoom;
	@Column(name = "contacto",length = 150  )
	private String contacto;
	@Column(name = "telefono", length = 15 )
	private String telefono;

	@Column(name = "tipo_cd_actual", length = 5 )
	private String tipoCdActual;
	@Column(name = "numero_cd_actual" )
	private String numeroCdActual;
	@Column(name = "tipo_servicio_id_actual" )
	private Integer tipoServicioIdActual;

	@Column(name = "bw_actual_actual", length = 15 )
	private String bwActualActual;
	@Column(name = "caudal_bronce_actual" , length = 20)
	private String caudalBronceActual;
	@Column(name = "caudal_plata_actual" , length = 20)
	private String caudal_plata_actual;
	@Column(name = "caudal_oro_actual", length = 20 )
	private String caudalOroActual;
	@Column(name = "caudal_platinum_actual" , length = 20)
	private String caudalPlatinumActual;
	@Column(name = "caudal_voz_actual" , length = 20)
	private String caudalVozActual;
	@Column(name = "caudal_video_actual", length = 20 )
	private String caudalVideoActual;
	@Column(name = "bw_actual_actual" , length = 20)
	private String caudalLdnActual;


	@Column(name = "ultima_milla_actual" )
	private Integer ultimaMillaActual;
	@Column(name = "router_switch_actual", length = 25 )
	private String routerSwitchActual;
	@Column(name = "dte_actual" , length = 25 )
	private Integer dteActual;
	@Column(name = "equipoAdicionalActual" , length = 25 )
	private String equipo_adicional_actual;
	@Column(name = "equipo_terminal_actual" , length = 25 )
	private String equipoTerminalActual;
	@Column(name = "recurso_transporte_actual" , length = 50 )
	private String recursoTransporteActual;
	@Column(name = "tipo_antena_actual", length = 15  )
	private String tipoAntenaActual;
	@Column(name = "segmento_satelital_actual" )
	private Integer segmentoSatelitalActual;
	@Column(name = "pozo_tierra_actual" , length = 15 )
	private String pozoTierraActual;
	@Column(name = "ups_actual" , length = 5)
	private String upsActual;
	@Column(name = "facturacion_actual" )
	private BigDecimal facturacion_actual;
	@Column(name = "vrf_actual" , length = 15)
	private String vrf_actual;

	@Column(name = "oferta_isis_propuesto" , length = 15)
	private String ofertaIsisPropuesto;
	
	//@Column(name = "accion_id_propuesto" , precision = 10)
	//private Integer accionIdPropuesto;
    @ManyToOne
    @JoinColumn(name = "accion_isis_id_propuesto",referencedColumnName = "accion_isis_id")
    private AccionIsis accionIsis;
	
	//@Column(name = "tipo_circuito_id_propuesto"  , precision = 10)
	//private Integer tipoCircuitoIdPropuesto;
	
    @ManyToOne
    @JoinColumn(name = "tipo_circuito_id",referencedColumnName = "tipo_circuito_id")
    private TipoCircuito tipoCircuito;
	
	
	@Column(name = "tipo_servicio_id_propuesto", precision = 10)
	private Integer tipoServicioIdPropuesto;
	@Column(name = "sva_propuesto" , precision = 10)
	private String svaPropuesto;
	@Column(name = "descripcion_sva_propuesto" , length = 15)
	private String descripcionSvaPropuesto;

	@Column(name = "bw_propuesto" , length = 10)
	private String bwPropuesto;
	@Column(name = "caudal_bronce_propuesto" , length = 20)
	private String caudalBroncePropuesto;
	@Column(name = "caudal_plata_propuesto" , length = 20)
	private String caudalPlataPropuesto;
	@Column(name = "caudal_oro_propuesto" , length = 20)
	private String caudalOroPropuesto;
	@Column(name = "caudal_platinum_propuesto" , length = 20)
	private String caudalPlatinumPropuesto;
	@Column(name = "caudal_voz_propuesto" , length = 20)
	private String caudalVozPropuesto;
	@Column(name = "caudal_video_propuesto" , length = 20)
	private String caudalVideoPropuesto;
	@Column(name = "sp_caudal_ldn_propuesto" , length = 20)
	private String spCaudalLdnPropuesto;

	@Column(name = "via_acceso_id_propuesto" , precision = 10)
	private Integer viaAccesoIdPropuesto;
	@Column(name = "equipo_terminal_propuesto" , length = 25)
	private String equipoTerminalPropuesto;
	@Column(name = "router_propuesto" , length = 25)
	private String routerPropuesto;
	@Column(name = "equipo_stock_propuesto" , length = 25)
	private String equipoStockPropuesto;
	@Column(name = "fecha_llegada_propuesto" , length = 10)
	private String fechaLlegadaPropuesto;
	@Column(name = "otros_equipos_propuesto" , length = 15)
	private String otrosEquiposPropuesto;
	@Column(name = "componentes_propuesto" , length = 25)
	private String componentesPropuesto;
	@Column(name = "vrf_propuesto" , length = 15)
	private String vrfPropuesto;
	@Column(name = "detalle_accion_enlace_propuesto" , length = 15)
	private String detalleAccionEnlacePropuesto;
	@Column(name = "observaciones_propuesto" , length = 200)
	private String observacionesPropuesto;
	@Digits(integer = 4, fraction = 5)
	@Column(name = "precio_propuesto" , precision = 12, scale = 4)
	private BigDecimal precioPropuesto;

	@Column(name = "codigo_sisego" , length = 20)
	private String codigoSisego;

	@Column(name = "zona_sisego" , length = 20)
	private String zonaSisego;
	@Column(name = "sisego_condicion_id" ,  precision = 10)
	private Integer sisegoCondicionId;
	@Column(name = "antiguedad" ,  precision = 10)
	private Integer antiguedad;
	@Digits(integer = 4, fraction = 5)
	@Column(name = "antiguedad_costo" , precision = 12, scale = 4)
	private BigDecimal antiguedadCosto;
	@Digits(integer = 4, fraction = 5)
	@Column(name = "valor_residual" , precision = 12, scale = 4)
	private BigDecimal valorResidual;
	@Column(name = "dias_ejecucion" ,  precision = 10)
	private Integer diasEjecucion;
	@Digits(integer = 4, fraction = 5)
	@Column(name = "costo_ultima_milla" , precision = 12, scale = 4)
	private BigDecimal costoUltimaMilla;
	@Digits(integer = 4, fraction = 5)
	@Column(name = "costo_transmision" , precision = 12, scale = 4)
	private BigDecimal costoTransmision;
	@Digits(integer = 4, fraction = 5)
	@Column(name = "costo_planta_externa" , precision = 12, scale = 4)
	private BigDecimal costoPlantaExterna;

	@Digits(integer = 4, fraction = 5)
	@Column(name = "costo_opex", precision = 12, scale = 4)
	private BigDecimal costoOpex;

	@Override
	public boolean isIdSet() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String entityClassName() {
		// TODO Auto-generated method stub
		return OfertasDetalle.class.getSimpleName();
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		
	}



	/*@Override
	public String toString() {
		return MoreObjects.toStringHelper(this) //
				.add("id", getId()) //
				.add("clienteId", getClienteId()) //
				.add("icSede", getIcSede()) //
				.add("icDireccion", getIcDireccion()) //
				.add("icDisrtito", getIcDisrtito()) //
				.add("icProvincia", getIcProvincia()) //
				.add("icDepartamento", getIcDepartamento()) //
				.add("icLatitud", getIcLatitud()) //
				.add("icLongitud", getIcLongitud()) //
				.add("icZoom", getIcZoom()) //
				.add("icDireccionmap", getIcDireccionmap()) //
				.add("icContactos", getIcContactos()) //
				.add("saConectadoa", getSaConectadoa()) //
				.add("saSede", getSaSede()) //
				.add("saTipoCircuitoId", getSaTipoCircuitoId()) //
				.add("saIdservicio", getSaIdservicio()) //
				.add("saIdmedioacceso", getSaIdmedioacceso()) //
				.add("saMedidabw", getSaMedidabw()) //
				.add("saBw", getSaBw()) //
				.add("saBwsatelital", getSaBwsatelital()) //
				.add("saLdn", getSaLdn()) //
				.add("saMedidavoz", getSaMedidavoz()) //
				.add("saCaudalvoz", getSaCaudalvoz()) //
				.add("saVozsatelital", getSaVozsatelital()) //
				.add("saMedidavideo", getSaMedidavideo()) //
				.add("saCaudalvideo", getSaCaudalvideo()) //
				.add("saVideosatelital", getSaVideosatelital()) //
				.add("saMedidaplatinium", getSaMedidaplatinium()) //
				.add("saCaudalplatinium", getSaCaudalplatinium()) //
				.add("saPlatiniumsatelital", getSaPlatiniumsatelital()) //
				.add("saMedidaoro", getSaMedidaoro()) //
				.add("saCaudaloro", getSaCaudaloro()) //
				.add("saOrosatelital", getSaOrosatelital()) //
				.add("saMedidaplata", getSaMedidaplata()) //
				.add("saCaudalplata", getSaCaudalplata()) //
				.add("saPlatasatelital", getSaPlatasatelital()) //
				.add("saMedidabronce", getSaMedidabronce()) //
				.add("saCaudalbronce", getSaCaudalbronce()) //
				.add("saBroncesatelital", getSaBroncesatelital()) //
				.add("saPma", getSaPma()) //
				.add("saEquipo1", getSaEquipo1()) //
				.add("saCosto1", getSaCosto1()) //
				.add("saImputacion1", getSaImputacion1()) //

				.add("saObservacion", getSaObservacion()) //
				.add("spAccionIsis", getSpAccionIsis()) //
				.add("spTipoSede", getSpTipoSede()) //
				.add("spCondicionCircuito", getSpCondicionCircuito()) //
				.add("spTipoCircuito", getSpTipoCircuito()) //
				.add("spNumerocd", getSpNumerocd()) //
				.add("spCircuitosconectados", getSpCircuitosconectados()) //
				.add("spServicioId", getSpServicioId()) //
				.add("spMedioAcceso", getSpMedioAcceso()) //
				.add("spTipoInstalacionSatelital", getSpTipoInstalacionSatelital()) //
				.add("spMedidabw", getSpMedidabw()) //
				.add("spBw", getSpBw()) //
				.add("spBwsatelital", getSpBwsatelital()) //
				.add("spLdn", getSpLdn()) //
				.add("spMedidavoz", getSpMedidavoz()) //
				.add("spCaudalvoz", getSpCaudalvoz()) //
				.add("spVozsatelital", getSpVozsatelital()) //
				.add("spMedidavideo", getSpMedidavideo()) //
				.add("spCaudalvideo", getSpCaudalvideo()) //
				.add("spVideosatelital", getSpVideosatelital()) //
				.add("spMedidaplatinium", getSpMedidaplatinium()) //
				.add("spCaudalplatinium", getSpCaudalplatinium()) //
				.add("spPlatiniumsatelital ", getSpPlatiniumsatelital()) //
				.add("spMedidaoro", getSpMedidaoro()) //
				.add("spCaudaloro", getSpCaudaloro()) //
				.add("spOrosatelital", getSpOrosatelital()) //
				.add("spMedidaplata", getSpMedidaplata()) //
				.add("spCaudalplata", getSpCaudalplata()) //
				.add("spPlatasatelital", getSpPlatasatelital()) //
				.add("spMedidabronce", getSpMedidabronce()) //
				.add("spCaudalbronce", getSpCaudalbronce()) //
				.add("spBroncesatelital", getSpBroncesatelital()) //
				.add("spAntiguedad", getSpAntiguedad()) //
				.add("spEquipo1", getSpEquipo1()) //
				.add("spCosto1", getSpCosto1()) //
				.add("spImputacion1", getSpImputacion1()) //

				.add("spObservacion", getSpObservacion()) //
				.add("ssCodigoSisego", getSsCodigoSisego()) //
				.add("ssCondicionSisego", getSsCondicionSisego()) //
				.add("ssAntiguedad ", getSsAntiguedad()) //
				.add("ssCostoAntiguo", getSsCostoAntiguo()) //
				.add("ssValorResidual", getSsValorResidual()) //
				.add("ssDiasejecucion", getSsDiasejecucion()) //
				.add("ssUltimamilla", getSsUltimamilla()) //
				.add("ssCostoTransmision", getSsCostoTransmision()) //
				.add("ssCostoPlantaexterna", getSsCostoPlantaexterna()) //
				.add("CostoOpex", getCostoOpex()) //
				.toString();
	}
	*/
}
