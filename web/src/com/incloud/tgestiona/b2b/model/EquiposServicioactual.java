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
import com.sun.istack.NotNull;

@Entity
@Table(name = "equipos_servicioactual")
//@Audited
//@AuditTable("_audi_equipos_servicioactual")
public class EquiposServicioactual extends BaseDomain implements Identifiable<Integer>, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(EquiposServicioactual.class.getName());

	/***************************/
	/* Atributos de la Entidad */
	/***************************/

	// Raw attributes
	private Integer id;
	private Integer monedaId;
	private Integer ofertasDetalleId;
	private Integer categoriaEquipoId;
	private Integer condicionEquipoId;
	private Integer tipoEquipoId;
	private Integer tipoImputacionId;
	private Integer renovacionId;
	private Integer antiguedad;
	private String marca;
	private String modelo;
	private BigDecimal costo;

	@Override
	public String entityClassName() {
		return EquiposServicioactual.class.getSimpleName();
	}

	// -- [id] ------------------------

	@Override
	@Column(name = "equipos_servicioactual_id", precision = 10)
	@GeneratedValue(strategy = SEQUENCE, generator = "seq_equipos_servicioactual")
	@Id
	@SequenceGenerator(name = "seq_equipos_servicioactual", sequenceName = "seq_equipos_servicioactual", allocationSize = 1)
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public EquiposServicioactual id(Integer id) {
		setId(id);
		return this;
	}

	@Override
	@Transient
	public boolean isIdSet() {
		return id != null;
	}
	// -- [monedaId] ------------------------

	@Digits(integer = 10, fraction = 0)
	@NotNull
	@Column(name = "moneda_id", nullable = false, precision = 10)
	public Integer getMonedaId() {
		return monedaId;
	}

	public void setMonedaId(Integer monedaId) {
		this.monedaId = monedaId;
	}

	public EquiposServicioactual monedaId(Integer monedaId) {
		setMonedaId(monedaId);
		return this;
	}
	// -- [ofertasDetalleId] ------------------------

	@Digits(integer = 10, fraction = 0)
	@NotNull
	@Column(name = "ofertas_detalle_id", nullable = false, precision = 10)
	public Integer getOfertasDetalleId() {
		return ofertasDetalleId;
	}

	public void setOfertasDetalleId(Integer ofertasDetalleId) {
		this.ofertasDetalleId = ofertasDetalleId;
	}

	public EquiposServicioactual ofertasDetalleId(Integer ofertasDetalleId) {
		setOfertasDetalleId(ofertasDetalleId);
		return this;
	}
	// -- [categoriaEquipoId] ------------------------

	@Digits(integer = 10, fraction = 0)
	@NotNull
	@Column(name = "categoria_equipo_id", nullable = false, precision = 10)
	public Integer getCategoriaEquipoId() {
		return categoriaEquipoId;
	}

	public void setCategoriaEquipoId(Integer categoriaEquipoId) {
		this.categoriaEquipoId = categoriaEquipoId;
	}

	public EquiposServicioactual categoriaEquipoId(Integer categoriaEquipoId) {
		setCategoriaEquipoId(categoriaEquipoId);
		return this;
	}
	// -- [condicionEquipoId] ------------------------

	@Digits(integer = 10, fraction = 0)
	@Column(name = "condicion_equipo_id", precision = 10)
	public Integer getCondicionEquipoId() {
		return condicionEquipoId;
	}

	public void setCondicionEquipoId(Integer condicionEquipoId) {
		this.condicionEquipoId = condicionEquipoId;
	}

	public EquiposServicioactual condicionEquipoId(Integer condicionEquipoId) {
		setCondicionEquipoId(condicionEquipoId);
		return this;
	}
	// -- [tipoEquipoId] ------------------------

	@Digits(integer = 10, fraction = 0)
	@Column(name = "tipo_equipo_id", precision = 10)
	public Integer getTipoEquipoId() {
		return tipoEquipoId;
	}

	public void setTipoEquipoId(Integer tipoEquipoId) {
		this.tipoEquipoId = tipoEquipoId;
	}

	public EquiposServicioactual tipoEquipoId(Integer tipoEquipoId) {
		setTipoEquipoId(tipoEquipoId);
		return this;
	}
	// -- [tipoImputacionId] ------------------------

	@Digits(integer = 10, fraction = 0)
	@Column(name = "tipo_imputacion_id", precision = 10)
	public Integer getTipoImputacionId() {
		return tipoImputacionId;
	}

	public void setTipoImputacionId(Integer tipoImputacionId) {
		this.tipoImputacionId = tipoImputacionId;
	}

	public EquiposServicioactual tipoImputacionId(Integer tipoImputacionId) {
		setTipoImputacionId(tipoImputacionId);
		return this;
	}
	// -- [renovacionId] ------------------------

	@Digits(integer = 10, fraction = 0)
	@Column(name = "renovacion_id", precision = 10)
	public Integer getRenovacionId() {
		return renovacionId;
	}

	public void setRenovacionId(Integer renovacionId) {
		this.renovacionId = renovacionId;
	}

	public EquiposServicioactual renovacionId(Integer renovacionId) {
		setRenovacionId(renovacionId);
		return this;
	}
	// -- [antiguedad] ------------------------

	@Digits(integer = 5, fraction = 0)
	@Column(name = "antiguedad", precision = 5)
	public Integer getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	}

	public EquiposServicioactual antiguedad(Integer antiguedad) {
		setAntiguedad(antiguedad);
		return this;
	}
	// -- [marca] ------------------------

	@Size(max = 100, message = "{message.equiposServicioactual.marca.sizeMax} {max} {message.caracter}")
	@Column(name = "marca", length = 100)
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public EquiposServicioactual marca(String marca) {
		setMarca(marca);
		return this;
	}
	// -- [modelo] ------------------------

	@Size(max = 100, message = "{message.equiposServicioactual.modelo.sizeMax} {max} {message.caracter}")
	@Column(name = "modelo", length = 100)
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public EquiposServicioactual modelo(String modelo) {
		setModelo(modelo);
		return this;
	}
	// -- [costo] ------------------------

	@Digits(integer = 13, fraction = 5)
	@Column(name = "costo", precision = 18, scale = 5)
	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public EquiposServicioactual costo(BigDecimal costo) {
		setCosto(costo);
		return this;
	}

	/**
	 * Apply the default values.
	 */
	public EquiposServicioactual withDefaults() {
		return this;
	}

	/**
	 * Equals implementation using a business key.
	 */
	@Override
	public boolean equals(Object other) {
		return this == other || (other instanceof EquiposServicioactual && hashCode() == other.hashCode());
	}

	private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

	@Override
	public int hashCode() {
		return identifiableHashBuilder.hash(log, this);
	}

	/**
	 * Construct a readable string representation for this EquiposServicioactual
	 * instance.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this) //
				.add("id", getId()) //
				.add("monedaId", getMonedaId()) //
				.add("ofertasDetalleId", getOfertasDetalleId()) //
				.add("categoriaEquipoId", getCategoriaEquipoId()) //
				.add("condicionEquipoId", getCondicionEquipoId()) //
				.add("tipoEquipoId", getTipoEquipoId()) //
				.add("tipoImputacionId", getTipoImputacionId()) //
				.add("renovacionId", getRenovacionId()) //
				.add("antiguedad", getAntiguedad()) //
				.add("marca", getMarca()) //
				.add("modelo", getModelo()) //
				.add("costo", getCosto()) //
				.toString();
	}
}
