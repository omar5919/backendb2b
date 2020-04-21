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
@Table(name = "sede_cliente")
//@Audited
//@AuditTable("_audi_sede_cliente")
public class SedeCliente extends BaseDomain implements Identifiable<Integer>, Serializable {
	 private static final long serialVersionUID = 1L;
	    private static final Logger log = Logger.getLogger(SedeCliente.class.getName());

	    /***************************/
	    /* Atributos de la Entidad */
	    /***************************/

	    // Raw attributes
	    private Integer id;
	    private Integer clienteId;
	    private String sede;
	    private String direccion;
	    private String distrito;
	    private String provincia;
	    private String departamento;
	    private Double latitud;
	    private Double longitud;
	    private Integer zoom;
	    private String direccionMap;
	    private String contactos;

	    @Override
	    public String entityClassName() {
	        return SedeCliente.class.getSimpleName();
	    }

	    // -- [id] ------------------------

	    @Override
	    @Column(name = "sede_cliente_id", precision = 10)
	    @GeneratedValue(strategy = SEQUENCE, generator = "seq_sede_cliente")
	    @Id
	    @SequenceGenerator(name = "seq_sede_cliente", sequenceName = "seq_sede_cliente", allocationSize = 1)
	    public Integer getId() {
	        return id;
	    }

	    @Override
	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public SedeCliente id(Integer id) {
	        setId(id);
	        return this;
	    }

	    @Override
	    @Transient
	    public boolean isIdSet() {
	        return id != null;
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

	    public SedeCliente clienteId(Integer clienteId) {
	        setClienteId(clienteId);
	        return this;
	    }
	    // -- [sede] ------------------------

	    @Size(max = 250, message = "{message.sedeCliente.sede.sizeMax} {max} {message.caracter}")
	    @Column(name = "sede", length = 250)
	    public String getSede() {
	        return sede;
	    }

	    public void setSede(String sede) {
	        this.sede = sede;
	    }

	    public SedeCliente sede(String sede) {
	        setSede(sede);
	        return this;
	    }
	    // -- [direccion] ------------------------

	    @Size(max = 250, message = "{message.sedeCliente.direccion.sizeMax} {max} {message.caracter}")
	    @Column(name = "direccion", length = 250)
	    public String getDireccion() {
	        return direccion;
	    }

	    public void setDireccion(String direccion) {
	        this.direccion = direccion;
	    }

	    public SedeCliente direccion(String direccion) {
	        setDireccion(direccion);
	        return this;
	    }
	    // -- [distrito] ------------------------

	    @Size(max = 50, message = "{message.sedeCliente.distrito.sizeMax} {max} {message.caracter}")
	    @Column(name = "distrito", length = 50)
	    public String getDistrito() {
	        return distrito;
	    }

	    public void setDistrito(String distrito) {
	        this.distrito = distrito;
	    }

	    public SedeCliente distrito(String distrito) {
	        setDistrito(distrito);
	        return this;
	    }
	    // -- [provincia] ------------------------

	    @Size(max = 50, message = "{message.sedeCliente.provincia.sizeMax} {max} {message.caracter}")
	    @Column(name = "provincia", length = 50)
	    public String getProvincia() {
	        return provincia;
	    }

	    public void setProvincia(String provincia) {
	        this.provincia = provincia;
	    }

	    public SedeCliente provincia(String provincia) {
	        setProvincia(provincia);
	        return this;
	    }
	    // -- [departamento] ------------------------

	    @Size(max = 50, message = "{message.sedeCliente.departamento.sizeMax} {max} {message.caracter}")
	    @Column(name = "departamento", length = 50)
	    public String getDepartamento() {
	        return departamento;
	    }

	    public void setDepartamento(String departamento) {
	        this.departamento = departamento;
	    }

	    public SedeCliente departamento(String departamento) {
	        setDepartamento(departamento);
	        return this;
	    }
	    // -- [latitud] ------------------------

	    @Digits(integer = 0, fraction = 17)
	    @Column(name = "latitud", precision = 17, scale = 17)
	    public Double getLatitud() {
	        return latitud;
	    }

	    public void setLatitud(Double latitud) {
	        this.latitud = latitud;
	    }

	    public SedeCliente latitud(Double latitud) {
	        setLatitud(latitud);
	        return this;
	    }
	    // -- [longitud] ------------------------

	    @Digits(integer = 0, fraction = 17)
	    @Column(name = "longitud", precision = 17, scale = 17)
	    public Double getLongitud() {
	        return longitud;
	    }

	    public void setLongitud(Double longitud) {
	        this.longitud = longitud;
	    }

	    public SedeCliente longitud(Double longitud) {
	        setLongitud(longitud);
	        return this;
	    }
	    // -- [zoom] ------------------------

	    @Digits(integer = 10, fraction = 0)
	    @Column(name = "zoom", precision = 10)
	    public Integer getZoom() {
	        return zoom;
	    }

	    public void setZoom(Integer zoom) {
	        this.zoom = zoom;
	    }

	    public SedeCliente zoom(Integer zoom) {
	        setZoom(zoom);
	        return this;
	    }
	    // -- [direccionMap] ------------------------

	    @Size(max = 300, message = "{message.sedeCliente.direccionMap.sizeMax} {max} {message.caracter}")
	    @Column(name = "direccion_map", length = 300)
	    public String getDireccionMap() {
	        return direccionMap;
	    }

	    public void setDireccionMap(String direccionMap) {
	        this.direccionMap = direccionMap;
	    }

	    public SedeCliente direccionMap(String direccionMap) {
	        setDireccionMap(direccionMap);
	        return this;
	    }
	    // -- [contactos] ------------------------

	    @Size(max = 300, message = "{message.sedeCliente.contactos.sizeMax} {max} {message.caracter}")
	    @Column(name = "contactos", length = 300)
	    public String getContactos() {
	        return contactos;
	    }

	    public void setContactos(String contactos) {
	        this.contactos = contactos;
	    }

	    public SedeCliente contactos(String contactos) {
	        setContactos(contactos);
	        return this;
	    }

	    /**
	     * Apply the default values.
	     */
	    public SedeCliente withDefaults() {
	        return this;
	    }

	    /**
	     * Equals implementation using a business key.
	     */
	    @Override
	    public boolean equals(Object other) {
	        return this == other || (other instanceof SedeCliente && hashCode() == other.hashCode());
	    }

	    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

	    @Override
	    public int hashCode() {
	        return identifiableHashBuilder.hash(log, this);
	    }

	    /**
	     * Construct a readable string representation for this SedeCliente instance.
	     * @see java.lang.Object#toString()
	     */
	    @Override
	    public String toString() {
	        return MoreObjects.toStringHelper(this) //
	                .add("id", getId()) //
	                .add("clienteId", getClienteId()) //
	                .add("sede", getSede()) //
	                .add("direccion", getDireccion()) //
	                .add("distrito", getDistrito()) //
	                .add("provincia", getProvincia()) //
	                .add("departamento", getDepartamento()) //
	                .add("latitud", getLatitud()) //
	                .add("longitud", getLongitud()) //
	                .add("zoom", getZoom()) //
	                .add("direccionMap", getDireccionMap()) //
	                .add("contactos", getContactos()) //
	                .toString();
	    }
}
