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
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import com.google.common.base.MoreObjects;
import com.incloud.tgestiona.domain.BaseDomain;

@Entity
@Table(name = "accion_isis",schema="oferta")
//@Audited
//@AuditTable("_audi_accion_isis")
public class AccionIsis extends BaseDomain implements Identifiable<Integer>, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(AccionIsis.class.getName());

	/***************************/
	/* Atributos de la Entidad */
	/***************************/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "accion_isis_id", updatable = false, nullable = false)
	private Integer id;

	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "codigo_isis")
	private String codigoIsis;
	
	@Column(name = "activo")
	private Boolean activo;
	
 

	public String getCodigoIsis() {
		return codigoIsis;
	}

	public void setCodigoIsis(String codigoIsis) {
		this.codigoIsis = codigoIsis;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}


	@Override
	public String entityClassName() {
		return AccionIsis.class.getSimpleName();
	}

	// -- [id] ------------------------

	/*@Override
	@Column(name = "accion_isis_id", precision = 10)
	@GeneratedValue(strategy = SEQUENCE, generator = "seq_accion_isis")
	@Id
	@SequenceGenerator(name = "seq_accion_isis", sequenceName = "seq_accion_isis", allocationSize = 1)
	*/
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public AccionIsis id(Integer id) {
		setId(id);
		return this;
	}

	@Override
	@Transient
	public boolean isIdSet() {
		return id != null;
	}

	// -- [descripcion] ------------------------

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public AccionIsis descripcion(String descripcion) {
		setDescripcion(descripcion);
		return this;
	}

	/**
	 * Apply the default values.
	 */
	public AccionIsis withDefaults() {
		return this;
	}

	/**
	 * Equals implementation using a business key.
	 */
	@Override
	public boolean equals(Object other) {
		return this == other || (other instanceof AccionIsis && hashCode() == other.hashCode());
	}

	private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

	@Override
	public int hashCode() {
		return identifiableHashBuilder.hash(log, this);
	}

	/**
	 * Construct a readable string representation for this AccionIsis instance.
	 * 
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
