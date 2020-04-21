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

import com.google.common.base.MoreObjects;
import com.incloud.tgestiona.domain.BaseDomain;
import com.sun.istack.NotNull;

@Entity
@Table(name = "vinculo_detalles_oferta")
//@Audited
//@AuditTable("_audi_vinculo_detalles_oferta")
public class VinculoDetallesOferta extends BaseDomain implements Identifiable<Integer>, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(VinculoDetallesOferta.class.getName());

	/***************************/
	/* Atributos de la Entidad */
	/***************************/

	// Raw attributes
	private Integer id;
	private Integer detalleofertaVinculado;

	@Override
	public String entityClassName() {
		return VinculoDetallesOferta.class.getSimpleName();
	}

	// -- [id] ------------------------

	@Override
	@Column(name = "ofertadetalle_principal", precision = 10)
	@GeneratedValue(strategy = SEQUENCE, generator = "seq_vinculo_detalles_oferta")
	@Id
	@SequenceGenerator(name = "seq_vinculo_detalles_oferta", sequenceName = "seq_vinculo_detalles_oferta", allocationSize = 1)
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public VinculoDetallesOferta id(Integer id) {
		setId(id);
		return this;
	}

	@Override
	@Transient
	public boolean isIdSet() {
		return id != null;
	}
	// -- [detalleofertaVinculado] ------------------------

	@Digits(integer = 10, fraction = 0)
	@NotNull
	@Column(name = "detalleoferta_vinculado", nullable = false, precision = 10)
	public Integer getDetalleofertaVinculado() {
		return detalleofertaVinculado;
	}

	public void setDetalleofertaVinculado(Integer detalleofertaVinculado) {
		this.detalleofertaVinculado = detalleofertaVinculado;
	}

	public VinculoDetallesOferta detalleofertaVinculado(Integer detalleofertaVinculado) {
		setDetalleofertaVinculado(detalleofertaVinculado);
		return this;
	}

	/**
	 * Apply the default values.
	 */
	public VinculoDetallesOferta withDefaults() {
		return this;
	}

	/**
	 * Equals implementation using a business key.
	 */
	@Override
	public boolean equals(Object other) {
		return this == other || (other instanceof VinculoDetallesOferta && hashCode() == other.hashCode());
	}

	private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

	@Override
	public int hashCode() {
		return identifiableHashBuilder.hash(log, this);
	}

	/**
	 * Construct a readable string representation for this VinculoDetallesOferta
	 * instance.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this) //
				.add("id", getId()) //
				.add("detalleofertaVinculado", getDetalleofertaVinculado()) //
				.toString();
	}
}
