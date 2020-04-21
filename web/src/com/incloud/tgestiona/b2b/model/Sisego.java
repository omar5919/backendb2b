package com.incloud.tgestiona.b2b.model;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

 

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.incloud.tgestiona.domain.BaseDomain;

@Entity
@Table(name = "sisego")
//@Audited
//@AuditTable("_audi_sisego")
public class Sisego extends BaseDomain implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(Sisego.class.getName());

    /***************************/
    /* Atributos de la Entidad */
    /***************************/

    // Raw attributes
    private Integer id;
    private String sisegoCodigo;
    private String zona;
    private String tiempoImplementacion;
    private BigDecimal costoSoles;
    private BigDecimal costoOpex;
    private String estadoRecurso;
    private String estadoCodigo;
    private BigDecimal montoCircuito;
    private Integer antiguedad;
    private BigDecimal costoTransmision;
    private BigDecimal costoPlantaexterna;
    private BigDecimal costoNtiguo;
    private BigDecimal valorResidual;

    @Override
    public String entityClassName() {
        return Sisego.class.getSimpleName();
    }

    // -- [id] ------------------------

    @Override
    @Column(name = "sisego_id", precision = 10)
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_sisego")
    @Id
    @SequenceGenerator(name = "seq_sisego", sequenceName = "seq_sisego", allocationSize = 1)
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Sisego id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    public boolean isIdSet() {
        return id != null;
    }
    // -- [sisegoCodigo] ------------------------

    @Size(max = 20, message = "{message.sisego.sisegoCodigo.sizeMax} {max} {message.caracter}")
    @Column(name = "sisego_codigo", length = 20)
    public String getSisegoCodigo() {
        return sisegoCodigo;
    }

    public void setSisegoCodigo(String sisegoCodigo) {
        this.sisegoCodigo = sisegoCodigo;
    }

    public Sisego sisegoCodigo(String sisegoCodigo) {
        setSisegoCodigo(sisegoCodigo);
        return this;
    }
    // -- [zona] ------------------------

    @Size(max = 100, message = "{message.sisego.zona.sizeMax} {max} {message.caracter}")
    @Column(name = "zona", length = 100)
    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public Sisego zona(String zona) {
        setZona(zona);
        return this;
    }
    // -- [tiempoImplementacion] ------------------------

    @Size(max = 50, message = "{message.sisego.tiempoImplementacion.sizeMax} {max} {message.caracter}")
    @Column(name = "tiempo_implementacion", length = 50)
    public String getTiempoImplementacion() {
        return tiempoImplementacion;
    }

    public void setTiempoImplementacion(String tiempoImplementacion) {
        this.tiempoImplementacion = tiempoImplementacion;
    }

    public Sisego tiempoImplementacion(String tiempoImplementacion) {
        setTiempoImplementacion(tiempoImplementacion);
        return this;
    }
    // -- [costoSoles] ------------------------

    @Digits(integer = 12, fraction = 6)
    @Column(name = "costo_soles", precision = 18, scale = 6)
    public BigDecimal getCostoSoles() {
        return costoSoles;
    }

    public void setCostoSoles(BigDecimal costoSoles) {
        this.costoSoles = costoSoles;
    }

    public Sisego costoSoles(BigDecimal costoSoles) {
        setCostoSoles(costoSoles);
        return this;
    }
    // -- [costoOpex] ------------------------

    @Digits(integer = 12, fraction = 6)
    @Column(name = "costo_opex", precision = 18, scale = 6)
    public BigDecimal getCostoOpex() {
        return costoOpex;
    }

    public void setCostoOpex(BigDecimal costoOpex) {
        this.costoOpex = costoOpex;
    }

    public Sisego costoOpex(BigDecimal costoOpex) {
        setCostoOpex(costoOpex);
        return this;
    }
    // -- [estadoRecurso] ------------------------

    @Size(max = 10, message = "{message.sisego.estadoRecurso.sizeMax} {max} {message.caracter}")
    @Column(name = "estado_recurso", length = 10)
    public String getEstadoRecurso() {
        return estadoRecurso;
    }

    public void setEstadoRecurso(String estadoRecurso) {
        this.estadoRecurso = estadoRecurso;
    }

    public Sisego estadoRecurso(String estadoRecurso) {
        setEstadoRecurso(estadoRecurso);
        return this;
    }
    // -- [estadoCodigo] ------------------------

    @Size(max = 10, message = "{message.sisego.estadoCodigo.sizeMax} {max} {message.caracter}")
    @Column(name = "estado_codigo", length = 10)
    public String getEstadoCodigo() {
        return estadoCodigo;
    }

    public void setEstadoCodigo(String estadoCodigo) {
        this.estadoCodigo = estadoCodigo;
    }

    public Sisego estadoCodigo(String estadoCodigo) {
        setEstadoCodigo(estadoCodigo);
        return this;
    }
    // -- [montoCircuito] ------------------------

    @Digits(integer = 12, fraction = 6)
    @Column(name = "monto_circuito", precision = 18, scale = 6)
    public BigDecimal getMontoCircuito() {
        return montoCircuito;
    }

    public void setMontoCircuito(BigDecimal montoCircuito) {
        this.montoCircuito = montoCircuito;
    }

    public Sisego montoCircuito(BigDecimal montoCircuito) {
        setMontoCircuito(montoCircuito);
        return this;
    }
    // -- [antiguedad] ------------------------

    @Digits(integer = 10, fraction = 0)
    @Column(name = "antiguedad", precision = 10)
    public Integer getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Integer antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Sisego antiguedad(Integer antiguedad) {
        setAntiguedad(antiguedad);
        return this;
    }
    // -- [costoTransmision] ------------------------

    @Digits(integer = 12, fraction = 6)
    @Column(name = "costo_transmision", precision = 18, scale = 6)
    public BigDecimal getCostoTransmision() {
        return costoTransmision;
    }

    public void setCostoTransmision(BigDecimal costoTransmision) {
        this.costoTransmision = costoTransmision;
    }

    public Sisego costoTransmision(BigDecimal costoTransmision) {
        setCostoTransmision(costoTransmision);
        return this;
    }
    // -- [costoPlantaexterna] ------------------------

    @Digits(integer = 12, fraction = 6)
    @Column(name = "costo_plantaExterna", precision = 18, scale = 6)
    public BigDecimal getCostoPlantaexterna() {
        return costoPlantaexterna;
    }

    public void setCostoPlantaexterna(BigDecimal costoPlantaexterna) {
        this.costoPlantaexterna = costoPlantaexterna;
    }

    public Sisego costoPlantaexterna(BigDecimal costoPlantaexterna) {
        setCostoPlantaexterna(costoPlantaexterna);
        return this;
    }
    // -- [costoNtiguo] ------------------------

    @Digits(integer = 12, fraction = 6)
    @Column(name = "costo_ntiguo", precision = 18, scale = 6)
    public BigDecimal getCostoNtiguo() {
        return costoNtiguo;
    }

    public void setCostoNtiguo(BigDecimal costoNtiguo) {
        this.costoNtiguo = costoNtiguo;
    }

    public Sisego costoNtiguo(BigDecimal costoNtiguo) {
        setCostoNtiguo(costoNtiguo);
        return this;
    }
    // -- [valorResidual] ------------------------

    @Digits(integer = 12, fraction = 6)
    @Column(name = "valor_residual", precision = 18, scale = 6)
    public BigDecimal getValorResidual() {
        return valorResidual;
    }

    public void setValorResidual(BigDecimal valorResidual) {
        this.valorResidual = valorResidual;
    }

    public Sisego valorResidual(BigDecimal valorResidual) {
        setValorResidual(valorResidual);
        return this;
    }

    /**
     * Apply the default values.
     */
    public Sisego withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Sisego && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this Sisego instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("sisegoCodigo", getSisegoCodigo()) //
                .add("zona", getZona()) //
                .add("tiempoImplementacion", getTiempoImplementacion()) //
                .add("costoSoles", getCostoSoles()) //
                .add("costoOpex", getCostoOpex()) //
                .add("estadoRecurso", getEstadoRecurso()) //
                .add("estadoCodigo", getEstadoCodigo()) //
                .add("montoCircuito", getMontoCircuito()) //
                .add("antiguedad", getAntiguedad()) //
                .add("costoTransmision", getCostoTransmision()) //
                .add("costoPlantaexterna", getCostoPlantaexterna()) //
                .add("costoNtiguo", getCostoNtiguo()) //
                .add("valorResidual", getValorResidual()) //
                .toString();
    }
}
