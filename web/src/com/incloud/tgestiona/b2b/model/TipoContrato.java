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
@Table(name = "tipo_contrato")
//@Audited
//@AuditTable("_audi_tipo_contrato")
public class TipoContrato extends BaseDomain implements Identifiable<Integer>, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(TipoContrato.class.getName());

	/***************************/
	/* Atributos de la Entidad */
	/***************************/

	// Raw attributes
	private Integer id;
	private String periodoContrato;

	@Override
	public String entityClassName() {
		return TipoContrato.class.getSimpleName();
	}

	// -- [id] ------------------------

	@Override
	@Column(name = "tipo_contrato_id", precision = 10)
	@GeneratedValue(strategy = SEQUENCE, generator = "seq_tipo_contrato")
	@Id
	@SequenceGenerator(name = "seq_tipo_contrato", sequenceName = "seq_tipo_contrato", allocationSize = 1)
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public TipoContrato id(Integer id) {
		setId(id);
		return this;
	}

	@Override
	@Transient
	public boolean isIdSet() {
		return id != null;
	}
	// -- [periodoContrato] ------------------------

	@NotEmpty(message = "{message.tipoContrato.periodoContrato.requerido}")
	@Size(max = 15, message = "{message.tipoContrato.periodoContrato.sizeMax} {max} {message.caracter}")
	@Column(name = "periodo_contrato", nullable = false, length = 15)
	public String getPeriodoContrato() {
		return periodoContrato;
	}

	public void setPeriodoContrato(String periodoContrato) {
		this.periodoContrato = periodoContrato;
	}

	public TipoContrato periodoContrato(String periodoContrato) {
		setPeriodoContrato(periodoContrato);
		return this;
	}

	/**
	 * Apply the default values.
	 */
	public TipoContrato withDefaults() {
		return this;
	}

	/**
	 * Equals implementation using a business key.
	 */
	@Override
	public boolean equals(Object other) {
		return this == other || (other instanceof TipoContrato && hashCode() == other.hashCode());
	}

	private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

	@Override
	public int hashCode() {
		return identifiableHashBuilder.hash(log, this);
	}

	/**
	 * Construct a readable string representation for this TipoContrato instance.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this) //
				.add("id", getId()) //
				.add("periodoContrato", getPeriodoContrato()) //
				.toString();
	}
}