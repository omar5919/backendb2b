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
    private String ubigeo;
    private String latitud;
    private String longitud;
    private String zoom;
    private String contacto;
    private String telefono;
    private Integer tipoCircuitoActual;
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
    private String recursoTransporteActual;
    private String tipoAntenaActual;
    private Integer segmentoSatelitalActual;
    private String pozoTierraActual;
    private String upsActual;
    private String vrf_actual;

    private String equipo_adicional_actual;
    private String equipoTerminalActual;
    private BigDecimal facturacion_actual;

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

    private Date fechaLlegadaPropuesto;
    private String otrosEquiposPropuesto;
    private String componentesPropuesto;
    private String vrfPropuesto;
    private String detalleAccionEnlacePropuesto;

    private String observacionesPropuesto;
    private BigDecimal precioPropuesto;
    private String codigoSisego;
    private String zonaSisego;
    private Integer diasEjecucion;
    private BigDecimal costoUltimaMilla;

    //NUEVAS COLUMNAS
    private String dte;
    private String recursotransporte;
    private String tipoantena;
    private String segmentosatelital;
    private String segmentopozotierra;
    private String ups;
    private String vrf;

    private String fechallegada;
    private String componentes;
    private String serviciopropuestovrf;
    private String detalleaccion;

    private BigDecimal transmision;
    private BigDecimal planta_externa;
    private Integer residual_antig;
    private BigDecimal residual_antig_costo;

    private Integer condicion_servicio;
    private Boolean activo;

    //NUMERO DE CIRCUITO ACTUAL
    private String nrotipoCircuitoActual;
    //MEDIO ACTUAL
    private Integer servicioActual_medio;
    //OTROS ACTUAL
    private String servicioActual_otro;
    //TIPO SEDE PROPUESTO
    private Integer servicioPropuesto_tiposede;
    //MODO PROPUESTO
    private Integer servicioPropuesto_modo;
    //NUMERO DE CIRCUITO PROPUESTO
    private String servicioPropuesto_nrocircuito;
    //MEDIO PROPUESTO
    private Integer servicioPropuesto_medio;

}
