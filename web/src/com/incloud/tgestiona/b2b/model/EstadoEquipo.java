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
import com.google.common.base.Objects;
import com.incloud.tgestiona.domain.BaseDomain;
import com.sun.istack.NotNull;

@Entity
@Table(name = "estado_equipo")
//@Audited
//@AuditTable("_audi_estado_equipo")
public class EstadoEquipo extends BaseDomain implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(EstadoEquipo.class.getName());

    /***************************/
    /* Atributos de la Entidad */
    /***************************/

    // Raw attributes
    private Integer id;
    private String descripcion;

    @Override
    public String entityClassName() {
        return EstadoEquipo.class.getSimpleName();
    }

    // -- [id] ------------------------

    @Override
    @Column(name = "estado_equipo_id", precision = 10)
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_estado_equipo")
    @Id
    @SequenceGenerator(name = "seq_estado_equipo", sequenceName = "seq_estado_equipo", allocationSize = 1)
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoEquipo id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    public boolean isIdSet() {
        return id != null;
    }
    // -- [descripcion] ------------------------

    @Size(max = 50, message = "{message.estadoEquipo.descripcion.sizeMax} {max} {message.caracter}")
    @Column(name = "descripcion", length = 50)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoEquipo descripcion(String descripcion) {
        setDescripcion(descripcion);
        return this;
    }

    /**
     * Apply the default values.
     */
    public EstadoEquipo withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof EstadoEquipo && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this EstadoEquipo instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("descripcion", getDescripcion()) //
                .toString();
    }
}
