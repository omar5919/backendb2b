package com.incloud.tgestiona.b2b.model;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

 

import com.google.common.base.MoreObjects;
import com.incloud.tgestiona.domain.BaseDomain;
import com.sun.istack.NotNull;

@Entity
@Table(name = "oportunidad")
//@Audited
//@AuditTable("_audi_oportunidad")
public class Oportunidad extends BaseDomain implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(Oportunidad.class.getName());

    /***************************/
    /* Atributos de la Entidad */
    /***************************/

    // Raw attributes
    private Integer id;
    private String oportunidadCodigo;
    private String descripcion;
    private Integer clienteId;
    private String segmento;
    private String gerenteCuenta;

    @Override
    public String entityClassName() {
        return Oportunidad.class.getSimpleName();
    }

    // -- [id] ------------------------

    @Override
    @Column(name = "oportunidad_id", precision = 10)
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_oportunidad")
    @Id
    @SequenceGenerator(name = "seq_oportunidad", sequenceName = "seq_oportunidad", allocationSize = 1)
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Oportunidad id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    public boolean isIdSet() {
        return id != null;
    }
    // -- [oportunidadCodigo] ------------------------

    @NotEmpty(message = "{message.oportunidad.oportunidadCodigo.requerido}")
    @Size(max = 2, message = "{message.oportunidad.oportunidadCodigo.sizeMax} {max} {message.caracter}")
    @Column(name = "oportunidad_codigo", nullable = false, length = 2)
    public String getOportunidadCodigo() {
        return oportunidadCodigo;
    }

    public void setOportunidadCodigo(String oportunidadCodigo) {
        this.oportunidadCodigo = oportunidadCodigo;
    }

    public Oportunidad oportunidadCodigo(String oportunidadCodigo) {
        setOportunidadCodigo(oportunidadCodigo);
        return this;
    }
    // -- [descripcion] ------------------------

    @NotEmpty(message = "{message.oportunidad.descripcion.requerido}")
    @Size(max = 50, message = "{message.oportunidad.descripcion.sizeMax} {max} {message.caracter}")
    @Column(name = "descripcion", nullable = false, length = 50)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Oportunidad descripcion(String descripcion) {
        setDescripcion(descripcion);
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

    public Oportunidad clienteId(Integer clienteId) {
        setClienteId(clienteId);
        return this;
    }
    // -- [segmento] ------------------------

    @NotEmpty(message = "{message.oportunidad.segmento.requerido}")
    @Size(max = 200, message = "{message.oportunidad.segmento.sizeMax} {max} {message.caracter}")
    @Column(name = "segmento", nullable = false, length = 200)
    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    public Oportunidad segmento(String segmento) {
        setSegmento(segmento);
        return this;
    }
    // -- [gerenteCuenta] ------------------------

    @Size(max = 200, message = "{message.oportunidad.gerenteCuenta.sizeMax} {max} {message.caracter}")
    @Column(name = "gerente_cuenta", length = 200)
    public String getGerenteCuenta() {
        return gerenteCuenta;
    }

    public void setGerenteCuenta(String gerenteCuenta) {
        this.gerenteCuenta = gerenteCuenta;
    }

    public Oportunidad gerenteCuenta(String gerenteCuenta) {
        setGerenteCuenta(gerenteCuenta);
        return this;
    }

    /**
     * Apply the default values.
     */
    public Oportunidad withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Oportunidad && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this Oportunidad instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("oportunidadCodigo", getOportunidadCodigo()) //
                .add("descripcion", getDescripcion()) //
                .add("clienteId", getClienteId()) //
                .add("segmento", getSegmento()) //
                .add("gerenteCuenta", getGerenteCuenta()) //
                .toString();
    }
}
