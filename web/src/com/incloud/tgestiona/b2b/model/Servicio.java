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
@Table(name = "servicio")
//@Audited
//@AuditTable("_audi_servicio")
public class Servicio extends BaseDomain implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(Servicio.class.getName());

    /***************************/
    /* Atributos de la Entidad */
    /***************************/

    // Raw attributes
    private Integer id;
    private Boolean eficienciaiPvpn;
    private String descripcion;

    @Override
    public String entityClassName() {
        return Servicio.class.getSimpleName();
    }

    // -- [id] ------------------------

    @Override
    @Column(name = "servicio_id", precision = 10)
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_servicio")
    @Id
    @SequenceGenerator(name = "seq_servicio", sequenceName = "seq_servicio", allocationSize = 1)
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Servicio id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    public boolean isIdSet() {
        return id != null;
    }
    // -- [eficienciaiPvpn] ------------------------

    @Column(name = "eficienciaI_pvpn", length = 1)
    public Boolean getEficienciaiPvpn() {
        return eficienciaiPvpn;
    }

    public void setEficienciaiPvpn(Boolean eficienciaiPvpn) {
        this.eficienciaiPvpn = eficienciaiPvpn;
    }

    public Servicio eficienciaiPvpn(Boolean eficienciaiPvpn) {
        setEficienciaiPvpn(eficienciaiPvpn);
        return this;
    }
    // -- [descripcion] ------------------------

    @Size(max = 50, message = "{message.servicio.descripcion.sizeMax} {max} {message.caracter}")
    @Column(name = "descripcion", length = 50)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Servicio descripcion(String descripcion) {
        setDescripcion(descripcion);
        return this;
    }

    /**
     * Apply the default values.
     */
    public Servicio withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Servicio && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this Servicio instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("eficienciaiPvpn", getEficienciaiPvpn()) //
                .add("descripcion", getDescripcion()) //
                .toString();
    }
}
