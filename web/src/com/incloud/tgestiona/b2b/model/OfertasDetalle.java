package com.incloud.tgestiona.b2b.model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

 

import com.google.common.base.MoreObjects;
import com.incloud.tgestiona.domain.BaseDomain;
import com.sun.istack.NotNull;

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
    private Integer id;
    private Integer ofertasId;
    private Integer clienteId;
    private String icSede;
    private String icDireccion;
    private String icDisrtito;
    private String icProvincia;
    private String icDepartamento;
    private String icLatitud;
    private String icLongitud;
    private String icZoom;
    private String icDireccionmap;
    private String icContactos;
    private String saConectadoa;
    private Integer saSede;
    private Integer saTipoCircuitoId;
    private Integer saIdservicio;
    private Integer saIdmedioacceso;
    private String saMedidabw;
    private BigDecimal saBw;
    private String saBwsatelital;
    private String saLdn;
    private String saMedidavoz;
    private BigDecimal saCaudalvoz;
    private String saVozsatelital;
    private String saMedidavideo;
    private BigDecimal saCaudalvideo;
    private String saVideosatelital;
    private String saMedidaplatinium;
    private BigDecimal saCaudalplatinium;
    private String saPlatiniumsatelital;
    private String saMedidaoro;
    private BigDecimal saCaudaloro;
    private String saOrosatelital;
    private String saMedidaplata;
    private BigDecimal saCaudalplata;
    private String saPlatasatelital;
    private String saMedidabronce;
    private BigDecimal saCaudalbronce;
    private String saBroncesatelital;
    private BigDecimal saPma;
    private String saEquipo1;
    private BigDecimal saCosto1;
    private String saImputacion1;
    private String saEquipo2;
    private BigDecimal saCosto2;
    private String saImputacion2;
    private String saEquipo3;
    private BigDecimal saCosto3;
    private String saImputacion3;
    private String saEquipo4;
    private BigDecimal saCosto4;
    private String saImputacion4;
    private String saEquipo5;
    private BigDecimal saCosto5;
    private String saImputacion5;
    private String saEquipo6;
    private BigDecimal saCosto6;
    private String saImputacion6;
    private String saObservacion;
    private String spNumerocd;
    private String spCircuitosconectados;
    private Integer spServicioId;
    private String spMedidabw;
    private BigDecimal spBw;
    private String spBwsatelital;
    private String spLdn;
    private String spMedidavoz;
    private BigDecimal spCaudalvoz;
    private String spVozsatelital;
    private String spMedidavideo;
    private BigDecimal spCaudalvideo;
    private String spVideosatelital;
    private String spMedidaplatinium;
    private BigDecimal spCaudalplatinium;
    private String spPlatiniumsatelital;
    private String spMedidaoro;
    private BigDecimal spCaudaloro;
    private String spOrosatelital;
    private String spMedidaplata;
    private BigDecimal spCaudalplata;
    private String spPlatasatelital;
    private String spMedidabronce;
    private BigDecimal spCaudalbronce;
    private String spBroncesatelital;
    private Integer spAntiguedad;
    private String spEquipo1;
    private BigDecimal spCosto1;
    private String spImputacion1;
    private String spEquipo2;
    private BigDecimal spCosto2;
    private String spImputacion2;
    private String spEquipo3;
    private BigDecimal spCosto3;
    private String spImputacion3;
    private String spEquipo4;
    private BigDecimal spCosto4;
    private String spImputacion4;
    private String spEquipo5;
    private BigDecimal spCosto5;
    private String spImputacion5;
    private String spEquipo6;
    private BigDecimal spCosto6;
    private String spImputacion6;
    private String spObservacion;
    private String ssCodigoSisego;
    private Integer ssAntiguedad;
    private BigDecimal ssCostoAntiguo;
    private BigDecimal ssValorResidual;
    private String ssDiasejecucion;
    private BigDecimal ssUltimamilla;
    private String ssCostoTransmision;
    private BigDecimal ssCostoPlantaexterna;
    private BigDecimal ssCostoOpex;

    // Many to one
    private AccionIsis spAccionIsis;
    private CondicionCircuito spCondicionCircuito;
    private CondicionSisego ssCondicionSisego;
    private TipoSede spTipoSede;
    private MedioAcceso spMedioAcceso;
    private TipoCircuito spTipoCircuito;
    private TipoInstalacionSatelital spTipoInstalacionSatelital;

    // One to one
    private ContactoSede contactoSede;

    @Override
    public String entityClassName() {
        return OfertasDetalle.class.getSimpleName();
    }

    // -- [id] ------------------------

    @Override
    @Column(name = "ofertas_detalle_id", precision = 10)
    @Id
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public OfertasDetalle id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    public boolean isIdSet() {
        return id != null;
    }
    // -- [ofertasId] ------------------------

    @Digits(integer = 10, fraction = 0)
    @NotNull
    @Column(name = "ofertas_id", nullable = false, precision = 10)
    public Integer getOfertasId() {
        return ofertasId;
    }

    public void setOfertasId(Integer ofertasId) {
        this.ofertasId = ofertasId;
    }

    public OfertasDetalle ofertasId(Integer ofertasId) {
        setOfertasId(ofertasId);
        return this;
    }
    // -- [clienteId] ------------------------

    @Digits(integer = 10, fraction = 0)
    @NotNull
    @Column(name = "cliente_id", nullable = false, precision = 10)
    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public OfertasDetalle clienteId(Integer clienteId) {
        setClienteId(clienteId);
        return this;
    }
    // -- [icSede] ------------------------

    @Size(max = 100, message = "{message.ofertasDetalle.icSede.sizeMax} {max} {message.caracter}")
    @Column(name = "ic_sede", length = 100)
    public String getIcSede() {
        return icSede;
    }

    public void setIcSede(String icSede) {
        this.icSede = icSede;
    }

    public OfertasDetalle icSede(String icSede) {
        setIcSede(icSede);
        return this;
    }
    // -- [icDireccion] ------------------------

    @Size(max = 250, message = "{message.ofertasDetalle.icDireccion.sizeMax} {max} {message.caracter}")
    @Column(name = "ic_direccion", length = 250)
    public String getIcDireccion() {
        return icDireccion;
    }

    public void setIcDireccion(String icDireccion) {
        this.icDireccion = icDireccion;
    }

    public OfertasDetalle icDireccion(String icDireccion) {
        setIcDireccion(icDireccion);
        return this;
    }
    // -- [icDisrtito] ------------------------

    @Size(max = 50, message = "{message.ofertasDetalle.icDisrtito.sizeMax} {max} {message.caracter}")
    @Column(name = "ic_disrtito", length = 50)
    public String getIcDisrtito() {
        return icDisrtito;
    }

    public void setIcDisrtito(String icDisrtito) {
        this.icDisrtito = icDisrtito;
    }

    public OfertasDetalle icDisrtito(String icDisrtito) {
        setIcDisrtito(icDisrtito);
        return this;
    }
    // -- [icProvincia] ------------------------

    @Size(max = 50, message = "{message.ofertasDetalle.icProvincia.sizeMax} {max} {message.caracter}")
    @Column(name = "ic_provincia", length = 50)
    public String getIcProvincia() {
        return icProvincia;
    }

    public void setIcProvincia(String icProvincia) {
        this.icProvincia = icProvincia;
    }

    public OfertasDetalle icProvincia(String icProvincia) {
        setIcProvincia(icProvincia);
        return this;
    }
    // -- [icDepartamento] ------------------------

    @Size(max = 50, message = "{message.ofertasDetalle.icDepartamento.sizeMax} {max} {message.caracter}")
    @Column(name = "ic_departamento", length = 50)
    public String getIcDepartamento() {
        return icDepartamento;
    }

    public void setIcDepartamento(String icDepartamento) {
        this.icDepartamento = icDepartamento;
    }

    public OfertasDetalle icDepartamento(String icDepartamento) {
        setIcDepartamento(icDepartamento);
        return this;
    }
    // -- [icLatitud] ------------------------

    @Size(max = 50, message = "{message.ofertasDetalle.icLatitud.sizeMax} {max} {message.caracter}")
    @Column(name = "ic_latitud", length = 50)
    public String getIcLatitud() {
        return icLatitud;
    }

    public void setIcLatitud(String icLatitud) {
        this.icLatitud = icLatitud;
    }

    public OfertasDetalle icLatitud(String icLatitud) {
        setIcLatitud(icLatitud);
        return this;
    }
    // -- [icLongitud] ------------------------

    @Size(max = 50, message = "{message.ofertasDetalle.icLongitud.sizeMax} {max} {message.caracter}")
    @Column(name = "ic_longitud", length = 50)
    public String getIcLongitud() {
        return icLongitud;
    }

    public void setIcLongitud(String icLongitud) {
        this.icLongitud = icLongitud;
    }

    public OfertasDetalle icLongitud(String icLongitud) {
        setIcLongitud(icLongitud);
        return this;
    }
    // -- [icZoom] ------------------------

    @Size(max = 1, message = "{message.ofertasDetalle.icZoom.sizeMax} {max} {message.caracter}")
    @Column(name = "ic_zoom", length = 1)
    public String getIcZoom() {
        return icZoom;
    }

    public void setIcZoom(String icZoom) {
        this.icZoom = icZoom;
    }

    public OfertasDetalle icZoom(String icZoom) {
        setIcZoom(icZoom);
        return this;
    }
    // -- [icDireccionmap] ------------------------

    @Size(max = 300, message = "{message.ofertasDetalle.icDireccionmap.sizeMax} {max} {message.caracter}")
    @Column(name = "ic_direccionmap", length = 300)
    public String getIcDireccionmap() {
        return icDireccionmap;
    }

    public void setIcDireccionmap(String icDireccionmap) {
        this.icDireccionmap = icDireccionmap;
    }

    public OfertasDetalle icDireccionmap(String icDireccionmap) {
        setIcDireccionmap(icDireccionmap);
        return this;
    }
    // -- [icContactos] ------------------------

    @Size(max = 300, message = "{message.ofertasDetalle.icContactos.sizeMax} {max} {message.caracter}")
    @Column(name = "ic_contactos", length = 300)
    public String getIcContactos() {
        return icContactos;
    }

    public void setIcContactos(String icContactos) {
        this.icContactos = icContactos;
    }

    public OfertasDetalle icContactos(String icContactos) {
        setIcContactos(icContactos);
        return this;
    }
    // -- [saConectadoa] ------------------------

    @Size(max = 50, message = "{message.ofertasDetalle.saConectadoa.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_conectadoA", length = 50)
    public String getSaConectadoa() {
        return saConectadoa;
    }

    public void setSaConectadoa(String saConectadoa) {
        this.saConectadoa = saConectadoa;
    }

    public OfertasDetalle saConectadoa(String saConectadoa) {
        setSaConectadoa(saConectadoa);
        return this;
    }
    // -- [saSede] ------------------------

    @Digits(integer = 10, fraction = 0)
    @Column(name = "sa_sede", precision = 10)
    public Integer getSaSede() {
        return saSede;
    }

    public void setSaSede(Integer saSede) {
        this.saSede = saSede;
    }

    public OfertasDetalle saSede(Integer saSede) {
        setSaSede(saSede);
        return this;
    }
    // -- [saTipoCircuitoId] ------------------------

    @Digits(integer = 10, fraction = 0)
    @Column(name = "sa_tipo_circuito_id", precision = 10)
    public Integer getSaTipoCircuitoId() {
        return saTipoCircuitoId;
    }

    public void setSaTipoCircuitoId(Integer saTipoCircuitoId) {
        this.saTipoCircuitoId = saTipoCircuitoId;
    }

    public OfertasDetalle saTipoCircuitoId(Integer saTipoCircuitoId) {
        setSaTipoCircuitoId(saTipoCircuitoId);
        return this;
    }
    // -- [saIdservicio] ------------------------

    @Digits(integer = 10, fraction = 0)
    @Column(name = "sa_IdServicio", precision = 10)
    public Integer getSaIdservicio() {
        return saIdservicio;
    }

    public void setSaIdservicio(Integer saIdservicio) {
        this.saIdservicio = saIdservicio;
    }

    public OfertasDetalle saIdservicio(Integer saIdservicio) {
        setSaIdservicio(saIdservicio);
        return this;
    }
    // -- [saIdmedioacceso] ------------------------

    @Digits(integer = 10, fraction = 0)
    @Column(name = "sa_IdMedioAcceso", precision = 10)
    public Integer getSaIdmedioacceso() {
        return saIdmedioacceso;
    }

    public void setSaIdmedioacceso(Integer saIdmedioacceso) {
        this.saIdmedioacceso = saIdmedioacceso;
    }

    public OfertasDetalle saIdmedioacceso(Integer saIdmedioacceso) {
        setSaIdmedioacceso(saIdmedioacceso);
        return this;
    }
    // -- [saMedidabw] ------------------------

    @Size(max = 4, message = "{message.ofertasDetalle.saMedidabw.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_medidabw", length = 4)
    public String getSaMedidabw() {
        return saMedidabw;
    }

    public void setSaMedidabw(String saMedidabw) {
        this.saMedidabw = saMedidabw;
    }

    public OfertasDetalle saMedidabw(String saMedidabw) {
        setSaMedidabw(saMedidabw);
        return this;
    }
    // -- [saBw] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "sa_bw", precision = 18, scale = 5)
    public BigDecimal getSaBw() {
        return saBw;
    }

    public void setSaBw(BigDecimal saBw) {
        this.saBw = saBw;
    }

    public OfertasDetalle saBw(BigDecimal saBw) {
        setSaBw(saBw);
        return this;
    }
    // -- [saBwsatelital] ------------------------

    @Size(max = 20, message = "{message.ofertasDetalle.saBwsatelital.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_bwsatelital", length = 20)
    public String getSaBwsatelital() {
        return saBwsatelital;
    }

    public void setSaBwsatelital(String saBwsatelital) {
        this.saBwsatelital = saBwsatelital;
    }

    public OfertasDetalle saBwsatelital(String saBwsatelital) {
        setSaBwsatelital(saBwsatelital);
        return this;
    }
    // -- [saLdn] ------------------------

    @Size(max = 2, message = "{message.ofertasDetalle.saLdn.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_ldn", length = 2)
    public String getSaLdn() {
        return saLdn;
    }

    public void setSaLdn(String saLdn) {
        this.saLdn = saLdn;
    }

    public OfertasDetalle saLdn(String saLdn) {
        setSaLdn(saLdn);
        return this;
    }
    // -- [saMedidavoz] ------------------------

    @Size(max = 2, message = "{message.ofertasDetalle.saMedidavoz.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_medidavoz", length = 2)
    public String getSaMedidavoz() {
        return saMedidavoz;
    }

    public void setSaMedidavoz(String saMedidavoz) {
        this.saMedidavoz = saMedidavoz;
    }

    public OfertasDetalle saMedidavoz(String saMedidavoz) {
        setSaMedidavoz(saMedidavoz);
        return this;
    }
    // -- [saCaudalvoz] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "sa_caudalvoz", precision = 18, scale = 5)
    public BigDecimal getSaCaudalvoz() {
        return saCaudalvoz;
    }

    public void setSaCaudalvoz(BigDecimal saCaudalvoz) {
        this.saCaudalvoz = saCaudalvoz;
    }

    public OfertasDetalle saCaudalvoz(BigDecimal saCaudalvoz) {
        setSaCaudalvoz(saCaudalvoz);
        return this;
    }
    // -- [saVozsatelital] ------------------------

    @Size(max = 20, message = "{message.ofertasDetalle.saVozsatelital.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_vozsatelital", length = 20)
    public String getSaVozsatelital() {
        return saVozsatelital;
    }

    public void setSaVozsatelital(String saVozsatelital) {
        this.saVozsatelital = saVozsatelital;
    }

    public OfertasDetalle saVozsatelital(String saVozsatelital) {
        setSaVozsatelital(saVozsatelital);
        return this;
    }
    // -- [saMedidavideo] ------------------------

    @Size(max = 4, message = "{message.ofertasDetalle.saMedidavideo.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_medidavideo", length = 4)
    public String getSaMedidavideo() {
        return saMedidavideo;
    }

    public void setSaMedidavideo(String saMedidavideo) {
        this.saMedidavideo = saMedidavideo;
    }

    public OfertasDetalle saMedidavideo(String saMedidavideo) {
        setSaMedidavideo(saMedidavideo);
        return this;
    }
    // -- [saCaudalvideo] ------------------------

    @Digits(integer = 16, fraction = 2)
    @Column(name = "sa_caudalvideo", precision = 18, scale = 2)
    public BigDecimal getSaCaudalvideo() {
        return saCaudalvideo;
    }

    public void setSaCaudalvideo(BigDecimal saCaudalvideo) {
        this.saCaudalvideo = saCaudalvideo;
    }

    public OfertasDetalle saCaudalvideo(BigDecimal saCaudalvideo) {
        setSaCaudalvideo(saCaudalvideo);
        return this;
    }
    // -- [saVideosatelital] ------------------------

    @Size(max = 20, message = "{message.ofertasDetalle.saVideosatelital.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_videosatelital", length = 20)
    public String getSaVideosatelital() {
        return saVideosatelital;
    }

    public void setSaVideosatelital(String saVideosatelital) {
        this.saVideosatelital = saVideosatelital;
    }

    public OfertasDetalle saVideosatelital(String saVideosatelital) {
        setSaVideosatelital(saVideosatelital);
        return this;
    }
    // -- [saMedidaplatinium] ------------------------

    @Size(max = 4, message = "{message.ofertasDetalle.saMedidaplatinium.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_medidaplatinium", length = 4)
    public String getSaMedidaplatinium() {
        return saMedidaplatinium;
    }

    public void setSaMedidaplatinium(String saMedidaplatinium) {
        this.saMedidaplatinium = saMedidaplatinium;
    }

    public OfertasDetalle saMedidaplatinium(String saMedidaplatinium) {
        setSaMedidaplatinium(saMedidaplatinium);
        return this;
    }
    // -- [saCaudalplatinium] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "sa_caudalplatinium", precision = 18, scale = 5)
    public BigDecimal getSaCaudalplatinium() {
        return saCaudalplatinium;
    }

    public void setSaCaudalplatinium(BigDecimal saCaudalplatinium) {
        this.saCaudalplatinium = saCaudalplatinium;
    }

    public OfertasDetalle saCaudalplatinium(BigDecimal saCaudalplatinium) {
        setSaCaudalplatinium(saCaudalplatinium);
        return this;
    }
    // -- [saPlatiniumsatelital] ------------------------

    @Size(max = 20, message = "{message.ofertasDetalle.saPlatiniumsatelital.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_platiniumsatelital", length = 20)
    public String getSaPlatiniumsatelital() {
        return saPlatiniumsatelital;
    }

    public void setSaPlatiniumsatelital(String saPlatiniumsatelital) {
        this.saPlatiniumsatelital = saPlatiniumsatelital;
    }

    public OfertasDetalle saPlatiniumsatelital(String saPlatiniumsatelital) {
        setSaPlatiniumsatelital(saPlatiniumsatelital);
        return this;
    }
    // -- [saMedidaoro] ------------------------

    @Size(max = 4, message = "{message.ofertasDetalle.saMedidaoro.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_medidaoro", length = 4)
    public String getSaMedidaoro() {
        return saMedidaoro;
    }

    public void setSaMedidaoro(String saMedidaoro) {
        this.saMedidaoro = saMedidaoro;
    }

    public OfertasDetalle saMedidaoro(String saMedidaoro) {
        setSaMedidaoro(saMedidaoro);
        return this;
    }
    // -- [saCaudaloro] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "sa_caudaloro", precision = 18, scale = 5)
    public BigDecimal getSaCaudaloro() {
        return saCaudaloro;
    }

    public void setSaCaudaloro(BigDecimal saCaudaloro) {
        this.saCaudaloro = saCaudaloro;
    }

    public OfertasDetalle saCaudaloro(BigDecimal saCaudaloro) {
        setSaCaudaloro(saCaudaloro);
        return this;
    }
    // -- [saOrosatelital] ------------------------

    @Size(max = 20, message = "{message.ofertasDetalle.saOrosatelital.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_orosatelital", length = 20)
    public String getSaOrosatelital() {
        return saOrosatelital;
    }

    public void setSaOrosatelital(String saOrosatelital) {
        this.saOrosatelital = saOrosatelital;
    }

    public OfertasDetalle saOrosatelital(String saOrosatelital) {
        setSaOrosatelital(saOrosatelital);
        return this;
    }
    // -- [saMedidaplata] ------------------------

    @Size(max = 4, message = "{message.ofertasDetalle.saMedidaplata.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_medidaplata", length = 4)
    public String getSaMedidaplata() {
        return saMedidaplata;
    }

    public void setSaMedidaplata(String saMedidaplata) {
        this.saMedidaplata = saMedidaplata;
    }

    public OfertasDetalle saMedidaplata(String saMedidaplata) {
        setSaMedidaplata(saMedidaplata);
        return this;
    }
    // -- [saCaudalplata] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "sa_caudalplata", precision = 18, scale = 5)
    public BigDecimal getSaCaudalplata() {
        return saCaudalplata;
    }

    public void setSaCaudalplata(BigDecimal saCaudalplata) {
        this.saCaudalplata = saCaudalplata;
    }

    public OfertasDetalle saCaudalplata(BigDecimal saCaudalplata) {
        setSaCaudalplata(saCaudalplata);
        return this;
    }
    // -- [saPlatasatelital] ------------------------

    @Size(max = 20, message = "{message.ofertasDetalle.saPlatasatelital.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_platasatelital", length = 20)
    public String getSaPlatasatelital() {
        return saPlatasatelital;
    }

    public void setSaPlatasatelital(String saPlatasatelital) {
        this.saPlatasatelital = saPlatasatelital;
    }

    public OfertasDetalle saPlatasatelital(String saPlatasatelital) {
        setSaPlatasatelital(saPlatasatelital);
        return this;
    }
    // -- [saMedidabronce] ------------------------

    @Size(max = 4, message = "{message.ofertasDetalle.saMedidabronce.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_medidabronce", length = 4)
    public String getSaMedidabronce() {
        return saMedidabronce;
    }

    public void setSaMedidabronce(String saMedidabronce) {
        this.saMedidabronce = saMedidabronce;
    }

    public OfertasDetalle saMedidabronce(String saMedidabronce) {
        setSaMedidabronce(saMedidabronce);
        return this;
    }
    // -- [saCaudalbronce] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "sa_caudalbronce", precision = 18, scale = 5)
    public BigDecimal getSaCaudalbronce() {
        return saCaudalbronce;
    }

    public void setSaCaudalbronce(BigDecimal saCaudalbronce) {
        this.saCaudalbronce = saCaudalbronce;
    }

    public OfertasDetalle saCaudalbronce(BigDecimal saCaudalbronce) {
        setSaCaudalbronce(saCaudalbronce);
        return this;
    }
    // -- [saBroncesatelital] ------------------------

    @Size(max = 20, message = "{message.ofertasDetalle.saBroncesatelital.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_broncesatelital", length = 20)
    public String getSaBroncesatelital() {
        return saBroncesatelital;
    }

    public void setSaBroncesatelital(String saBroncesatelital) {
        this.saBroncesatelital = saBroncesatelital;
    }

    public OfertasDetalle saBroncesatelital(String saBroncesatelital) {
        setSaBroncesatelital(saBroncesatelital);
        return this;
    }
    // -- [saPma] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "sa_pma", precision = 18, scale = 5)
    public BigDecimal getSaPma() {
        return saPma;
    }

    public void setSaPma(BigDecimal saPma) {
        this.saPma = saPma;
    }

    public OfertasDetalle saPma(BigDecimal saPma) {
        setSaPma(saPma);
        return this;
    }
    // -- [saEquipo1] ------------------------

    @Size(max = 100, message = "{message.ofertasDetalle.saEquipo1.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_equipo1", length = 100)
    public String getSaEquipo1() {
        return saEquipo1;
    }

    public void setSaEquipo1(String saEquipo1) {
        this.saEquipo1 = saEquipo1;
    }

    public OfertasDetalle saEquipo1(String saEquipo1) {
        setSaEquipo1(saEquipo1);
        return this;
    }
    // -- [saCosto1] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "sa_costo1", precision = 18, scale = 5)
    public BigDecimal getSaCosto1() {
        return saCosto1;
    }

    public void setSaCosto1(BigDecimal saCosto1) {
        this.saCosto1 = saCosto1;
    }

    public OfertasDetalle saCosto1(BigDecimal saCosto1) {
        setSaCosto1(saCosto1);
        return this;
    }
    // -- [saImputacion1] ------------------------

    @Size(max = 10, message = "{message.ofertasDetalle.saImputacion1.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_imputacion1", length = 10)
    public String getSaImputacion1() {
        return saImputacion1;
    }

    public void setSaImputacion1(String saImputacion1) {
        this.saImputacion1 = saImputacion1;
    }

    public OfertasDetalle saImputacion1(String saImputacion1) {
        setSaImputacion1(saImputacion1);
        return this;
    }
    // -- [saEquipo2] ------------------------

    @Size(max = 100, message = "{message.ofertasDetalle.saEquipo2.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_equipo2", length = 100)
    public String getSaEquipo2() {
        return saEquipo2;
    }

    public void setSaEquipo2(String saEquipo2) {
        this.saEquipo2 = saEquipo2;
    }

    public OfertasDetalle saEquipo2(String saEquipo2) {
        setSaEquipo2(saEquipo2);
        return this;
    }
    // -- [saCosto2] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "sa_costo2", precision = 18, scale = 5)
    public BigDecimal getSaCosto2() {
        return saCosto2;
    }

    public void setSaCosto2(BigDecimal saCosto2) {
        this.saCosto2 = saCosto2;
    }

    public OfertasDetalle saCosto2(BigDecimal saCosto2) {
        setSaCosto2(saCosto2);
        return this;
    }
    // -- [saImputacion2] ------------------------

    @Size(max = 10, message = "{message.ofertasDetalle.saImputacion2.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_imputacion2", length = 10)
    public String getSaImputacion2() {
        return saImputacion2;
    }

    public void setSaImputacion2(String saImputacion2) {
        this.saImputacion2 = saImputacion2;
    }

    public OfertasDetalle saImputacion2(String saImputacion2) {
        setSaImputacion2(saImputacion2);
        return this;
    }
    // -- [saEquipo3] ------------------------

    @Size(max = 100, message = "{message.ofertasDetalle.saEquipo3.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_equipo3", length = 100)
    public String getSaEquipo3() {
        return saEquipo3;
    }

    public void setSaEquipo3(String saEquipo3) {
        this.saEquipo3 = saEquipo3;
    }

    public OfertasDetalle saEquipo3(String saEquipo3) {
        setSaEquipo3(saEquipo3);
        return this;
    }
    // -- [saCosto3] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "sa_costo3", precision = 18, scale = 5)
    public BigDecimal getSaCosto3() {
        return saCosto3;
    }

    public void setSaCosto3(BigDecimal saCosto3) {
        this.saCosto3 = saCosto3;
    }

    public OfertasDetalle saCosto3(BigDecimal saCosto3) {
        setSaCosto3(saCosto3);
        return this;
    }
    // -- [saImputacion3] ------------------------

    @Size(max = 10, message = "{message.ofertasDetalle.saImputacion3.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_imputacion3", length = 10)
    public String getSaImputacion3() {
        return saImputacion3;
    }

    public void setSaImputacion3(String saImputacion3) {
        this.saImputacion3 = saImputacion3;
    }

    public OfertasDetalle saImputacion3(String saImputacion3) {
        setSaImputacion3(saImputacion3);
        return this;
    }
    // -- [saEquipo4] ------------------------

    @Size(max = 100, message = "{message.ofertasDetalle.saEquipo4.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_equipo4", length = 100)
    public String getSaEquipo4() {
        return saEquipo4;
    }

    public void setSaEquipo4(String saEquipo4) {
        this.saEquipo4 = saEquipo4;
    }

    public OfertasDetalle saEquipo4(String saEquipo4) {
        setSaEquipo4(saEquipo4);
        return this;
    }
    // -- [saCosto4] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "sa_costo4", precision = 18, scale = 5)
    public BigDecimal getSaCosto4() {
        return saCosto4;
    }

    public void setSaCosto4(BigDecimal saCosto4) {
        this.saCosto4 = saCosto4;
    }

    public OfertasDetalle saCosto4(BigDecimal saCosto4) {
        setSaCosto4(saCosto4);
        return this;
    }
    // -- [saImputacion4] ------------------------

    @Size(max = 4, message = "{message.ofertasDetalle.saImputacion4.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_imputacion4", length = 4)
    public String getSaImputacion4() {
        return saImputacion4;
    }

    public void setSaImputacion4(String saImputacion4) {
        this.saImputacion4 = saImputacion4;
    }

    public OfertasDetalle saImputacion4(String saImputacion4) {
        setSaImputacion4(saImputacion4);
        return this;
    }
    // -- [saEquipo5] ------------------------

    @Size(max = 100, message = "{message.ofertasDetalle.saEquipo5.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_equipo5", length = 100)
    public String getSaEquipo5() {
        return saEquipo5;
    }

    public void setSaEquipo5(String saEquipo5) {
        this.saEquipo5 = saEquipo5;
    }

    public OfertasDetalle saEquipo5(String saEquipo5) {
        setSaEquipo5(saEquipo5);
        return this;
    }
    // -- [saCosto5] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "sa_costo5", precision = 18, scale = 5)
    public BigDecimal getSaCosto5() {
        return saCosto5;
    }

    public void setSaCosto5(BigDecimal saCosto5) {
        this.saCosto5 = saCosto5;
    }

    public OfertasDetalle saCosto5(BigDecimal saCosto5) {
        setSaCosto5(saCosto5);
        return this;
    }
    // -- [saImputacion5] ------------------------

    @Size(max = 4, message = "{message.ofertasDetalle.saImputacion5.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_imputacion5", length = 4)
    public String getSaImputacion5() {
        return saImputacion5;
    }

    public void setSaImputacion5(String saImputacion5) {
        this.saImputacion5 = saImputacion5;
    }

    public OfertasDetalle saImputacion5(String saImputacion5) {
        setSaImputacion5(saImputacion5);
        return this;
    }
    // -- [saEquipo6] ------------------------

    @Size(max = 100, message = "{message.ofertasDetalle.saEquipo6.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_equipo6", length = 100)
    public String getSaEquipo6() {
        return saEquipo6;
    }

    public void setSaEquipo6(String saEquipo6) {
        this.saEquipo6 = saEquipo6;
    }

    public OfertasDetalle saEquipo6(String saEquipo6) {
        setSaEquipo6(saEquipo6);
        return this;
    }
    // -- [saCosto6] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "sa_costo6", precision = 18, scale = 5)
    public BigDecimal getSaCosto6() {
        return saCosto6;
    }

    public void setSaCosto6(BigDecimal saCosto6) {
        this.saCosto6 = saCosto6;
    }

    public OfertasDetalle saCosto6(BigDecimal saCosto6) {
        setSaCosto6(saCosto6);
        return this;
    }
    // -- [saImputacion6] ------------------------

    @Size(max = 4, message = "{message.ofertasDetalle.saImputacion6.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_Imputacion6", length = 4)
    public String getSaImputacion6() {
        return saImputacion6;
    }

    public void setSaImputacion6(String saImputacion6) {
        this.saImputacion6 = saImputacion6;
    }

    public OfertasDetalle saImputacion6(String saImputacion6) {
        setSaImputacion6(saImputacion6);
        return this;
    }
    // -- [saObservacion] ------------------------

    @Size(max = 500, message = "{message.ofertasDetalle.saObservacion.sizeMax} {max} {message.caracter}")
    @Column(name = "sa_observacion", length = 500)
    public String getSaObservacion() {
        return saObservacion;
    }

    public void setSaObservacion(String saObservacion) {
        this.saObservacion = saObservacion;
    }

    public OfertasDetalle saObservacion(String saObservacion) {
        setSaObservacion(saObservacion);
        return this;
    }
    // -- [spNumerocd] ------------------------

    @Size(max = 50, message = "{message.ofertasDetalle.spNumerocd.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_numeroCD", length = 50)
    public String getSpNumerocd() {
        return spNumerocd;
    }

    public void setSpNumerocd(String spNumerocd) {
        this.spNumerocd = spNumerocd;
    }

    public OfertasDetalle spNumerocd(String spNumerocd) {
        setSpNumerocd(spNumerocd);
        return this;
    }
    // -- [spCircuitosconectados] ------------------------

    @Size(max = 250, message = "{message.ofertasDetalle.spCircuitosconectados.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_circuitosConectados", length = 250)
    public String getSpCircuitosconectados() {
        return spCircuitosconectados;
    }

    public void setSpCircuitosconectados(String spCircuitosconectados) {
        this.spCircuitosconectados = spCircuitosconectados;
    }

    public OfertasDetalle spCircuitosconectados(String spCircuitosconectados) {
        setSpCircuitosconectados(spCircuitosconectados);
        return this;
    }
    // -- [spServicioId] ------------------------

    @Digits(integer = 10, fraction = 0)
    @NotNull
    @Column(name = "sp_servicio_id", nullable = false, precision = 10)
    public Integer getSpServicioId() {
        return spServicioId;
    }

    public void setSpServicioId(Integer spServicioId) {
        this.spServicioId = spServicioId;
    }

    public OfertasDetalle spServicioId(Integer spServicioId) {
        setSpServicioId(spServicioId);
        return this;
    }
    // -- [spMedidabw] ------------------------

    @Size(max = 4, message = "{message.ofertasDetalle.spMedidabw.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_medidabw", length = 4)
    public String getSpMedidabw() {
        return spMedidabw;
    }

    public void setSpMedidabw(String spMedidabw) {
        this.spMedidabw = spMedidabw;
    }

    public OfertasDetalle spMedidabw(String spMedidabw) {
        setSpMedidabw(spMedidabw);
        return this;
    }
    // -- [spBw] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "sp_bw", precision = 18, scale = 5)
    public BigDecimal getSpBw() {
        return spBw;
    }

    public void setSpBw(BigDecimal spBw) {
        this.spBw = spBw;
    }

    public OfertasDetalle spBw(BigDecimal spBw) {
        setSpBw(spBw);
        return this;
    }
    // -- [spBwsatelital] ------------------------

    @Size(max = 20, message = "{message.ofertasDetalle.spBwsatelital.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_bwsatelital", length = 20)
    public String getSpBwsatelital() {
        return spBwsatelital;
    }

    public void setSpBwsatelital(String spBwsatelital) {
        this.spBwsatelital = spBwsatelital;
    }

    public OfertasDetalle spBwsatelital(String spBwsatelital) {
        setSpBwsatelital(spBwsatelital);
        return this;
    }
    // -- [spLdn] ------------------------

    @Size(max = 2, message = "{message.ofertasDetalle.spLdn.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_ldn", length = 2)
    public String getSpLdn() {
        return spLdn;
    }

    public void setSpLdn(String spLdn) {
        this.spLdn = spLdn;
    }

    public OfertasDetalle spLdn(String spLdn) {
        setSpLdn(spLdn);
        return this;
    }
    // -- [spMedidavoz] ------------------------

    @Size(max = 4, message = "{message.ofertasDetalle.spMedidavoz.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_medidavoz", length = 4)
    public String getSpMedidavoz() {
        return spMedidavoz;
    }

    public void setSpMedidavoz(String spMedidavoz) {
        this.spMedidavoz = spMedidavoz;
    }

    public OfertasDetalle spMedidavoz(String spMedidavoz) {
        setSpMedidavoz(spMedidavoz);
        return this;
    }
    // -- [spCaudalvoz] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "sp_caudalvoz", precision = 18, scale = 5)
    public BigDecimal getSpCaudalvoz() {
        return spCaudalvoz;
    }

    public void setSpCaudalvoz(BigDecimal spCaudalvoz) {
        this.spCaudalvoz = spCaudalvoz;
    }

    public OfertasDetalle spCaudalvoz(BigDecimal spCaudalvoz) {
        setSpCaudalvoz(spCaudalvoz);
        return this;
    }
    // -- [spVozsatelital] ------------------------

    @Size(max = 20, message = "{message.ofertasDetalle.spVozsatelital.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_vozsatelital", length = 20)
    public String getSpVozsatelital() {
        return spVozsatelital;
    }

    public void setSpVozsatelital(String spVozsatelital) {
        this.spVozsatelital = spVozsatelital;
    }

    public OfertasDetalle spVozsatelital(String spVozsatelital) {
        setSpVozsatelital(spVozsatelital);
        return this;
    }
    // -- [spMedidavideo] ------------------------

    @Size(max = 4, message = "{message.ofertasDetalle.spMedidavideo.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_medidavideo", length = 4)
    public String getSpMedidavideo() {
        return spMedidavideo;
    }

    public void setSpMedidavideo(String spMedidavideo) {
        this.spMedidavideo = spMedidavideo;
    }

    public OfertasDetalle spMedidavideo(String spMedidavideo) {
        setSpMedidavideo(spMedidavideo);
        return this;
    }
    // -- [spCaudalvideo] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "sp_caudalvideo", precision = 18, scale = 5)
    public BigDecimal getSpCaudalvideo() {
        return spCaudalvideo;
    }

    public void setSpCaudalvideo(BigDecimal spCaudalvideo) {
        this.spCaudalvideo = spCaudalvideo;
    }

    public OfertasDetalle spCaudalvideo(BigDecimal spCaudalvideo) {
        setSpCaudalvideo(spCaudalvideo);
        return this;
    }
    // -- [spVideosatelital] ------------------------

    @Size(max = 20, message = "{message.ofertasDetalle.spVideosatelital.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_videosatelital", length = 20)
    public String getSpVideosatelital() {
        return spVideosatelital;
    }

    public void setSpVideosatelital(String spVideosatelital) {
        this.spVideosatelital = spVideosatelital;
    }

    public OfertasDetalle spVideosatelital(String spVideosatelital) {
        setSpVideosatelital(spVideosatelital);
        return this;
    }
    // -- [spMedidaplatinium] ------------------------

    @Size(max = 4, message = "{message.ofertasDetalle.spMedidaplatinium.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_medidaplatinium", length = 4)
    public String getSpMedidaplatinium() {
        return spMedidaplatinium;
    }

    public void setSpMedidaplatinium(String spMedidaplatinium) {
        this.spMedidaplatinium = spMedidaplatinium;
    }

    public OfertasDetalle spMedidaplatinium(String spMedidaplatinium) {
        setSpMedidaplatinium(spMedidaplatinium);
        return this;
    }
    // -- [spCaudalplatinium] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "sp_caudalplatinium", precision = 18, scale = 5)
    public BigDecimal getSpCaudalplatinium() {
        return spCaudalplatinium;
    }

    public void setSpCaudalplatinium(BigDecimal spCaudalplatinium) {
        this.spCaudalplatinium = spCaudalplatinium;
    }

    public OfertasDetalle spCaudalplatinium(BigDecimal spCaudalplatinium) {
        setSpCaudalplatinium(spCaudalplatinium);
        return this;
    }
    // -- [spPlatiniumsatelital ] ------------------------

    @Size(max = 20, message = "{message.ofertasDetalle.spPlatiniumsatelital .sizeMax} {max} {message.caracter}")
    @Column(name = "sp_platiniumsatelital ", length = 20)
    public String getSpPlatiniumsatelital() {
        return spPlatiniumsatelital;
    }

    public void setSpPlatiniumsatelital(String spPlatiniumsatelital) {
        this.spPlatiniumsatelital = spPlatiniumsatelital;
    }

    public OfertasDetalle spPlatiniumsatelital(String spPlatiniumsatelital) {
        setSpPlatiniumsatelital(spPlatiniumsatelital);
        return this;
    }
    // -- [spMedidaoro] ------------------------

    @Size(max = 4, message = "{message.ofertasDetalle.spMedidaoro.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_medidaoro", length = 4)
    public String getSpMedidaoro() {
        return spMedidaoro;
    }

    public void setSpMedidaoro(String spMedidaoro) {
        this.spMedidaoro = spMedidaoro;
    }

    public OfertasDetalle spMedidaoro(String spMedidaoro) {
        setSpMedidaoro(spMedidaoro);
        return this;
    }
    // -- [spCaudaloro] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "sp_caudaloro", precision = 18, scale = 5)
    public BigDecimal getSpCaudaloro() {
        return spCaudaloro;
    }

    public void setSpCaudaloro(BigDecimal spCaudaloro) {
        this.spCaudaloro = spCaudaloro;
    }

    public OfertasDetalle spCaudaloro(BigDecimal spCaudaloro) {
        setSpCaudaloro(spCaudaloro);
        return this;
    }
    // -- [spOrosatelital] ------------------------

    @Size(max = 20, message = "{message.ofertasDetalle.spOrosatelital.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_orosatelital", length = 20)
    public String getSpOrosatelital() {
        return spOrosatelital;
    }

    public void setSpOrosatelital(String spOrosatelital) {
        this.spOrosatelital = spOrosatelital;
    }

    public OfertasDetalle spOrosatelital(String spOrosatelital) {
        setSpOrosatelital(spOrosatelital);
        return this;
    }
    // -- [spMedidaplata] ------------------------

    @Size(max = 4, message = "{message.ofertasDetalle.spMedidaplata.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_medidaplata", length = 4)
    public String getSpMedidaplata() {
        return spMedidaplata;
    }

    public void setSpMedidaplata(String spMedidaplata) {
        this.spMedidaplata = spMedidaplata;
    }

    public OfertasDetalle spMedidaplata(String spMedidaplata) {
        setSpMedidaplata(spMedidaplata);
        return this;
    }
    // -- [spCaudalplata] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "sp_caudalplata", precision = 18, scale = 5)
    public BigDecimal getSpCaudalplata() {
        return spCaudalplata;
    }

    public void setSpCaudalplata(BigDecimal spCaudalplata) {
        this.spCaudalplata = spCaudalplata;
    }

    public OfertasDetalle spCaudalplata(BigDecimal spCaudalplata) {
        setSpCaudalplata(spCaudalplata);
        return this;
    }
    // -- [spPlatasatelital] ------------------------

    @Size(max = 20, message = "{message.ofertasDetalle.spPlatasatelital.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_platasatelital", length = 20)
    public String getSpPlatasatelital() {
        return spPlatasatelital;
    }

    public void setSpPlatasatelital(String spPlatasatelital) {
        this.spPlatasatelital = spPlatasatelital;
    }

    public OfertasDetalle spPlatasatelital(String spPlatasatelital) {
        setSpPlatasatelital(spPlatasatelital);
        return this;
    }
    // -- [spMedidabronce] ------------------------

    @Size(max = 4, message = "{message.ofertasDetalle.spMedidabronce.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_medidabronce", length = 4)
    public String getSpMedidabronce() {
        return spMedidabronce;
    }

    public void setSpMedidabronce(String spMedidabronce) {
        this.spMedidabronce = spMedidabronce;
    }

    public OfertasDetalle spMedidabronce(String spMedidabronce) {
        setSpMedidabronce(spMedidabronce);
        return this;
    }
    // -- [spCaudalbronce] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "sp_caudalbronce", precision = 18, scale = 5)
    public BigDecimal getSpCaudalbronce() {
        return spCaudalbronce;
    }

    public void setSpCaudalbronce(BigDecimal spCaudalbronce) {
        this.spCaudalbronce = spCaudalbronce;
    }

    public OfertasDetalle spCaudalbronce(BigDecimal spCaudalbronce) {
        setSpCaudalbronce(spCaudalbronce);
        return this;
    }
    // -- [spBroncesatelital] ------------------------

    @Size(max = 20, message = "{message.ofertasDetalle.spBroncesatelital.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_broncesatelital", length = 20)
    public String getSpBroncesatelital() {
        return spBroncesatelital;
    }

    public void setSpBroncesatelital(String spBroncesatelital) {
        this.spBroncesatelital = spBroncesatelital;
    }

    public OfertasDetalle spBroncesatelital(String spBroncesatelital) {
        setSpBroncesatelital(spBroncesatelital);
        return this;
    }
    // -- [spAntiguedad] ------------------------

    @Digits(integer = 10, fraction = 0)
    @Column(name = "sp_antiguedad", precision = 10)
    public Integer getSpAntiguedad() {
        return spAntiguedad;
    }

    public void setSpAntiguedad(Integer spAntiguedad) {
        this.spAntiguedad = spAntiguedad;
    }

    public OfertasDetalle spAntiguedad(Integer spAntiguedad) {
        setSpAntiguedad(spAntiguedad);
        return this;
    }
    // -- [spEquipo1] ------------------------

    @Size(max = 100, message = "{message.ofertasDetalle.spEquipo1.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_equipo1", length = 100)
    public String getSpEquipo1() {
        return spEquipo1;
    }

    public void setSpEquipo1(String spEquipo1) {
        this.spEquipo1 = spEquipo1;
    }

    public OfertasDetalle spEquipo1(String spEquipo1) {
        setSpEquipo1(spEquipo1);
        return this;
    }
    // -- [spCosto1] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "sp_costo1", precision = 18, scale = 5)
    public BigDecimal getSpCosto1() {
        return spCosto1;
    }

    public void setSpCosto1(BigDecimal spCosto1) {
        this.spCosto1 = spCosto1;
    }

    public OfertasDetalle spCosto1(BigDecimal spCosto1) {
        setSpCosto1(spCosto1);
        return this;
    }
    // -- [spImputacion1] ------------------------

    @Size(max = 10, message = "{message.ofertasDetalle.spImputacion1.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_imputacion1", length = 10)
    public String getSpImputacion1() {
        return spImputacion1;
    }

    public void setSpImputacion1(String spImputacion1) {
        this.spImputacion1 = spImputacion1;
    }

    public OfertasDetalle spImputacion1(String spImputacion1) {
        setSpImputacion1(spImputacion1);
        return this;
    }
    // -- [spEquipo2] ------------------------

    @Size(max = 100, message = "{message.ofertasDetalle.spEquipo2.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_equipo2", length = 100)
    public String getSpEquipo2() {
        return spEquipo2;
    }

    public void setSpEquipo2(String spEquipo2) {
        this.spEquipo2 = spEquipo2;
    }

    public OfertasDetalle spEquipo2(String spEquipo2) {
        setSpEquipo2(spEquipo2);
        return this;
    }
    // -- [spCosto2] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "sp_costo2", precision = 18, scale = 5)
    public BigDecimal getSpCosto2() {
        return spCosto2;
    }

    public void setSpCosto2(BigDecimal spCosto2) {
        this.spCosto2 = spCosto2;
    }

    public OfertasDetalle spCosto2(BigDecimal spCosto2) {
        setSpCosto2(spCosto2);
        return this;
    }
    // -- [spImputacion2] ------------------------

    @Size(max = 10, message = "{message.ofertasDetalle.spImputacion2.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_imputacion2", length = 10)
    public String getSpImputacion2() {
        return spImputacion2;
    }

    public void setSpImputacion2(String spImputacion2) {
        this.spImputacion2 = spImputacion2;
    }

    public OfertasDetalle spImputacion2(String spImputacion2) {
        setSpImputacion2(spImputacion2);
        return this;
    }
    // -- [spEquipo3] ------------------------

    @Size(max = 100, message = "{message.ofertasDetalle.spEquipo3.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_equipo3", length = 100)
    public String getSpEquipo3() {
        return spEquipo3;
    }

    public void setSpEquipo3(String spEquipo3) {
        this.spEquipo3 = spEquipo3;
    }

    public OfertasDetalle spEquipo3(String spEquipo3) {
        setSpEquipo3(spEquipo3);
        return this;
    }
    // -- [spCosto3] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "sp_costo3", precision = 18, scale = 5)
    public BigDecimal getSpCosto3() {
        return spCosto3;
    }

    public void setSpCosto3(BigDecimal spCosto3) {
        this.spCosto3 = spCosto3;
    }

    public OfertasDetalle spCosto3(BigDecimal spCosto3) {
        setSpCosto3(spCosto3);
        return this;
    }
    // -- [spImputacion3] ------------------------

    @Size(max = 10, message = "{message.ofertasDetalle.spImputacion3.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_imputacion3", length = 10)
    public String getSpImputacion3() {
        return spImputacion3;
    }

    public void setSpImputacion3(String spImputacion3) {
        this.spImputacion3 = spImputacion3;
    }

    public OfertasDetalle spImputacion3(String spImputacion3) {
        setSpImputacion3(spImputacion3);
        return this;
    }
    // -- [spEquipo4] ------------------------

    @Size(max = 100, message = "{message.ofertasDetalle.spEquipo4.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_equipo4", length = 100)
    public String getSpEquipo4() {
        return spEquipo4;
    }

    public void setSpEquipo4(String spEquipo4) {
        this.spEquipo4 = spEquipo4;
    }

    public OfertasDetalle spEquipo4(String spEquipo4) {
        setSpEquipo4(spEquipo4);
        return this;
    }
    // -- [spCosto4] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "sp_costo4", precision = 18, scale = 5)
    public BigDecimal getSpCosto4() {
        return spCosto4;
    }

    public void setSpCosto4(BigDecimal spCosto4) {
        this.spCosto4 = spCosto4;
    }

    public OfertasDetalle spCosto4(BigDecimal spCosto4) {
        setSpCosto4(spCosto4);
        return this;
    }
    // -- [spImputacion4] ------------------------

    @Size(max = 10, message = "{message.ofertasDetalle.spImputacion4.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_imputacion4", length = 10)
    public String getSpImputacion4() {
        return spImputacion4;
    }

    public void setSpImputacion4(String spImputacion4) {
        this.spImputacion4 = spImputacion4;
    }

    public OfertasDetalle spImputacion4(String spImputacion4) {
        setSpImputacion4(spImputacion4);
        return this;
    }
    // -- [spEquipo5] ------------------------

    @Size(max = 100, message = "{message.ofertasDetalle.spEquipo5.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_equipo5", length = 100)
    public String getSpEquipo5() {
        return spEquipo5;
    }

    public void setSpEquipo5(String spEquipo5) {
        this.spEquipo5 = spEquipo5;
    }

    public OfertasDetalle spEquipo5(String spEquipo5) {
        setSpEquipo5(spEquipo5);
        return this;
    }
    // -- [spCosto5] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "sp_costo5", precision = 18, scale = 5)
    public BigDecimal getSpCosto5() {
        return spCosto5;
    }

    public void setSpCosto5(BigDecimal spCosto5) {
        this.spCosto5 = spCosto5;
    }

    public OfertasDetalle spCosto5(BigDecimal spCosto5) {
        setSpCosto5(spCosto5);
        return this;
    }
    // -- [spImputacion5] ------------------------

    @Size(max = 10, message = "{message.ofertasDetalle.spImputacion5.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_imputacion5", length = 10)
    public String getSpImputacion5() {
        return spImputacion5;
    }

    public void setSpImputacion5(String spImputacion5) {
        this.spImputacion5 = spImputacion5;
    }

    public OfertasDetalle spImputacion5(String spImputacion5) {
        setSpImputacion5(spImputacion5);
        return this;
    }
    // -- [spEquipo6] ------------------------

    @Size(max = 100, message = "{message.ofertasDetalle.spEquipo6.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_equipo6", length = 100)
    public String getSpEquipo6() {
        return spEquipo6;
    }

    public void setSpEquipo6(String spEquipo6) {
        this.spEquipo6 = spEquipo6;
    }

    public OfertasDetalle spEquipo6(String spEquipo6) {
        setSpEquipo6(spEquipo6);
        return this;
    }
    // -- [spCosto6] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "sp_costo6", precision = 18, scale = 5)
    public BigDecimal getSpCosto6() {
        return spCosto6;
    }

    public void setSpCosto6(BigDecimal spCosto6) {
        this.spCosto6 = spCosto6;
    }

    public OfertasDetalle spCosto6(BigDecimal spCosto6) {
        setSpCosto6(spCosto6);
        return this;
    }
    // -- [spImputacion6] ------------------------

    @Size(max = 10, message = "{message.ofertasDetalle.spImputacion6.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_imputacion6", length = 10)
    public String getSpImputacion6() {
        return spImputacion6;
    }

    public void setSpImputacion6(String spImputacion6) {
        this.spImputacion6 = spImputacion6;
    }

    public OfertasDetalle spImputacion6(String spImputacion6) {
        setSpImputacion6(spImputacion6);
        return this;
    }
    // -- [spObservacion] ------------------------

    @Size(max = 500, message = "{message.ofertasDetalle.spObservacion.sizeMax} {max} {message.caracter}")
    @Column(name = "sp_observacion", length = 500)
    public String getSpObservacion() {
        return spObservacion;
    }

    public void setSpObservacion(String spObservacion) {
        this.spObservacion = spObservacion;
    }

    public OfertasDetalle spObservacion(String spObservacion) {
        setSpObservacion(spObservacion);
        return this;
    }
    // -- [ssCodigoSisego] ------------------------

    @Size(max = 20, message = "{message.ofertasDetalle.ssCodigoSisego.sizeMax} {max} {message.caracter}")
    @Column(name = "ss_codigo_sisego", length = 20)
    public String getSsCodigoSisego() {
        return ssCodigoSisego;
    }

    public void setSsCodigoSisego(String ssCodigoSisego) {
        this.ssCodigoSisego = ssCodigoSisego;
    }

    public OfertasDetalle ssCodigoSisego(String ssCodigoSisego) {
        setSsCodigoSisego(ssCodigoSisego);
        return this;
    }
    // -- [ssAntiguedad ] ------------------------

    @Digits(integer = 10, fraction = 0)
    @Column(name = "ss_antiguedad ", precision = 10)
    public Integer getSsAntiguedad() {
        return ssAntiguedad;
    }

    public void setSsAntiguedad(Integer ssAntiguedad) {
        this.ssAntiguedad = ssAntiguedad;
    }

    public OfertasDetalle ssAntiguedad(Integer ssAntiguedad) {
        setSsAntiguedad(ssAntiguedad);
        return this;
    }
    // -- [ssCostoAntiguo] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "ss_costo_antiguo", precision = 18, scale = 5)
    public BigDecimal getSsCostoAntiguo() {
        return ssCostoAntiguo;
    }

    public void setSsCostoAntiguo(BigDecimal ssCostoAntiguo) {
        this.ssCostoAntiguo = ssCostoAntiguo;
    }

    public OfertasDetalle ssCostoAntiguo(BigDecimal ssCostoAntiguo) {
        setSsCostoAntiguo(ssCostoAntiguo);
        return this;
    }
    // -- [ssValorResidual] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "ss_valor_residual", precision = 18, scale = 5)
    public BigDecimal getSsValorResidual() {
        return ssValorResidual;
    }

    public void setSsValorResidual(BigDecimal ssValorResidual) {
        this.ssValorResidual = ssValorResidual;
    }

    public OfertasDetalle ssValorResidual(BigDecimal ssValorResidual) {
        setSsValorResidual(ssValorResidual);
        return this;
    }
    // -- [ssDiasejecucion] ------------------------

    @Size(max = 50, message = "{message.ofertasDetalle.ssDiasejecucion.sizeMax} {max} {message.caracter}")
    @Column(name = "ss_diasejecucion", length = 50)
    public String getSsDiasejecucion() {
        return ssDiasejecucion;
    }

    public void setSsDiasejecucion(String ssDiasejecucion) {
        this.ssDiasejecucion = ssDiasejecucion;
    }

    public OfertasDetalle ssDiasejecucion(String ssDiasejecucion) {
        setSsDiasejecucion(ssDiasejecucion);
        return this;
    }
    // -- [ssUltimamilla] ------------------------

    @Digits(integer = 13, fraction = 5)
    @Column(name = "ss_ultimamilla", precision = 18, scale = 5)
    public BigDecimal getSsUltimamilla() {
        return ssUltimamilla;
    }

    public void setSsUltimamilla(BigDecimal ssUltimamilla) {
        this.ssUltimamilla = ssUltimamilla;
    }

    public OfertasDetalle ssUltimamilla(BigDecimal ssUltimamilla) {
        setSsUltimamilla(ssUltimamilla);
        return this;
    }
    // -- [ssCostoTransmision] ------------------------

    @Size(max = 9, message = "{message.ofertasDetalle.ssCostoTransmision.sizeMax} {max} {message.caracter}")
    @Column(name = "ss_costo_transmision", length = 9)
    public String getSsCostoTransmision() {
        return ssCostoTransmision;
    }

    public void setSsCostoTransmision(String ssCostoTransmision) {
        this.ssCostoTransmision = ssCostoTransmision;
    }

    public OfertasDetalle ssCostoTransmision(String ssCostoTransmision) {
        setSsCostoTransmision(ssCostoTransmision);
        return this;
    }
    // -- [ssCostoPlantaexterna] ------------------------

    @Digits(integer = 4, fraction = 5)
    @Column(name = "ss_costo_plantaExterna", precision = 9, scale = 5)
    public BigDecimal getSsCostoPlantaexterna() {
        return ssCostoPlantaexterna;
    }

    public void setSsCostoPlantaexterna(BigDecimal ssCostoPlantaexterna) {
        this.ssCostoPlantaexterna = ssCostoPlantaexterna;
    }

    public OfertasDetalle ssCostoPlantaexterna(BigDecimal ssCostoPlantaexterna) {
        setSsCostoPlantaexterna(ssCostoPlantaexterna);
        return this;
    }
    // -- [ssCostoOpex] ------------------------

    @Digits(integer = 4, fraction = 5)
    @Column(name = "ss_costo_opex", precision = 9, scale = 5)
    public BigDecimal getSsCostoOpex() {
        return ssCostoOpex;
    }

    public void setSsCostoOpex(BigDecimal ssCostoOpex) {
        this.ssCostoOpex = ssCostoOpex;
    }

    public OfertasDetalle ssCostoOpex(BigDecimal ssCostoOpex) {
        setSsCostoOpex(ssCostoOpex);
        return this;
    }

    // -----------------------------------------------------------------
    // Many to One support
    // -----------------------------------------------------------------

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: OfertasDetalle.spAccionIsis ==> AccionIsis.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @NotNull
    @JoinColumn(name = "sp_accion_isis_id", nullable = false)
    @ManyToOne
    public AccionIsis getSpAccionIsis() {
        return spAccionIsis;
    }

    /**
     * Set the {@link #spAccionIsis} without adding this OfertasDetalle instance on the passed {@link #spAccionIsis}
     */
    public void setSpAccionIsis(AccionIsis spAccionIsis) {
        this.spAccionIsis = spAccionIsis;
    }

    public OfertasDetalle spAccionIsis(AccionIsis spAccionIsis) {
        setSpAccionIsis(spAccionIsis);
        return this;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: OfertasDetalle.spCondicionCircuito ==> CondicionCircuito.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @NotNull
    @JoinColumn(name = "sp_condicion_circuito_id", nullable = false)
    @ManyToOne
    public CondicionCircuito getSpCondicionCircuito() {
        return spCondicionCircuito;
    }

    /**
     * Set the {@link #spCondicionCircuito} without adding this OfertasDetalle instance on the passed {@link #spCondicionCircuito}
     */
    public void setSpCondicionCircuito(CondicionCircuito spCondicionCircuito) {
        this.spCondicionCircuito = spCondicionCircuito;
    }

    public OfertasDetalle spCondicionCircuito(CondicionCircuito spCondicionCircuito) {
        setSpCondicionCircuito(spCondicionCircuito);
        return this;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: OfertasDetalle.ssCondicionSisego ==> CondicionSisego.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @JoinColumn(name = "ss_condicion_sisego_id")
    @ManyToOne
    public CondicionSisego getSsCondicionSisego() {
        return ssCondicionSisego;
    }

    /**
     * Set the {@link #ssCondicionSisego} without adding this OfertasDetalle instance on the passed {@link #ssCondicionSisego}
     */
    public void setSsCondicionSisego(CondicionSisego ssCondicionSisego) {
        this.ssCondicionSisego = ssCondicionSisego;
    }

    public OfertasDetalle ssCondicionSisego(CondicionSisego ssCondicionSisego) {
        setSsCondicionSisego(ssCondicionSisego);
        return this;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: OfertasDetalle.spTipoSede ==> TipoSede.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @NotNull
    @JoinColumn(name = "sp_tipo_sede_id", nullable = false)
    @ManyToOne
    public TipoSede getSpTipoSede() {
        return spTipoSede;
    }

    /**
     * Set the {@link #spTipoSede} without adding this OfertasDetalle instance on the passed {@link #spTipoSede}
     */
    public void setSpTipoSede(TipoSede spTipoSede) {
        this.spTipoSede = spTipoSede;
    }

    public OfertasDetalle spTipoSede(TipoSede spTipoSede) {
        setSpTipoSede(spTipoSede);
        return this;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: OfertasDetalle.spMedioAcceso ==> MedioAcceso.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @NotNull
    @JoinColumn(name = "sp_medio_acceso_id", nullable = false)
    @ManyToOne
    public MedioAcceso getSpMedioAcceso() {
        return spMedioAcceso;
    }

    /**
     * Set the {@link #spMedioAcceso} without adding this OfertasDetalle instance on the passed {@link #spMedioAcceso}
     */
    public void setSpMedioAcceso(MedioAcceso spMedioAcceso) {
        this.spMedioAcceso = spMedioAcceso;
    }

    public OfertasDetalle spMedioAcceso(MedioAcceso spMedioAcceso) {
        setSpMedioAcceso(spMedioAcceso);
        return this;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: OfertasDetalle.spTipoCircuito ==> TipoCircuito.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @NotNull
    @JoinColumn(name = "sp_tipo_circuito_id", nullable = false)
    @ManyToOne
    public TipoCircuito getSpTipoCircuito() {
        return spTipoCircuito;
    }

    /**
     * Set the {@link #spTipoCircuito} without adding this OfertasDetalle instance on the passed {@link #spTipoCircuito}
     */
    public void setSpTipoCircuito(TipoCircuito spTipoCircuito) {
        this.spTipoCircuito = spTipoCircuito;
    }

    public OfertasDetalle spTipoCircuito(TipoCircuito spTipoCircuito) {
        setSpTipoCircuito(spTipoCircuito);
        return this;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: OfertasDetalle.spTipoInstalacionSatelital ==> TipoInstalacionSatelital.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @NotNull
    @JoinColumn(name = "sp_tipo_instalacion_satelital_id", nullable = false)
    @ManyToOne
    public TipoInstalacionSatelital getSpTipoInstalacionSatelital() {
        return spTipoInstalacionSatelital;
    }

    /**
     * Set the {@link #spTipoInstalacionSatelital} without adding this OfertasDetalle instance on the passed {@link #spTipoInstalacionSatelital}
     */
    public void setSpTipoInstalacionSatelital(TipoInstalacionSatelital spTipoInstalacionSatelital) {
        this.spTipoInstalacionSatelital = spTipoInstalacionSatelital;
    }

    public OfertasDetalle spTipoInstalacionSatelital(TipoInstalacionSatelital spTipoInstalacionSatelital) {
        setSpTipoInstalacionSatelital(spTipoInstalacionSatelital);
        return this;
    }

    // -----------------------------------------------------------------
    // One to one
    // -----------------------------------------------------------------

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // Owner side of one-to-one relation: OfertasDetalle.id ==> ContactoSede.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @JoinColumn(name = "ofertas_detalle_id", nullable = false, unique = true)
    @MapsId
    @OneToOne
    public ContactoSede getContactoSede() {
        return contactoSede;
    }

    public void setContactoSede(ContactoSede contactoSede) {
        this.contactoSede = contactoSede;
    }

    public OfertasDetalle contactoSede(ContactoSede contactoSede) {
        setContactoSede(contactoSede);
        return this;
    }

    /**
     * Apply the default values.
     */
    public OfertasDetalle withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof OfertasDetalle && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this OfertasDetalle instance.
     * @see java.lang.Object#toString()
     */
    @Override
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
                .add("saEquipo2", getSaEquipo2()) //
                .add("saCosto2", getSaCosto2()) //
                .add("saImputacion2", getSaImputacion2()) //
                .add("saEquipo3", getSaEquipo3()) //
                .add("saCosto3", getSaCosto3()) //
                .add("saImputacion3", getSaImputacion3()) //
                .add("saEquipo4", getSaEquipo4()) //
                .add("saCosto4", getSaCosto4()) //
                .add("saImputacion4", getSaImputacion4()) //
                .add("saEquipo5", getSaEquipo5()) //
                .add("saCosto5", getSaCosto5()) //
                .add("saImputacion5", getSaImputacion5()) //
                .add("saEquipo6", getSaEquipo6()) //
                .add("saCosto6", getSaCosto6()) //
                .add("saImputacion6", getSaImputacion6()) //
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
                .add("spEquipo2", getSpEquipo2()) //
                .add("spCosto2", getSpCosto2()) //
                .add("spImputacion2", getSpImputacion2()) //
                .add("spEquipo3", getSpEquipo3()) //
                .add("spCosto3", getSpCosto3()) //
                .add("spImputacion3", getSpImputacion3()) //
                .add("spEquipo4", getSpEquipo4()) //
                .add("spCosto4", getSpCosto4()) //
                .add("spImputacion4", getSpImputacion4()) //
                .add("spEquipo5", getSpEquipo5()) //
                .add("spCosto5", getSpCosto5()) //
                .add("spImputacion5", getSpImputacion5()) //
                .add("spEquipo6", getSpEquipo6()) //
                .add("spCosto6", getSpCosto6()) //
                .add("spImputacion6", getSpImputacion6()) //
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
                .add("ssCostoOpex", getSsCostoOpex()) //
                .toString();
    }
}
