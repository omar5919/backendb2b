package com.incloud.tgestiona.b2b.model;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;

import com.google.common.base.MoreObjects;
import com.incloud.tgestiona.domain.BaseDomain;
import com.sun.istack.NotNull;

@Entity
@Table(name = "circuito")
//@Audited
//@AuditTable("_audi_circuito")
public class Circuito extends BaseDomain implements Identifiable<Integer>, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(Circuito.class.getName());

	/***************************/
	/* Atributos de la Entidad */
	/***************************/

	// Raw attributes
	private Integer id;
	private Integer proyectoId;
	private Integer clienteId;
	private Integer servicioActualId;
	private Integer servicioPropuestoId;
	private Boolean valdiadoFF;
	private Boolean enviado;

	// Many to one
	private Sisego sisego;

	@Override
	public String entityClassName() {
		return Circuito.class.getSimpleName();
	}

	// -- [id] ------------------------

	@Override
	@Column(name = "circuito_id", precision = 10)
	@GeneratedValue(strategy = SEQUENCE, generator = "seq_circuito")
	@Id
	@SequenceGenerator(name = "seq_circuito", sequenceName = "seq_circuito", allocationSize = 1)
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Circuito id(Integer id) {
		setId(id);
		return this;
	}

	@Override
	@Transient
	public boolean isIdSet() {
		return id != null;
	}
	// -- [proyectoId] ------------------------

	@Digits(integer = 10, fraction = 0)
	@NotNull
	@Column(name = "proyecto_id", nullable = false, precision = 10)
	public Integer getProyectoId() {
		return proyectoId;
	}

	public void setProyectoId(Integer proyectoId) {
		this.proyectoId = proyectoId;
	}

	public Circuito proyectoId(Integer proyectoId) {
		setProyectoId(proyectoId);
		return this;
	}
	// -- [clienteId] ------------------------

	@Digits(integer = 10, fraction = 0)
	@NotNull
	@Column(name = "cliente_id", nullable = false, precision = 10)
	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public Circuito clienteId(Integer clienteId) {
		setClienteId(clienteId);
		return this;
	}
	// -- [servicioActualId] ------------------------

	@Digits(integer = 10, fraction = 0)
	@NotNull
	@Column(name = "servicio_actual_id", nullable = false, precision = 10)
	public Integer getServicioActualId() {
		return servicioActualId;
	}

	public void setServicioActualId(Integer servicioActualId) {
		this.servicioActualId = servicioActualId;
	}

	public Circuito servicioActualId(Integer servicioActualId) {
		setServicioActualId(servicioActualId);
		return this;
	}
	// -- [servicioPropuestoId] ------------------------

	@Digits(integer = 10, fraction = 0)
	@NotNull
	@Column(name = "servicio_propuesto_id", nullable = false, precision = 10)
	public Integer getServicioPropuestoId() {
		return servicioPropuestoId;
	}

	public void setServicioPropuestoId(Integer servicioPropuestoId) {
		this.servicioPropuestoId = servicioPropuestoId;
	}

	public Circuito servicioPropuestoId(Integer servicioPropuestoId) {
		setServicioPropuestoId(servicioPropuestoId);
		return this;
	}
	// -- [valdiadoFF] ------------------------

	@NotNull
	@Column(name = "valdiadoFF", nullable = false, length = 1)
	public Boolean getValdiadoFF() {
		return valdiadoFF;
	}

	public void setValdiadoFF(Boolean valdiadoFF) {
		this.valdiadoFF = valdiadoFF;
	}

	public Circuito valdiadoFF(Boolean valdiadoFF) {
		setValdiadoFF(valdiadoFF);
		return this;
	}
	// -- [enviado] ------------------------

	@NotNull
	@Column(name = "enviado", nullable = false, length = 1)
	public Boolean getEnviado() {
		return enviado;
	}

	public void setEnviado(Boolean enviado) {
		this.enviado = enviado;
	}

	public Circuito enviado(Boolean enviado) {
		setEnviado(enviado);
		return this;
	}

	// -----------------------------------------------------------------
	// Many to One support
	// -----------------------------------------------------------------

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// many-to-one: Circuito.sisego ==> Sisego.id
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	@NotNull
	@JoinColumn(name = "sisego_id", nullable = false)
	@ManyToOne
	public Sisego getSisego() {
		return sisego;
	}

	/**
	 * Set the {@link #sisego} without adding this Circuito instance on the passed
	 * {@link #sisego}
	 */
	public void setSisego(Sisego sisego) {
		this.sisego = sisego;
	}

	public Circuito sisego(Sisego sisego) {
		setSisego(sisego);
		return this;
	}

	/**
	 * Apply the default values.
	 */
	public Circuito withDefaults() {
		return this;
	}

	/**
	 * Equals implementation using a business key.
	 */
	@Override
	public boolean equals(Object other) {
		return this == other || (other instanceof Circuito && hashCode() == other.hashCode());
	}

	private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

	@Override
	public int hashCode() {
		return identifiableHashBuilder.hash(log, this);
	}

	/**
	 * Construct a readable string representation for this Circuito instance.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this) //
				.add("id", getId()) //
				.add("proyectoId", getProyectoId()) //
				.add("clienteId", getClienteId()) //
				.add("servicioActualId", getServicioActualId()) //
				.add("servicioPropuestoId", getServicioPropuestoId()) //
				.add("sisego", getSisego()) //
				.add("valdiadoFF", getValdiadoFF()) //
				.add("enviado", getEnviado()) //
				.toString();
	}
}
