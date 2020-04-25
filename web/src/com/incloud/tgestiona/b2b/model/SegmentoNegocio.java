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
import com.sun.istack.NotNull;

@Entity
@Table(name = "segmento_negocio")
//@Audited
//@AuditTable("_audi_segmento_negocio")
public class SegmentoNegocio extends BaseDomain implements Identifiable<Integer>, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(SegmentoNegocio.class.getName());

	/***************************/
	/* Atributos de la Entidad */
	/***************************/

	// Raw attributes
	private Integer id;
	private Integer empresaId;
	private String descripcion;

	@Override
	public String entityClassName() {
		return SegmentoNegocio.class.getSimpleName();
	}

	// -- [id] ------------------------

	@Override
	@Column(name = "segmento_negocio_id", precision = 10)
	@GeneratedValue(strategy = SEQUENCE, generator = "seq_segmento_negocio")
	@Id
	@SequenceGenerator(name = "seq_segmento_negocio", sequenceName = "seq_segmento_negocio", allocationSize = 1)
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public SegmentoNegocio id(Integer id) {
		setId(id);
		return this;
	}

	@Override
	@Transient
	public boolean isIdSet() {
		return id != null;
	}
	// -- [empresaId] ------------------------

	@Digits(integer = 10, fraction = 0)
	@NotNull
	@Column(name = "empresa_id", nullable = false, precision = 10)
	public Integer getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Integer empresaId) {
		this.empresaId = empresaId;
	}

	public SegmentoNegocio empresaId(Integer empresaId) {
		setEmpresaId(empresaId);
		return this;
	}
	// -- [descripcion] ------------------------

	@Size(max = 60, message = "{message.segmentoNegocio.descripcion.sizeMax} {max} {message.caracter}")
	@Column(name = "descripcion", length = 60)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public SegmentoNegocio descripcion(String descripcion) {
		setDescripcion(descripcion);
		return this;
	}

	/**
	 * Apply the default values.
	 */
	public SegmentoNegocio withDefaults() {
		return this;
	}

	/**
	 * Equals implementation using a business key.
	 */
	@Override
	public boolean equals(Object other) {
		return this == other || (other instanceof SegmentoNegocio && hashCode() == other.hashCode());
	}

	private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

	@Override
	public int hashCode() {
		return identifiableHashBuilder.hash(log, this);
	}

	/**
	 * Construct a readable string representation for this SegmentoNegocio instance.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this) //
				.add("id", getId()) //
				.add("empresaId", getEmpresaId()) //
				.add("descripcion", getDescripcion()) //
				.toString();
	}
}
