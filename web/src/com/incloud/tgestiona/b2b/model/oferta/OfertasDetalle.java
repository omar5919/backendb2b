package com.incloud.tgestiona.b2b.model.oferta;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.incloud.tgestiona.b2b.model.AccionIsis;
import com.incloud.tgestiona.b2b.model.Cliente;
import com.incloud.tgestiona.b2b.model.Departamento;
import com.incloud.tgestiona.b2b.model.Distrito;
import com.incloud.tgestiona.b2b.model.EquipamientoCondicion;
import com.incloud.tgestiona.b2b.model.EquipamientoMarca;
import com.incloud.tgestiona.b2b.model.Identifiable;
import com.incloud.tgestiona.b2b.model.Moneda;
import com.incloud.tgestiona.b2b.model.Provincia;
import com.incloud.tgestiona.b2b.model.TipoCircuito;
import com.incloud.tgestiona.b2b.model.TipoEquipamiento;
import com.incloud.tgestiona.domain.BaseDomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ofertas_detalle",schema = "oferta")
public class OfertasDetalle extends BaseDomain implements Identifiable<Integer>, Serializable {

	
	
	// Raw attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "ofertas_detalle_id" , updatable = false, nullable = false)
	private Integer ofertasDetalleId;
	
	
	//@Column(name = "ofertas_id",nullable = false, precision = 10).
	//@JoinColumn(name = "ofertas_id")
 	//private Integer ofertaId;	   
	
	//@Column(name = "cliente_id",nullable = false, precision = 10)
	//private Integer clienteId;
	 
	
	@Column(name = "secuencia")
	private Integer secuencia;
	
	@Column(name = "nombre_sede" )
	private String nombreSede;
	
	@Column(name = "direccion")
	private String direccion;
	
	//@Column(name = "departamento_id" )
	//private String departamentoId;
	
	//@Column(name = "provincia_id"  )
	//private String provinciaId;
	
	//@Column(name = "distrito_id" )
	//private String distritoId;

	@Column(name = "latitud")
	private String latitud;
	
	@Column(name = "longitud" )
	private String longitud;
	
	@Column(name = "zoom" )
	private String zoom;
	
	@Column(name = "contacto"  )
	private String contacto;
	
	@Column(name = "telefono")
	private String telefono;

	@Column(name = "tipo_circuito_actual" )
	private String tipoCircuitoActual;
	
	@Column(name = "numero_cd_actual" )
	private String numeroCdActual;
	
	@Column(name = "tipo_servicio_id_actual" )
	private Integer tipoServicioIdActual;

	@Column(name = "bw_actual_actual" )
	private String bwActualActual;
	
	@Column(name = "caudal_bronce_actual")
	private String caudalBronceActual;
	
	@Column(name = "caudal_plata_actual" )
	private String caudal_plata_actual;
	
	@Column(name = "caudal_oro_actual")
	private String caudalOroActual;
	
	@Column(name = "caudal_platinum_actual" )
	private String caudalPlatinumActual;
	
	@Column(name = "caudal_voz_actual" )
	private String caudalVozActual;
	
	@Column(name = "caudal_video_actual" )
	private String caudalVideoActual;
	
	@Column(name = "caudal_ldn_actual" )
	private String caudalLdnActual;


	@Column(name = "ultima_milla_actual" )
	private Integer ultimaMillaActual;
	
	@Column(name = "router_switch_actual" )
	private String routerSwitchActual;
	
	@Column(name = "dte_actual")
	private Integer dteActual;
	
	@Column(name = "equipoAdicionalActual" )
	private String equipo_adicional_actual;
	
	@Column(name = "equipo_terminal_actual"  )
	private String equipoTerminalActual;
	
	@Column(name = "recurso_transporte_actual"  )
	private String recursoTransporteActual;
	
	@Column(name = "tipo_antena_actual"  )
	private String tipoAntenaActual;
	
	@Column(name = "segmento_satelital_actual" )
	private Integer segmentoSatelitalActual;
	
	@Column(name = "pozo_tierra_actual" )
	private String pozoTierraActual;
	
	@Column(name = "ups_actual" )
	private String upsActual;
	
	@Column(name = "facturacion_actual" )
	private BigDecimal facturacion_actual;
	
	@Column(name = "vrf_actual" )
	private String vrf_actual;

	@Column(name = "oferta_isis_propuesto")
	private String ofertaIsisPropuesto;
	
	//@Column(name = "accion_id_propuesto" , precision = 10)
	//private Integer accionIdPropuesto;
   
	//@Column(name = "tipo_circuito_id_propuesto"  , precision = 10)
	//private Integer tipoCircuitoIdPropuesto;
	

