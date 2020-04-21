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
import javax.validation.constraints.Size;

 

import com.google.common.base.MoreObjects;
import com.incloud.tgestiona.domain.BaseDomain;

@Entity
@Table(name = "ubigeo")
//@Audited
//@AuditTable("_audi_ubigeo")
public class Ubigeo extends BaseDomain implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(Ubigeo.class.getName());

    /***************************/
    /* Atributos de la Entidad */
    /***************************/

    // Raw attributes
    private Integer id;
    private String codigoDepartamento;
    private String codigoProvincia;
    private String codigoDistrito;
    private String nombre;

    @Override
    public String entityClassName() {
        return Ubigeo.class.getSimpleName();
    }

    // -- [id] ------------------------

    @Override
    @Column(name = "ubigeo_id", precision = 10)
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_ubigeo")
    @Id
    @SequenceGenerator(name = "seq_ubigeo", sequenceName = "seq_ubigeo", allocationSize = 1)
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Ubigeo id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    public boolean isIdSet() {
        return id != null;
    }
    // -- [codigoDepartamento] ------------------------

    @Size(max = 2, message = "{message.ubigeo.codigoDepartamento.sizeMax} {max} {message.caracter}")
    @Column(name = "codigoDepartamento", length = 2)
    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public Ubigeo codigoDepartamento(String codigoDepartamento) {
        setCodigoDepartamento(codigoDepartamento);
        return this;
    }
    // -- [codigoProvincia] ------------------------

    @Size(max = 4, message = "{message.ubigeo.codigoProvincia.sizeMax} {max} {message.caracter}")
    @Column(name = "codigoProvincia", length = 4)
    public String getCodigoProvincia() {
        return codigoProvincia;
    }

    public void setCodigoProvincia(String codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public Ubigeo codigoProvincia(String codigoProvincia) {
        setCodigoProvincia(codigoProvincia);
        return this;
    }
    // -- [codigoDistrito] ------------------------

    @Size(max = 6, message = "{message.ubigeo.codigoDistrito.sizeMax} {max} {message.caracter}")
    @Column(name = "codigoDistrito", length = 6)
    public String getCodigoDistrito() {
        return codigoDistrito;
    }

    public void setCodigoDistrito(String codigoDistrito) {
        this.codigoDistrito = codigoDistrito;
    }

    public Ubigeo codigoDistrito(String codigoDistrito) {
        setCodigoDistrito(codigoDistrito);
        return this;
    }
    // -- [nombre] ------------------------

    @Size(max = 50, message = "{message.ubigeo.nombre.sizeMax} {max} {message.caracter}")
    @Column(name = "nombre", length = 50)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ubigeo nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    /**
     * Apply the default values.
     */
    public Ubigeo withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Ubigeo && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this Ubigeo instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("codigoDepartamento", getCodigoDepartamento()) //
                .add("codigoProvincia", getCodigoProvincia()) //
                .add("codigoDistrito", getCodigoDistrito()) //
                .add("nombre", getNombre()) //
                .toString();
    }
}
