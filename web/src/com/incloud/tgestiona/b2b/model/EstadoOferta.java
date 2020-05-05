package com.incloud.tgestiona.b2b.model;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.google.common.base.MoreObjects;
import com.incloud.tgestiona.domain.BaseDomain;

@Entity
@Table(name = "estado_oferta",schema = "b2b_dev")
//@Audited
//@AuditTable("_audi_estado")
public class EstadoOferta extends BaseDomain implements Identifiable<Integer>, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(EstadoOferta.class.getName());

	/***************************/
	/* Atributos de la Entidad */
	/***************************/

	// Raw attributes
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estado_oferta_id" ,nullable = true, precision = 10)
	private Integer id;
	private String codigoEstado;
	private String descripcion;
	private String color;

	@Override
	public String entityClassName() {
		return EstadoOferta.class.getSimpleName();
	}

	// -- [id] ------------------------


	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public EstadoOferta id(Integer id) {
		setId(id);
		return this;
	}

	@Override
	@Transient
	public boolean isIdSet() {
		return id != null;
	}
	// -- [codigoEstado] ------------------------

	@NotEmpty(message = "{message.estado.codigoEstado.requerido}")
	@Size(max = 5, message = "{message.estado.codigoEstado.sizeMax} {max} {message.caracter}")
	@Column(name = "codigo_estado", nullable = false, length = 5)
	public String getCodigoEstado() {
		return codigoEstado;
	}

	public void setCodigoEstado(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

	public EstadoOferta codigoEstado(String codigoEstado) {
		setCodigoEstado(codigoEstado);
		return this;
	}
	// -- [descripcion] ------------------------

	@NotEmpty(message = "{message.estado.descripcion.requerido}")
	@Size(max = 50, message = "{message.estado.descripcion.sizeMax} {max} {message.caracter}")
	@Column(name = "descripcion", nullable = false, length = 50)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public EstadoOferta descripcion(String descripcion) {
		setDescripcion(descripcion);
		return this;
	}
	// -- [color] ------------------------

	@Size(max = 20, message = "{message.estado.color.sizeMax} {max} {message.caracter}")
	@Column(name = "color", length = 20)
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public EstadoOferta color(String color) {
		setColor(color);
		return this;
	}

	/**
	 * Apply the default values.
	 */
	public EstadoOferta withDefaults() {
		return this;
	}

	/**
	 * Equals implementation using a business key.
	 */
	@Override
	public boolean equals(Object other) {
		return this == other || (other instanceof EstadoOferta && hashCode() == other.hashCode());
	}

	private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

	@Override
	public int hashCode() {
		return identifiableHashBuilder.hash(log, this);
	}

	/**
	 * Construct a readable string representation for this Estado instance.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this) //
				.add("id", getId()) //
				.add("createdBy", getCreatedBy()) //
				.add("createdDate", getCreatedDate()) //
				.add("modifiedBy", getModifiedBy()) //
				.add("modifiedDate", getModifiedDate()) //
				.add("codigoEstado", getCodigoEstado()) //
				.add("descripcion", getDescripcion()) //
				.add("color", getColor()) //
				.toString();
	}
}