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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.google.common.base.MoreObjects;
import com.incloud.tgestiona.domain.BaseDomain;
import com.sun.istack.NotNull;

@Entity
@Table(name = "tipo_circuito")
//@Audited
//@AuditTable("_audi_tipo_circuito")
public class TipoCircuito extends BaseDomain implements Identifiable<Integer>, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(TipoCircuito.class.getName());

	/***************************/
	/* Atributos de la Entidad */
	/***************************/

	// Raw attributes
	private Integer id;
	private Integer jerarquia;
	private String descTipoCd;

	@Override
	public String entityClassName() {
		return TipoCircuito.class.getSimpleName();
	}

	// -- [id] ------------------------

	@Override
	@Column(name = "tipo_circuito_id", precision = 10)
	@GeneratedValue(strategy = SEQUENCE, generator = "seq_tipo_circuito")
	@Id
	@SequenceGenerator(name = "seq_tipo_circuito", sequenceName = "seq_tipo_circuito", allocationSize = 1)
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public TipoCircuito id(Integer id) {
		setId(id);
		return this;
	}

	@Override
	@Transient
	public boolean isIdSet() {
		return id != null;
	}
	// -- [jerarquia] ------------------------

	@Digits(integer = 10, fraction = 0)
	@NotNull
	@Column(name = "jerarquia", nullable = false, precision = 10)
	public Integer getJerarquia() {
		return jerarquia;
	}

	public void setJerarquia(Integer jerarquia) {
		this.jerarquia = jerarquia;
	}

	public TipoCircuito jerarquia(Integer jerarquia) {
		setJerarquia(jerarquia);
		return this;
	}
	// -- [descTipoCd] ------------------------

	@NotEmpty(message = "{message.tipoCircuito.descTipoCd.requerido}")
	@Size(max = 50, message = "{message.tipoCircuito.descTipoCd.sizeMax} {max} {message.caracter}")
	@Column(name = "desc_tipo_cd", nullable = false, length = 50)
	public String getDescTipoCd() {
		return descTipoCd;
	}

	public void setDescTipoCd(String descTipoCd) {
		this.descTipoCd = descTipoCd;
	}

	public TipoCircuito descTipoCd(String descTipoCd) {
		setDescTipoCd(descTipoCd);
		return this;
	}

	/**
	 * Apply the default values.
	 */
	public TipoCircuito withDefaults() {
		return this;
	}

	/**
	 * Equals implementation using a business key.
	 */
	@Override
	public boolean equals(Object other) {
		return this == other || (other instanceof TipoCircuito && hashCode() == other.hashCode());
	}

	private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

	@Override
	public int hashCode() {
		return identifiableHashBuilder.hash(log, this);
	}

	/**
	 * Construct a readable string representation for this TipoCircuito instance.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this) //
				.add("id", getId()) //
				.add("jerarquia", getJerarquia()) //
				.add("descTipoCd", getDescTipoCd()) //
				.toString();
	}
}
