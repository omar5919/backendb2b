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
import javax.validation.constraints.Size;

 

import com.google.common.base.MoreObjects;
import com.incloud.tgestiona.domain.BaseDomain;
import com.sun.istack.NotNull;
@Entity
@Table(name = "contacto_sede")
//@Audited
//@AuditTable("_audi_contacto_sede")
public class ContactoSede extends BaseDomain implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(ContactoSede.class.getName());

    /***************************/
    /* Atributos de la Entidad */
    /***************************/

    // Raw attributes
    private Integer id;
    private Integer ofertasDetalleId;
    private String nombre;
    private String celular;
    private String email;

    @Override
    public String entityClassName() {
        return ContactoSede.class.getSimpleName();
    }

    // -- [id] ------------------------

    @Override
    @Column(name = "contacto_sede_id", precision = 10)
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_contacto_sede")
    @Id
    @SequenceGenerator(name = "seq_contacto_sede", sequenceName = "seq_contacto_sede", allocationSize = 1)
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public ContactoSede id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    public boolean isIdSet() {
        return id != null;
    }
    // -- [ofertasDetalleId] ------------------------

    @Digits(integer = 10, fraction = 0)
    @NotNull
    @Column(name = "ofertas_detalle_id", nullable = false, precision = 10)
    public Integer getOfertasDetalleId() {
        return ofertasDetalleId;
    }

    public void setOfertasDetalleId(Integer ofertasDetalleId) {
        this.ofertasDetalleId = ofertasDetalleId;
    }

    public ContactoSede ofertasDetalleId(Integer ofertasDetalleId) {
        setOfertasDetalleId(ofertasDetalleId);
        return this;
    }
    // -- [nombre] ------------------------

    @Size(max = 250, message = "{message.contactoSede.nombre.sizeMax} {max} {message.caracter}")
    @Column(name = "nombre", length = 250)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ContactoSede nombre(String nombre) {
        setNombre(nombre);
        return this;
    }
    // -- [celular] ------------------------

    @Size(max = 250, message = "{message.contactoSede.celular.sizeMax} {max} {message.caracter}")
    @Column(name = "celular", length = 250)
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public ContactoSede celular(String celular) {
        setCelular(celular);
        return this;
    }
    // -- [email] ------------------------

 //   @ExtendedEmailValidator
    @Size(max = 150, message = "{message.contactoSede.email.sizeMax} {max} {message.caracter}")
    @Column(name = "email", length = 150)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ContactoSede email(String email) {
        setEmail(email);
        return this;
    }

    /**
     * Apply the default values.
     */
    public ContactoSede withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof ContactoSede && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this ContactoSede instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("ofertasDetalleId", getOfertasDetalleId()) //
                .add("nombre", getNombre()) //
                .add("celular", getCelular()) //
                .add("email", getEmail()) //
                .toString();
    }
}
