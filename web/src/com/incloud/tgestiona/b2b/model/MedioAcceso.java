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
@Table(name = "medio_acceso")
//@Audited
//@AuditTable("_audi_medio_acceso")
public class MedioAcceso extends BaseDomain implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(MedioAcceso.class.getName());

    /***************************/
    /* Atributos de la Entidad */
    /***************************/

    // Raw attributes
    private Integer id;
    private Integer codigoEquivalente;
    private String descripcion;

    @Override
    public String entityClassName() {
        return MedioAcceso.class.getSimpleName();
    }

    // -- [id] ------------------------

    @Override
    @Column(name = "medio_acceso_id", precision = 10)
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_medio_acceso")
    @Id
    @SequenceGenerator(name = "seq_medio_acceso", sequenceName = "seq_medio_acceso", allocationSize = 1)
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public MedioAcceso id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    public boolean isIdSet() {
        return id != null;
    }
    // -- [codigoEquivalente] ------------------------

    @Digits(integer = 10, fraction = 0)
    @NotNull
    @Column(name = "codigoEquivalente", nullable = false, precision = 10)
    public Integer getCodigoEquivalente() {
        return codigoEquivalente;
    }

    public void setCodigoEquivalente(Integer codigoEquivalente) {
        this.codigoEquivalente = codigoEquivalente;
    }

    public MedioAcceso codigoEquivalente(Integer codigoEquivalente) {
        setCodigoEquivalente(codigoEquivalente);
        return this;
    }
    // -- [descripcion] ------------------------

    @NotEmpty(message = "{message.medioAcceso.descripcion.requerido}")
    @Size(max = 50, message = "{message.medioAcceso.descripcion.sizeMax} {max} {message.caracter}")
    @Column(name = "descripcion", nullable = false, length = 50)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public MedioAcceso descripcion(String descripcion) {
        setDescripcion(descripcion);
        return this;
    }

    /**
     * Apply the default values.
     */
    public MedioAcceso withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof MedioAcceso && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this MedioAcceso instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("codigoEquivalente", getCodigoEquivalente()) //
                .add("descripcion", getDescripcion()) //
                .toString();
    }
}
