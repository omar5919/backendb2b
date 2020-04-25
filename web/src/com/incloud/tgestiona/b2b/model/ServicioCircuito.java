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
@Table(name = "servicio_circuito")
//@Audited
//@AuditTable("_audi_servicio_circuito")
public class ServicioCircuito extends BaseDomain implements Identifiable<Integer>, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ServicioCircuito.class.getName());

	/***************************/
	/* Atributos de la Entidad */
	/***************************/

	// Raw attributes
	private Integer id;
	private String codigoServicio;
	private Integer codigoEquivalente;
	private Integer cantidadEquivalenteff;
	private String desServicio;
	private Integer grupo;
	private Boolean satelital;
	private String codigoIsis;
	private String desIsis;

	@Override
	public String entityClassName() {
		return ServicioCircuito.class.getSimpleName();
	}

	// -- [id] ------------------------

	@Override
	@Column(name = "servicio_id", precision = 10)
	@GeneratedValue(strategy = SEQUENCE, generator = "seq_servicio_circuito")
	@Id
	@SequenceGenerator(name = "seq_servicio_circuito", sequenceName = "seq_servicio_circuito", allocationSize = 1)
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public ServicioCircuito id(Integer id) {
		setId(id);
		return this;
	}

	@Override
	@Transient
	public boolean isIdSet() {
		return id != null;
	}
	// -- [codigoServicio] ------------------------

	@Size(max = 10, message = "{message.servicioCircuito.codigoServicio.sizeMax} {max} {message.caracter}")
	@Column(name = "codigo_servicio", length = 10)
	public String getCodigoServicio() {
		return codigoServicio;
	}

	public void setCodigoServicio(String codigoServicio) {
		this.codigoServicio = codigoServicio;
	}

	public ServicioCircuito codigoServicio(String codigoServicio) {
		setCodigoServicio(codigoServicio);
		return this;
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

	public ServicioCircuito codigoEquivalente(Integer codigoEquivalente) {
		setCodigoEquivalente(codigoEquivalente);
		return this;
	}
	// -- [cantidadEquivalenteff] ------------------------

	@Digits(integer = 10, fraction = 0)
	@Column(name = "cantidad_equivalenteFF", precision = 10)
	public Integer getCantidadEquivalenteff() {
		return cantidadEquivalenteff;
	}

	public void setCantidadEquivalenteff(Integer cantidadEquivalenteff) {
		this.cantidadEquivalenteff = cantidadEquivalenteff;
	}

	public ServicioCircuito cantidadEquivalenteff(Integer cantidadEquivalenteff) {
		setCantidadEquivalenteff(cantidadEquivalenteff);
		return this;
	}
	// -- [desServicio] ------------------------

	@Size(max = 200, message = "{message.servicioCircuito.desServicio.sizeMax} {max} {message.caracter}")
	@Column(name = "des_servicio", length = 200)
	public String getDesServicio() {
		return desServicio;
	}

	public void setDesServicio(String desServicio) {
		this.desServicio = desServicio;
	}

	public ServicioCircuito desServicio(String desServicio) {
		setDesServicio(desServicio);
		return this;
	}
	// -- [grupo] ------------------------

	@Digits(integer = 10, fraction = 0)
	@Column(name = "grupo", precision = 10)
	public Integer getGrupo() {
		return grupo;
	}

	public void setGrupo(Integer grupo) {
		this.grupo = grupo;
	}

	public ServicioCircuito grupo(Integer grupo) {
		setGrupo(grupo);
		return this;
	}
	// -- [satelital] ------------------------

	@Column(name = "satelital", length = 1)
	public Boolean getSatelital() {
		return satelital;
	}

	public void setSatelital(Boolean satelital) {
		this.satelital = satelital;
	}

	public ServicioCircuito satelital(Boolean satelital) {
		setSatelital(satelital);
		return this;
	}
	// -- [codigoIsis] ------------------------

	@Size(max = 5, message = "{message.servicioCircuito.codigoIsis.sizeMax} {max} {message.caracter}")
	@Column(name = "codigo_isis", length = 5)
	public String getCodigoIsis() {
		return codigoIsis;
	}

	public void setCodigoIsis(String codigoIsis) {
		this.codigoIsis = codigoIsis;
	}

	public ServicioCircuito codigoIsis(String codigoIsis) {
		setCodigoIsis(codigoIsis);
		return this;
	}
	// -- [desIsis] ------------------------

	@Size(max = 100, message = "{message.servicioCircuito.desIsis.sizeMax} {max} {message.caracter}")
	@Column(name = "des_isis", length = 100)
	public String getDesIsis() {
		return desIsis;
	}

	public void setDesIsis(String desIsis) {
		this.desIsis = desIsis;
	}

	public ServicioCircuito desIsis(String desIsis) {
		setDesIsis(desIsis);
		return this;
	}

	/**
	 * Apply the default values.
	 */
	public ServicioCircuito withDefaults() {
		return this;
	}

	/**
	 * Equals implementation using a business key.
	 */
	@Override
	public boolean equals(Object other) {
		return this == other || (other instanceof ServicioCircuito && hashCode() == other.hashCode());
	}

	private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

	@Override
	public int hashCode() {
		return identifiableHashBuilder.hash(log, this);
	}

	/**
	 * Construct a readable string representation for this ServicioCircuito
	 * instance.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this) //
				.add("id", getId()) //
				.add("codigoServicio", getCodigoServicio()) //
				.add("codigoEquivalente", getCodigoEquivalente()) //
				.add("cantidadEquivalenteff", getCantidadEquivalenteff()) //
				.add("desServicio", getDesServicio()) //
				.add("grupo", getGrupo()) //
				.add("satelital", getSatelital()) //
				.add("codigoIsis", getCodigoIsis()) //
				.add("desIsis", getDesIsis()) //
				.toString();
	}
}