	@Column(name = "tipo_servicio_id_propuesto")
	private Integer tipoServicioIdPropuesto;
	
	@Column(name = "sva_propuesto" )
	private String svaPropuesto;
	
	@Column(name = "descripcion_sva_propuesto" )
	private String descripcionSvaPropuesto;

	@Column(name = "bw_propuesto" )
	private String bwPropuesto;
	
	@Column(name = "caudal_bronce_propuesto" )
	private String caudalBroncePropuesto;
	
	@Column(name = "caudal_plata_propuesto" )
	private String caudalPlataPropuesto;
	
	@Column(name = "caudal_oro_propuesto" )
	private String caudalOroPropuesto;
	
	@Column(name = "caudal_platinum_propuesto")
	private String caudalPlatinumPropuesto;
	
	@Column(name = "caudal_voz_propuesto")
	private String caudalVozPropuesto;
	
	@Column(name = "caudal_video_propuesto" )
	private String caudalVideoPropuesto;
	
	@Column(name = "caudal_ldn_propuesto")
	private String CaudalLdnPropuesto;

	@Column(name = "via_acceso_id_propuesto" )
	private Integer viaAccesoIdPropuesto;
	
	@Column(name = "equipo_terminal_propuesto")
	private String equipoTerminalPropuesto;
	
	@Column(name = "router_propuesto" )
	private String routerPropuesto;
	
	@Column(name = "equipo_stock_propuesto" )
	private String equipoStockPropuesto;
	
	@Column(name = "fecha_llegada_propuesto" )
	private String fechaLlegadaPropuesto;
	
	@Column(name = "otros_equipos_propuesto" )
	private String otrosEquiposPropuesto;
	
	@Column(name = "componentes_propuesto" )
	private String componentesPropuesto;
	
	@Column(name = "vrf_propuesto")
	private String vrfPropuesto;
	
	@Column(name = "detalle_accion_enlace_propuesto" )
	private String detalleAccionEnlacePropuesto;
	
	@Column(name = "observaciones_propuesto")
	private String observacionesPropuesto;
	
	@Column(name = "precio_propuesto" )
	private BigDecimal precioPropuesto;

	@Column(name = "codigo_sisego" )
	private String codigoSisego;

	@Column(name = "zona_sisego")
	private String zonaSisego;
	
	//@Column(name = "sisego_condicion_id" )
	//private Integer sisegoCondicionId;
	
	//@Column(name = "antiguedad" )
	//private Integer antiguedad;
	
	
	//@Column(name = "antiguedad_costo")
	//private BigDecimal antiguedadCosto;
	
	//@Column(name = "valor_residual" )
	//private BigDecimal valorResidual;
	
	@Column(name = "dias_ejecucion" )
	private Integer diasEjecucion;
	

	@Column(name = "costo_ultima_milla" )
	private BigDecimal costoUltimaMilla;
	
	
	//@Column(name = "costo_transmision")
	//private BigDecimal costoTransmision;
	
	
	//@Column(name = "costo_planta_externa" )
	//private BigDecimal costoPlantaExterna;


	//@Column(name = "costo_opex")
	//private BigDecimal costoOpex;

	@Column(name = "activo" )
	private Boolean activo;
	

	
	
	/** relaciones **/
	@ManyToOne
    @JoinColumn(name = "oferta_id",referencedColumnName = "oferta_id")
    private Ofertas ofertas;
 
	 @ManyToOne
	 @JoinColumn(name = "cliente_id",referencedColumnName = "cliente_id")
	 private Cliente cliente;
 
	 @ManyToOne
	 @JoinColumn(name = "accion_isis_id_propuesto",referencedColumnName = "accion_isis_id")
	 private AccionIsis accionIsis;
		
	 @ManyToOne
	 @JoinColumn(name = "tipo_circuito_id_propuesto",referencedColumnName = "tipo_circuito_id")
	 private TipoCircuito tipoCircuito;
	
	 
	//@ManyToOne
	//@JoinColumn(name = "departamento_id")
	//private Departamento departamento;
	
 
	// @ManyToOne
	// @JoinColumn(name = "provincia_id")
	// private Provincia provincia;
	
 
	 @ManyToOne	 
	 @JoinColumn(name = "distrito_id")	 
	 private Distrito distrito;


	@Override
	public boolean isIdSet() {
		// TODO Auto-generated method stub
		return ofertasDetalleId!=null;
	}


	@Override
	public String entityClassName() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return ofertasDetalleId;
	}


	@Override
	public void setId(Integer id) {
		this.ofertasDetalleId=id;
		
	}
	
	
	

}
