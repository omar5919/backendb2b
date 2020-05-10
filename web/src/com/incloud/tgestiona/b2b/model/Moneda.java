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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.google.common.base.MoreObjects;
import com.incloud.tgestiona.domain.BaseDomain;

@Entity
@Table(name = "moneda",schema = "oferta")
//@Audited
//@AuditTable("_audi_moneda")
public class Moneda extends BaseDomain implements Identifiable<Integer>, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(Moneda.class.getName());

	/***************************/
	/* Atributos de la Entidad */
	/***************************/

	// Raw attributes
	private Integer id;
	private String descBrv;
	private String monedaDescrip;
	private String sigla;
	private Boolean activo;
	
	@Override
	public String entityClassName() {
		return Moneda.class.getSimpleName();
	}

	// -- [id] ------------------------

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "moneda_id", updatable = false, nullable = false)
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Moneda id(Integer id) {
		setId(id);
		return this;
	}

	@Override
	@Transient
	public boolean isIdSet() {
		return id != null;
	}
	// -- [descBrv] ------------------------

	@NotEmpty(message = "{message.moneda.descBrv.requerido}")
	@Size(max = 4, message = "{message.moneda.descBrv.sizeMax} {max} {message.caracter}")
	@Column(name = "simbolo", nullable = false, length = 4)
	public String getDescBrv() {
		return descBrv;
	}

	public void setDescBrv(String descBrv) {
		this.descBrv = descBrv;
	}

	public Moneda descBrv(String descBrv) {
		setDescBrv(descBrv);
		return this;
	}
	// -- [monedaDescrip] ------------------------

	@NotEmpty(message = "{message.moneda.monedaDescrip.requerido}")
	@Size(max = 10, message = "{message.moneda.monedaDescrip.sizeMax} {max} {message.caracter}")
	@Column(name = "nombre", nullable = false, length = 10)
	public String getMonedaDescrip() {
		return monedaDescrip;
	}

	public void setMonedaDescrip(String monedaDescrip) {
		this.monedaDescrip = monedaDescrip;
	}

	public Moneda monedaDescrip(String monedaDescrip) {
		setMonedaDescrip(monedaDescrip);
		return this;
	}
	// -- [sigla] ------------------------

	@NotEmpty(message = "{message.moneda.sigla.requerido}")
	@Size(max = 10, message = "{message.moneda.sigla.sizeMax} {max} {message.caracter}")
	@Column(name = "sigla", nullable = false, length = 10)
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Moneda sigla(String sigla) {
		setSigla(sigla);
		return this;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	/**
	 * Apply the default values.
	 */
	public Moneda withDefaults() {
		return this;
	}

	/**
	 * Equals implementation using a business key.
	 */
	@Override
	public boolean equals(Object other) {
		return this == other || (other instanceof Moneda && hashCode() == other.hashCode());
	}

	private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

	@Override
	public int hashCode() {
		return identifiableHashBuilder.hash(log, this);
	}

	/**
	 * Construct a readable string representation for this Moneda instance.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this) //
				.add("id", getId()) //
				.add("descBrv", getDescBrv()) //
				.add("monedaDescrip", getMonedaDescrip()) //
				.add("sigla", getSigla()) //
				.toString();
	}
}
