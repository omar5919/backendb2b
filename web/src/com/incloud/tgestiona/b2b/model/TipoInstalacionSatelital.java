package com.incloud.tgestiona.b2b.model;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "tipo_instalacion_satelital")
//@Audited
//@AuditTable("_audi_tipo_instalacion_satelital")
public class TipoInstalacionSatelital extends BaseDomain implements Identifiable<Integer>, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(TipoInstalacionSatelital.class.getName());

	/***************************/
	/* Atributos de la Entidad */
	/***************************/

	// Raw attributes
	private Integer id;
	private Integer tipoSatelital;
	private BigDecimal montoSoles;
	private BigDecimal montoDolares;
	private String descripcion;

	@Override
	public String entityClassName() {
		return TipoInstalacionSatelital.class.getSimpleName();
	}

	// -- [id] ------------------------

	@Override
	@Column(name = "tipo_instalacion_satelital_id", precision = 10)
	@GeneratedValue(strategy = SEQUENCE, generator = "seq_tipo_instalacion_satelital")
	@Id
	@SequenceGenerator(name = "seq_tipo_instalacion_satelital", sequenceName = "seq_tipo_instalacion_satelital", allocationSize = 1)
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public TipoInstalacionSatelital id(Integer id) {
		setId(id);
		return this;
	}

	@Override
	@Transient
	public boolean isIdSet() {
		return id != null;
	}
	// -- [tipoSatelital] ------------------------

	@Digits(integer = 10, fraction = 0)
	@Column(name = "tipo_satelital", precision = 10)
	public Integer getTipoSatelital() {
		return tipoSatelital;
	}

	public void setTipoSatelital(Integer tipoSatelital) {
		this.tipoSatelital = tipoSatelital;
	}

	public TipoInstalacionSatelital tipoSatelital(Integer tipoSatelital) {
		setTipoSatelital(tipoSatelital);
		return this;
	}
	// -- [montoSoles] ------------------------

	@Digits(integer = 13, fraction = 5)
	@Column(name = "monto_soles", precision = 18, scale = 5)
	public BigDecimal getMontoSoles() {
		return montoSoles;
	}

	public void setMontoSoles(BigDecimal montoSoles) {
		this.montoSoles = montoSoles;
	}

	public TipoInstalacionSatelital montoSoles(BigDecimal montoSoles) {
		setMontoSoles(montoSoles);
		return this;
	}
	// -- [montoDolares] ------------------------

	@Digits(integer = 13, fraction = 5)
	@Column(name = "monto_dolares", precision = 18, scale = 5)
	public BigDecimal getMontoDolares() {
		return montoDolares;
	}

	public void setMontoDolares(BigDecimal montoDolares) {
		this.montoDolares = montoDolares;
	}

	public TipoInstalacionSatelital montoDolares(BigDecimal montoDolares) {
		setMontoDolares(montoDolares);
		return this;
	}
	// -- [descripcion] ------------------------

	@Size(max = 50, message = "{message.tipoInstalacionSatelital.descripcion.sizeMax} {max} {message.caracter}")
	@Column(name = "descripcion", length = 50)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoInstalacionSatelital descripcion(String descripcion) {
		setDescripcion(descripcion);
		return this;
	}

	/**
	 * Apply the default values.
	 */
	public TipoInstalacionSatelital withDefaults() {
		return this;
	}

	/**
	 * Equals implementation using a business key.
	 */
	@Override
	public boolean equals(Object other) {
		return this == other || (other instanceof TipoInstalacionSatelital && hashCode() == other.hashCode());
	}

	private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

	@Override
	public int hashCode() {
		return identifiableHashBuilder.hash(log, this);
	}

	/**
	 * Construct a readable string representation for this TipoInstalacionSatelital
	 * instance.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this) //
				.add("id", getId()) //
				.add("tipoSatelital", getTipoSatelital()) //
				.add("montoSoles", getMontoSoles()) //
				.add("montoDolares", getMontoDolares()) //
				.add("descripcion", getDescripcion()) //
				.toString();
	}
}
