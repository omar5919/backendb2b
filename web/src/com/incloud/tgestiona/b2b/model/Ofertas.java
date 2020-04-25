package com.incloud.tgestiona.b2b.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import com.google.common.base.MoreObjects;
import com.incloud.tgestiona.domain.BaseDomain;
import com.sun.istack.NotNull;

@Entity
@Table(name = "ofertas")
//@Audited
//@AuditTable("_audi_ofertas")
public class Ofertas extends BaseDomain implements Identifiable<Integer>, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(Ofertas.class.getName());

	/***************************/
	/* Atributos de la Entidad */
	/***************************/

	// Raw attributes
	private Integer id;
	private String codigo;
	private Integer version;
	private String oportunidad;
	private String contacto;
	private String telefonoContacto;
	private String correoContacto;
	private String descripcion;
	private Integer periodocontrato;
	private Integer tiempoimplantacion;
	private BigDecimal pagounico;
	private BigDecimal pagorecurrente;
	private BigDecimal pagorecurrenteactual;
	private BigDecimal diferenciaingresos;
	private BigDecimal vanvai;
	private Integer payback;
	private BigDecimal oibda;
	private String resultado;
	private String aprobadores;

	// Many to one
	private TipoServicio tipoServicio;
	private Cliente cliente;
	private TipoProyecto tipoProyecto;
	private Complejidad complejidad;
	private TipoContrato tipoContrato;
	private AnalistaFinaciero analistaFinanciero;
	private SegmentoNegocio segmentoNegocion;
	private Estado estado;
	private Moneda moneda;

	// One to one
	private Oportunidad oportunidad2;

	@Override
	public String entityClassName() {
		return Ofertas.class.getSimpleName();
	}

	// -- [id] ------------------------

	@Override
	@Column(name = "oferta_id", precision = 10)
	@Id
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Ofertas id(Integer id) {
		setId(id);
		return this;
	}

	@Override
	@Transient
	public boolean isIdSet() {
		return id != null;
	}
	// -- [codigo] ------------------------

	@Size(max = 10, message = "{message.ofertas.codigo.sizeMax} {max} {message.caracter}")
	@Column(name = "codigo", length = 10)
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Ofertas codigo(String codigo) {
		setCodigo(codigo);
		return this;
	}
	// -- [version] ------------------------

	@Column(name = "version", precision = 10)
	@Version
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Ofertas version(Integer version) {
		setVersion(version);
		return this;
	}
	// -- [oportunidad] ------------------------

	@Size(max = 15, message = "{message.ofertas.oportunidad.sizeMax} {max} {message.caracter}")
	@Column(name = "oportunidad", length = 15)
	public String getOportunidad() {
		return oportunidad;
	}

	public void setOportunidad(String oportunidad) {
		this.oportunidad = oportunidad;
	}

	public Ofertas oportunidad(String oportunidad) {
		setOportunidad(oportunidad);
		return this;
	}
	// -- [contacto] ------------------------

	@Size(max = 100, message = "{message.ofertas.contacto.sizeMax} {max} {message.caracter}")
	@Column(name = "contacto", length = 100)
	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public Ofertas contacto(String contacto) {
		setContacto(contacto);
		return this;
	}
	// -- [telefonoContacto] ------------------------

	@Size(max = 15, message = "{message.ofertas.telefonoContacto.sizeMax} {max} {message.caracter}")
	@Column(name = "telefono_contacto", length = 15)
	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public Ofertas telefonoContacto(String telefonoContacto) {
		setTelefonoContacto(telefonoContacto);
		return this;
	}
	// -- [correoContacto] ------------------------

	@Size(max = 35, message = "{message.ofertas.correoContacto.sizeMax} {max} {message.caracter}")
	@Column(name = "correo_contacto", length = 35)
	public String getCorreoContacto() {
		return correoContacto;
	}

	public void setCorreoContacto(String correoContacto) {
		this.correoContacto = correoContacto;
	}

	public Ofertas correoContacto(String correoContacto) {
		setCorreoContacto(correoContacto);
		return this;
	}
	// -- [descripcion] ------------------------

	@Size(max = 500, message = "{message.ofertas.descripcion.sizeMax} {max} {message.caracter}")
	@Column(name = "descripcion", length = 500)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Ofertas descripcion(String descripcion) {
		setDescripcion(descripcion);
		return this;
	}
	// -- [periodocontrato] ------------------------

	@Digits(integer = 10, fraction = 0)
	@Column(name = "periodocontrato", precision = 10)
	public Integer getPeriodocontrato() {
		return periodocontrato;
	}

	public void setPeriodocontrato(Integer periodocontrato) {
		this.periodocontrato = periodocontrato;
	}

	public Ofertas periodocontrato(Integer periodocontrato) {
		setPeriodocontrato(periodocontrato);
		return this;
	}
	// -- [tiempoimplantacion] ------------------------

	@Digits(integer = 10, fraction = 0)
	@Column(name = "tiempoimplantacion", precision = 10)
	public Integer getTiempoimplantacion() {
		return tiempoimplantacion;
	}

	public void setTiempoimplantacion(Integer tiempoimplantacion) {
		this.tiempoimplantacion = tiempoimplantacion;
	}

	public Ofertas tiempoimplantacion(Integer tiempoimplantacion) {
		setTiempoimplantacion(tiempoimplantacion);
		return this;
	}
	// -- [pagounico] ------------------------

	@Digits(integer = 8, fraction = 4)
	@Column(name = "pagounico", precision = 12, scale = 4)
	public BigDecimal getPagounico() {
		return pagounico;
	}

	public void setPagounico(BigDecimal pagounico) {
		this.pagounico = pagounico;
	}

	public Ofertas pagounico(BigDecimal pagounico) {
		setPagounico(pagounico);
		return this;
	}
	// -- [pagorecurrente] ------------------------

	@Digits(integer = 8, fraction = 4)
	@Column(name = "pagorecurrente", precision = 12, scale = 4)
	public BigDecimal getPagorecurrente() {
		return pagorecurrente;
	}

	public void setPagorecurrente(BigDecimal pagorecurrente) {
		this.pagorecurrente = pagorecurrente;
	}

	public Ofertas pagorecurrente(BigDecimal pagorecurrente) {
		setPagorecurrente(pagorecurrente);
		return this;
	}
	// -- [pagorecurrenteactual] ------------------------

	@Digits(integer = 8, fraction = 4)
	@Column(name = "pagorecurrenteactual", precision = 12, scale = 4)
	public BigDecimal getPagorecurrenteactual() {
		return pagorecurrenteactual;
	}

	public void setPagorecurrenteactual(BigDecimal pagorecurrenteactual) {
		this.pagorecurrenteactual = pagorecurrenteactual;
	}

	public Ofertas pagorecurrenteactual(BigDecimal pagorecurrenteactual) {
		setPagorecurrenteactual(pagorecurrenteactual);
		return this;
	}
	// -- [diferenciaingresos] ------------------------

	@Digits(integer = 8, fraction = 4)
	@Column(name = "diferenciaingresos", precision = 12, scale = 4)
	public BigDecimal getDiferenciaingresos() {
		return diferenciaingresos;
	}

	public void setDiferenciaingresos(BigDecimal diferenciaingresos) {
		this.diferenciaingresos = diferenciaingresos;
	}

	public Ofertas diferenciaingresos(BigDecimal diferenciaingresos) {
		setDiferenciaingresos(diferenciaingresos);
		return this;
	}
	// -- [vanvai] ------------------------

	@Digits(integer = 8, fraction = 4)
	@Column(name = "vanvai", precision = 12, scale = 4)
	public BigDecimal getVanvai() {
		return vanvai;
	}

	public void setVanvai(BigDecimal vanvai) {
		this.vanvai = vanvai;
	}

	public Ofertas vanvai(BigDecimal vanvai) {
		setVanvai(vanvai);
		return this;
	}
	// -- [payback] ------------------------

	@Digits(integer = 10, fraction = 0)
	@Column(name = "payback", precision = 10)
	public Integer getPayback() {
		return payback;
	}

	public void setPayback(Integer payback) {
		this.payback = payback;
	}

	public Ofertas payback(Integer payback) {
		setPayback(payback);
		return this;
	}
	// -- [oibda] ------------------------

	@Digits(integer = 8, fraction = 4)
	@Column(name = "oibda", precision = 12, scale = 4)
	public BigDecimal getOibda() {
		return oibda;
	}

	public void setOibda(BigDecimal oibda) {
		this.oibda = oibda;
	}

	public Ofertas oibda(BigDecimal oibda) {
		setOibda(oibda);
		return this;
	}
	// -- [resultado] ------------------------

	@Size(max = 1, message = "{message.ofertas.resultado.sizeMax} {max} {message.caracter}")
	@Column(name = "resultado", length = 1)
	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Ofertas resultado(String resultado) {
		setResultado(resultado);
		return this;
	}
	// -- [aprobadores] ------------------------

	@Size(max = 100, message = "{message.ofertas.aprobadores.sizeMax} {max} {message.caracter}")
	@Column(name = "aprobadores", length = 100)
	public String getAprobadores() {
		return aprobadores;
	}

	public void setAprobadores(String aprobadores) {
		this.aprobadores = aprobadores;
	}

	public Ofertas aprobadores(String aprobadores) {
		setAprobadores(aprobadores);
		return this;
	}

	// -----------------------------------------------------------------
	// Many to One support
	// -----------------------------------------------------------------

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// many-to-one: Ofertas.tipoServicio ==> TipoServicio.id
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	@JoinColumn(name = "tipo_servicio_id")
	@ManyToOne
	public TipoServicio getTipoServicio() {
		return tipoServicio;
	}

	/**
	 * Set the {@link #tipoServicio} without adding this Ofertas instance on the
	 * passed {@link #tipoServicio}
	 */
	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public Ofertas tipoServicio(TipoServicio tipoServicio) {
		setTipoServicio(tipoServicio);
		return this;
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// many-to-one: Ofertas.cliente ==> Cliente.id
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	@NotNull
	@JoinColumn(name = "cliente_id", nullable = false)
	@ManyToOne
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Set the {@link #cliente} without adding this Ofertas instance on the passed
	 * {@link #cliente}
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Ofertas cliente(Cliente cliente) {
		setCliente(cliente);
		return this;
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// many-to-one: Ofertas.tipoProyecto ==> TipoProyecto.id
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	@NotNull
	@JoinColumn(name = "tipo_proyecto_id", nullable = false)
	@ManyToOne
	public TipoProyecto getTipoProyecto() {
		return tipoProyecto;
	}

	/**
	 * Set the {@link #tipoProyecto} without adding this Ofertas instance on the
	 * passed {@link #tipoProyecto}
	 */
	public void setTipoProyecto(TipoProyecto tipoProyecto) {
		this.tipoProyecto = tipoProyecto;
	}

	public Ofertas tipoProyecto(TipoProyecto tipoProyecto) {
		setTipoProyecto(tipoProyecto);
		return this;
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// many-to-one: Ofertas.complejidad ==> Complejidad.id
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	@JoinColumn(name = "complejidad_id")
	@ManyToOne
	public Complejidad getComplejidad() {
		return complejidad;
	}

	/**
	 * Set the {@link #complejidad} without adding this Ofertas instance on the
	 * passed {@link #complejidad}
	 */
	public void setComplejidad(Complejidad complejidad) {
		this.complejidad = complejidad;
	}

	public Ofertas complejidad(Complejidad complejidad) {
		setComplejidad(complejidad);
		return this;
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// many-to-one: Ofertas.tipoContrato ==> TipoContrato.id
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	@JoinColumn(name = "tipo_contrato_id")
	@ManyToOne
	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}

	/**
	 * Set the {@link #tipoContrato} without adding this Ofertas instance on the
	 * passed {@link #tipoContrato}
	 */
	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public Ofertas tipoContrato(TipoContrato tipoContrato) {
		setTipoContrato(tipoContrato);
		return this;
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// many-to-one: Ofertas.analistaFinanciero ==> AnalistaFinaciero.id
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	@NotNull
	@JoinColumn(name = "analista_financiero_id", nullable = false)
	@ManyToOne
	public AnalistaFinaciero getAnalistaFinanciero() {
		return analistaFinanciero;
	}

	/**
	 * Set the {@link #analistaFinanciero} without adding this Ofertas instance on
	 * the passed {@link #analistaFinanciero}
	 */
	public void setAnalistaFinanciero(AnalistaFinaciero analistaFinanciero) {
		this.analistaFinanciero = analistaFinanciero;
	}

	public Ofertas analistaFinanciero(AnalistaFinaciero analistaFinanciero) {
		setAnalistaFinanciero(analistaFinanciero);
		return this;
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// many-to-one: Ofertas.segmentoNegocion ==> SegmentoNegocio.id
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	@NotNull
	@JoinColumn(name = "segmento_negocion_id", nullable = false)
	@ManyToOne
	public SegmentoNegocio getSegmentoNegocion() {
		return segmentoNegocion;
	}

	/**
	 * Set the {@link #segmentoNegocion} without adding this Ofertas instance on the
	 * passed {@link #segmentoNegocion}
	 */
	public void setSegmentoNegocion(SegmentoNegocio segmentoNegocion) {
		this.segmentoNegocion = segmentoNegocion;
	}

	public Ofertas segmentoNegocion(SegmentoNegocio segmentoNegocion) {
		setSegmentoNegocion(segmentoNegocion);
		return this;
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// many-to-one: Ofertas.estado ==> Estado.id
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	@NotNull
	@JoinColumn(name = "estado_id", nullable = false)
	@ManyToOne
	public Estado getEstado() {
		return estado;
	}

	/**
	 * Set the {@link #estado} without adding this Ofertas instance on the passed
	 * {@link #estado}
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Ofertas estado(Estado estado) {
		setEstado(estado);
		return this;
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// many-to-one: Ofertas.moneda ==> Moneda.id
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	@NotNull
	@JoinColumn(name = "moneda_id", nullable = false)
	@ManyToOne
	public Moneda getMoneda() {
		return moneda;
	}

	/**
	 * Set the {@link #moneda} without adding this Ofertas instance on the passed
	 * {@link #moneda}
	 */
	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public Ofertas moneda(Moneda moneda) {
		setMoneda(moneda);
		return this;
	}

	// -----------------------------------------------------------------
	// One to one
	// -----------------------------------------------------------------

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// Owner side of one-to-one relation: Ofertas.id ==> Oportunidad.id
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	@JoinColumn(name = "oferta_id", nullable = false, unique = true)
	@MapsId
	@OneToOne
	public Oportunidad getOportunidad2() {
		return oportunidad2;
	}

	public void setOportunidad2(Oportunidad oportunidad2) {
		this.oportunidad2 = oportunidad2;
	}

	public Ofertas oportunidad2(Oportunidad oportunidad2) {
		setOportunidad2(oportunidad2);
		return this;
	}

	/**
	 * Apply the default values.
	 */
	public Ofertas withDefaults() {
		return this;
	}

	/**
	 * Equals implementation using a business key.
	 */
	@Override
	public boolean equals(Object other) {
		return this == other || (other instanceof Ofertas && hashCode() == other.hashCode());
	}

	private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

	@Override
	public int hashCode() {
		return identifiableHashBuilder.hash(log, this);
	}

	/**
	 * Construct a readable string representation for this Ofertas instance.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this) //
				.add("id", getId()) //
				.add("cliente", getCliente()) //
				.add("codigo", getCodigo()) //
				.add("version", getVersion()) //
				.add("oportunidad", getOportunidad()) //
				.add("contacto", getContacto()) //
				.add("telefonoContacto", getTelefonoContacto()) //
				.add("correoContacto", getCorreoContacto()) //
				.add("descripcion", getDescripcion()) //
				.add("complejidad", getComplejidad()) //
				.add("estado", getEstado()) //
				.add("tipoContrato", getTipoContrato()) //
				.add("tipoProyecto", getTipoProyecto()) //
				.add("tipoServicio", getTipoServicio()) //
				.add("periodocontrato", getPeriodocontrato()) //
				.add("tiempoimplantacion", getTiempoimplantacion()) //
				.add("pagounico", getPagounico()) //
				.add("pagorecurrente", getPagorecurrente()) //
				.add("pagorecurrenteactual", getPagorecurrenteactual()) //
				.add("diferenciaingresos", getDiferenciaingresos()) //
				.add("vanvai", getVanvai()) //
				.add("payback", getPayback()) //
				.add("oibda", getOibda()) //
				.add("resultado", getResultado()) //
				.add("aprobadores", getAprobadores()) //
				.add("segmentoNegocion", getSegmentoNegocion()) //
				.add("analistaFinanciero", getAnalistaFinanciero()) //
				.add("moneda", getMoneda()) //
				.toString();
	}
}
