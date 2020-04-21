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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.google.common.base.MoreObjects;
import com.incloud.tgestiona.domain.BaseDomain;

@Entity
@Table(name = "tipo_servicio")
//@Audited
//@AuditTable("_audi_tipo_servicio")
public class TipoServicio extends BaseDomain implements Identifiable<Integer>, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(TipoServicio.class.getName());

	/***************************/
	/* Atributos de la Entidad */
	/***************************/

	// Raw attributes
	private Integer id;
	private String codigoIsis;
	private String descripcion;

	@Override
	public String entityClassName() {
		return TipoServicio.class.getSimpleName();
	}

	// -- [id] ------------------------

	@Override
	@Column(name = "tipo_servicio_id", precision = 10)
	@GeneratedValue(strategy = SEQUENCE, generator = "seq_tipo_servicio")
	@Id
	@SequenceGenerator(name = "seq_tipo_servicio", sequenceName = "seq_tipo_servicio", allocationSize = 1)
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public TipoServicio id(Integer id) {
		setId(id);
		return this;
	}

	@Override
	@Transient
	public boolean isIdSet() {
		return id != null;
	}
	// -- [codigoIsis] ------------------------

	@NotEmpty(message = "{message.tipoServicio.codigoIsis.requerido}")
	@Size(max = 15, message = "{message.tipoServicio.codigoIsis.sizeMax} {max} {message.caracter}")
	@Column(name = "codigo_isis", nullable = false, length = 15)
	public String getCodigoIsis() {
		return codigoIsis;
	}

	public void setCodigoIsis(String codigoIsis) {
		this.codigoIsis = codigoIsis;
	}

	public TipoServicio codigoIsis(String codigoIsis) {
		setCodigoIsis(codigoIsis);
		return this;
	}
	// -- [descripcion] ------------------------

	@Size(max = 50, message = "{message.tipoServicio.descripcion.sizeMax} {max} {message.caracter}")
	@Column(name = "descripcion", length = 50)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoServicio descripcion(String descripcion) {
		setDescripcion(descripcion);
		return this;
	}

	/**
	 * Apply the default values.
	 */
	public TipoServicio withDefaults() {
		return this;
	}

	/**
	 * Equals implementation using a business key.
	 */
	@Override
	public boolean equals(Object other) {
		return this == other || (other instanceof TipoServicio && hashCode() == other.hashCode());
	}

	private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

	@Override
	public int hashCode() {
		return identifiableHashBuilder.hash(log, this);
	}

	/**
	 * Construct a readable string representation for this TipoServicio instance.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this) //
				.add("id", getId()) //
				.add("codigoIsis", getCodigoIsis()) //
				.add("descripcion", getDescripcion()) //
				.toString();
	}
}
