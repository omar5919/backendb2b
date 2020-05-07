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
@Table(name = "accion_isis",schema="oferta")
//@Audited
//@AuditTable("_audi_accion_isis")
public class AccionIsis extends BaseDomain implements Identifiable<Integer>, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(AccionIsis.class.getName());

	/***************************/
	/* Atributos de la Entidad */
	/***************************/

	// Raw attributes
	private Integer id;
	private Integer codigoEquivalente;
	private String descripcion;
	private String codigoIsis;
	private Boolean activo;
	private String codTablTipo;
	
 

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

	public String getCodTablTipo() {
		return codTablTipo;
	}

	public void setCodTablTipo(String codTablTipo) {
		this.codTablTipo = codTablTipo;
	}

	@Override
	public String entityClassName() {
		return AccionIsis.class.getSimpleName();
	}

	// -- [id] ------------------------

	@Override
	@Column(name = "accion_isis_id", precision = 10)
	@GeneratedValue(strategy = SEQUENCE, generator = "seq_accion_isis")
	@Id
	@SequenceGenerator(name = "seq_accion_isis", sequenceName = "seq_accion_isis", allocationSize = 1)
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
	// -- [codigoEquivalente] ------------------------

	@Digits(integer = 10, fraction = 0)
	@Column(name = "codigo_equivalente", precision = 10)
	public Integer getCodigoEquivalente() {
		return codigoEquivalente;
	}

	public void setCodigoEquivalente(Integer codigoEquivalente) {
		this.codigoEquivalente = codigoEquivalente;
	}

	public AccionIsis codigoEquivalente(Integer codigoEquivalente) {
		setCodigoEquivalente(codigoEquivalente);
		return this;
	}
	// -- [descripcion] ------------------------

	@Size(max = 200, message = "{message.accionIsis.descripcion.sizeMax} {max} {message.caracter}")
	@Column(name = "descripcion", length = 200)
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
				.add("codigoEquivalente", getCodigoEquivalente()) //
				.add("descripcion", getDescripcion()) //
				.toString();
	}
}
