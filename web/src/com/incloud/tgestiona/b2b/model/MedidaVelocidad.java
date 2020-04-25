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

@Entity
@Table(name = "medida_velocidad")
//@Audited
//@AuditTable("_audi_medida_velocidad")
public class MedidaVelocidad extends BaseDomain implements Identifiable<Integer>, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(MedidaVelocidad.class.getName());

	/***************************/
	/* Atributos de la Entidad */
	/***************************/

	// Raw attributes
	private Integer id;
	private Integer orden;
	private String descripcion;

	@Override
	public String entityClassName() {
		return MedidaVelocidad.class.getSimpleName();
	}

	// -- [id] ------------------------

	@Override
	@Column(name = "medida_velocidad_id", precision = 10)
	@GeneratedValue(strategy = SEQUENCE, generator = "seq_medida_velocidad")
	@Id
	@SequenceGenerator(name = "seq_medida_velocidad", sequenceName = "seq_medida_velocidad", allocationSize = 1)
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public MedidaVelocidad id(Integer id) {
		setId(id);
		return this;
	}

	@Override
	@Transient
	public boolean isIdSet() {
		return id != null;
	}
	// -- [orden] ------------------------

	@Digits(integer = 10, fraction = 0)
	@Column(name = "orden", precision = 10)
	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public MedidaVelocidad orden(Integer orden) {
		setOrden(orden);
		return this;
	}
	// -- [descripcion] ------------------------

	@Size(max = 50, message = "{message.medidaVelocidad.descripcion.sizeMax} {max} {message.caracter}")
	@Column(name = "descripcion", length = 50)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public MedidaVelocidad descripcion(String descripcion) {
		setDescripcion(descripcion);
		return this;
	}

	/**
	 * Apply the default values.
	 */
	public MedidaVelocidad withDefaults() {
		return this;
	}

	/**
	 * Equals implementation using a business key.
	 */
	@Override
	public boolean equals(Object other) {
		return this == other || (other instanceof MedidaVelocidad && hashCode() == other.hashCode());
	}

	private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

	@Override
	public int hashCode() {
		return identifiableHashBuilder.hash(log, this);
	}

	/**
	 * Construct a readable string representation for this MedidaVelocidad instance.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this) //
				.add("id", getId()) //
				.add("orden", getOrden()) //
				.add("descripcion", getDescripcion()) //
				.toString();
	}
}
