
package com.incloud.tgestiona.b2b.model.isis;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.google.common.base.MoreObjects;
import com.incloud.tgestiona.b2b.model.Identifiable;
import com.incloud.tgestiona.b2b.model.IdentifiableHashBuilder;
import com.incloud.tgestiona.domain.BaseDomain;

@Entity
@Table(name = "acceso", schema = "isis")
//@Audited
//@AuditTable("_audi_acceso")
public class Acceso extends BaseDomain implements Identifiable<Integer>, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(Acceso.class.getName());

	/***************************/
	/* Atributos de la Entidad */
	/***************************/

	// Raw attributes
	private Integer id;
	private Boolean activo;
	private String codigoIsis;
	private Integer tipoServicioId;
	private Double velocidad;

	@Override
	public String entityClassName() {
		return Acceso.class.getSimpleName();
	}

	// -- [id] ------------------------

	@Override
	@Column(name = "acceso_id", precision = 10)
	@GeneratedValue(strategy = SEQUENCE, generator = "seq_acceso")
	@Id
	@SequenceGenerator(name = "seq_acceso", sequenceName = "seq_acceso", allocationSize = 1)
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Acceso id(Integer id) {
		setId(id);
		return this;
	}

	@Override
	@Transient
	public boolean isIdSet() {
		return id != null;
	}
	// -- [activo] ------------------------

	@Column(name = "activo", length = 1)
	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Acceso activo(Boolean activo) {
		setActivo(activo);
		return this;
	}
	// -- [codigoIsis] ------------------------

	@Size(max = 255, message = "{message.acceso.codigoIsis.sizeMax} {max} {message.caracter}")
	@Column(name = "codigo_isis")
	public String getCodigoIsis() {
		return codigoIsis;
	}

	public void setCodigoIsis(String codigoIsis) {
		this.codigoIsis = codigoIsis;
	}

	public Acceso codigoIsis(String codigoIsis) {
		setCodigoIsis(codigoIsis);
		return this;
	}
	// -- [tipoServicioId] ------------------------

	@Digits(integer = 10, fraction = 0)
	@NotNull
	@Column(name = "tipo_servicio_id", nullable = false, precision = 10)
	public Integer getTipoServicioId() {
		return tipoServicioId;
	}

	public void setTipoServicioId(Integer tipoServicioId) {
		this.tipoServicioId = tipoServicioId;
	}

	public Acceso tipoServicioId(Integer tipoServicioId) {
		setTipoServicioId(tipoServicioId);
		return this;
	}
	// -- [velocidad] ------------------------

	@Digits(integer = 8, fraction = 4)
	@Column(name = "velocidad", precision = 12, scale = 4)
	public Double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(Double velocidad) {
		this.velocidad = velocidad;
	}

	public Acceso velocidad(Double velocidad) {
		setVelocidad(velocidad);
		return this;
	}

	/**
	 * Apply the default values.
	 */
	public Acceso withDefaults() {
		return this;
	}

	/**
	 * Equals implementation using a business key.
	 */
	@Override
	public boolean equals(Object other) {
		return this == other || (other instanceof Acceso && hashCode() == other.hashCode());
	}

	private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

	@Override
	public int hashCode() {
		return identifiableHashBuilder.hash(log, this);
	}

	/**
	 * Construct a readable string representation for this Acceso instance.
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
				.add("activo", getActivo()) //
				.add("codigoIsis", getCodigoIsis()) //
				.add("tipoServicioId", getTipoServicioId()) //
				.add("velocidad", getVelocidad()) //
				.toString();
	}
}
