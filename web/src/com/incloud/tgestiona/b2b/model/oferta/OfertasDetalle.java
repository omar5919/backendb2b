package com.incloud.tgestiona.b2b.model.oferta;

import com.incloud.tgestiona.b2b.model.*;
import com.incloud.tgestiona.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ofertas_detalle", schema = "oferta")
public class OfertasDetalle extends BaseDomain implements Identifiable<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ofertas_detalle_id", updatable = false, nullable = false)
    private Integer ofertasDetalleId;

    @Column(name = "secuencia")
    private Integer secuencia;

    @Column(name = "nombre_sede")
    private String nombreSede;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "latitud")
    private String latitud;

    @Column(name = "longitud")
    private String longitud;

    @Column(name = "zoom")
    private String zoom;

    @Column(name = "contacto")
    private String contacto;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "ubigeo")
    private String ubigeo;

    @Column(name = "numero_cd_actual")
    private String numeroCdActual;

    @Column(name = "bw_actual")
    private String bwActualActual;

    @Column(name = "caudal_bronce_actual")
    private String caudalBronceActual;

    @Column(name = "caudal_plata_actual")
    private String caudal_plata_actual;

    @Column(name = "caudal_oro_actual")
    private String caudalOroActual;

    @Column(name = "caudal_platinum_actual")
    private String caudalPlatinumActual;

    @Column(name = "caudal_voz_actual")
    private String caudalVozActual;

    @Column(name = "caudal_video_actual")
    private String caudalVideoActual;

    @Column(name = "caudal_ldn_actual")
    private String caudalLdnActual;

    @Column(name = "ultima_milla_actual")
    private Integer ultimaMillaActual;

    @Column(name = "router_actual")
    private String routerSwitchActual;

    @Column(name = "dte_actual")
    private Integer dteActual;

    @Column(name = "equipo_adicional_actual")
    private String equipo_adicional_actual;

    @Column(name = "equipo_terminal_actual")
    private String equipoTerminalActual;

    @Column(name = "recurso_transporte_actual")
    private String recursoTransporteActual;

    @Column(name = "tipo_antena_actual")
    private String tipoAntenaActual;

    @Column(name = "segmento_satelital_actual")
    private Integer segmentoSatelitalActual;

    @Column(name = "pozo_tierra_actual")
    private String pozoTierraActual;

    @Column(name = "ups_actual")
    private String upsActual;

    @Column(name = "facturacion_actual")
    private BigDecimal facturacion_actual;

    @Column(name = "vrf_actual")
    private String vrf_actual;

    @Column(name = "oferta_isis_propuesto")
    private String ofertaIsisPropuesto;

    @Column(name = "sva_propuesto")
    private String svaPropuesto;

    @Column(name = "descripcion_sva_propuesto")
    private String descripcionSvaPropuesto;

    @Column(name = "bw_propuesto")
    private String bwPropuesto;

    @Column(name = "condicion_servicio")
    private Integer condicion_servicio;

    @Column(name = "caudal_bronce_propuesto")
    private String caudalBroncePropuesto;

    @Column(name = "caudal_plata_propuesto")
    private String caudalPlataPropuesto;

    @Column(name = "numero_circuito_actual")
    private String numero_circuito_actual;

    @Column(name = "numero_circuito_propuesto")
    private String numero_circuito_propuesto;

    @Column(name = "caudal_oro_propuesto")
    private String caudalOroPropuesto;

    @Column(name = "caudal_platinum_propuesto")
    private String caudalPlatinumPropuesto;

    @Column(name = "caudal_voz_propuesto")
    private String caudalVozPropuesto;

    @Column(name = "caudal_video_propuesto")
    private String caudalVideoPropuesto;

    @Column(name = "caudal_ldn_propuesto")
    private String CaudalLdnPropuesto;

    @Column(name = "equipo_terminal_propuesto")
    private String equipoTerminalPropuesto;

    @Column(name = "router_propuesto")
    private String routerPropuesto;

    @Column(name = "equipo_stock_propuesto")
    private String equipoStockPropuesto;

    @Column(name = "fecha_llegada_propuesto")
    private Date fechaLlegadaPropuesto;

    @Column(name = "otros_actual")
    private String otrosEquiposActual;

    @Column(name = "otros_propuesto")
    private String otrosEquiposPropuesto;

    @Column(name = "componentes_propuesto")
    private String componentesPropuesto;

    @Column(name = "vrf_propuesto")
    private String vrfPropuesto;

    @Column(name = "detalle_accion_enlace_propuesto")
    private String detalleAccionEnlacePropuesto;

    @Column(name = "observaciones_propuesto")
    private String observacionesPropuesto;

    @Column(name = "precio_propuesto")
    private BigDecimal precioPropuesto;

    @Column(name = "codigo_sisego")
    private String codigoSisego;

    @Column(name = "zona_sisego")
    private String zonaSisego;

    @Column(name = "dias_ejecucion")
    private Integer diasEjecucion;

    @Column(name = "costo_ultima_milla")
    private BigDecimal costoUltimaMilla;

    @Column(name = "transmision")
    private BigDecimal transmision;

    @Column(name = "planta_externa")
    private BigDecimal planta_externa;

    @Column(name = "residual_antig")
    private Integer residual_antig;

    @Column(name = "residual_antig_costo")
    private BigDecimal residual_antig_costo;

    @Transient
    private Integer estado;

    @Column(name = "activo")
    private Boolean activo;

    @ManyToOne
    @JoinColumn(name = "oferta_id", referencedColumnName = "oferta_id")
    private Ofertas ofertas;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "accion_isis_id_propuesto", referencedColumnName = "accion_isis_id")
    private AccionIsis accionIsis;

    @ManyToOne
    @JoinColumn(name = "tipo_circuito_id_propuesto", referencedColumnName = "tipo_circuito_id")
    private TipoCircuito tipocircuitopropuesto;

    @ManyToOne
    @JoinColumn(name = "tipo_circuito_id_actual")
    private TipoCircuito tipocircuitoactual;

    @ManyToOne
    @JoinColumn(name = "tipo_servicio_id_propuesto", referencedColumnName = "tipo_servicio_id")
    private TipoServicio tipoServicioPropuesto;

    @ManyToOne
    @JoinColumn(name = "tipo_servicio_id_actual", referencedColumnName = "tipo_servicio_id")
    private TipoServicio tipoServicioActual;

    @ManyToOne
    @JoinColumn(name = "via_acceso_id_propuesto", referencedColumnName = "via_acceso_id")
    private ViaAcceso viaAcceso;

    @ManyToOne
    @JoinColumn(name = "medio_acceso_id_actual")
    private MedioAcceso medioactual;

    @ManyToOne
    @JoinColumn(name = "medio_acceso_id_propuesto")
    private MedioAcceso mediopropuesto;

    @ManyToOne
    @JoinColumn(name = "distrito_id")
    private Distrito distrito;

    //TIPO SEDE
    @ManyToOne
    @JoinColumn(name = "tipo_enlace_id")
    private Tipoenlace tipoenlace;

    //MODO
    @ManyToOne
    @JoinColumn(name="condicion_enlace_id")
    private Condicionenlace condicionenlace;

    @Override
    public boolean isIdSet() {
        // TODO Auto-generated method stub
        return ofertasDetalleId != null;
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
        this.ofertasDetalleId = id;

    }
}
