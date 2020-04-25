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
import static javax.persistence.TemporalType.TIMESTAMP;
import java.util.Date;
import javax.persistence.Temporal;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "app_proceso_log")
//@Audited
//@AuditTable("_audi_app_proceso_log")
public class AppProcesoLog extends BaseDomain implements Identifiable<Integer>, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(AppProcesoLog.class.getName());

	/***************************/
	/* Atributos de la Entidad */
	/***************************/

	// Raw attributes
	private Integer id;
	private Date fechaInicioEjecucion;
	private Date fechaFinEjecucion;
	private String estadoEjecucion;
	private String descripcionEstadoEjecucion;
	private String modulo;
	private String claseProgramacion;
	private String metodoProgramacion;
	private String parametroEntrada;
	private String resultadoSalida;
	private Integer duracionMs;

	@Override
	public String entityClassName() {
		return AppProcesoLog.class.getSimpleName();
	}

	// -- [id] ------------------------

	@Override
	@Column(name = "app_proceso_log_id", precision = 10)
	@GeneratedValue(strategy = SEQUENCE, generator = "seq_app_proceso_log")
	@Id
	@SequenceGenerator(name = "seq_app_proceso_log", sequenceName = "seq_app_proceso_log", allocationSize = 1)
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public AppProcesoLog id(Integer id) {
		setId(id);
		return this;
	}

	@Override
	@Transient
	public boolean isIdSet() {
		return id != null;
	}
	// -- [fechaInicioEjecucion] ------------------------

	@Column(name = "fecha_inicio_ejecucion", length = 29)

	@Temporal(TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	public Date getFechaInicioEjecucion() {
		return fechaInicioEjecucion;
	}

	public void setFechaInicioEjecucion(Date fechaInicioEjecucion) {
		this.fechaInicioEjecucion = fechaInicioEjecucion;
	}

	public AppProcesoLog fechaInicioEjecucion(Date fechaInicioEjecucion) {
		setFechaInicioEjecucion(fechaInicioEjecucion);
		return this;
	}
	// -- [fechaFinEjecucion] ------------------------

	@Column(name = "fecha_fin_ejecucion", length = 29)

	@Temporal(TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	public Date getFechaFinEjecucion() {
		return fechaFinEjecucion;
	}

	public void setFechaFinEjecucion(Date fechaFinEjecucion) {
		this.fechaFinEjecucion = fechaFinEjecucion;
	}

	public AppProcesoLog fechaFinEjecucion(Date fechaFinEjecucion) {
		setFechaFinEjecucion(fechaFinEjecucion);
		return this;
	}
	// -- [estadoEjecucion] ------------------------

	@Size(max = 1, message = "{message.appProcesoLog.estadoEjecucion.sizeMax} {max} {message.caracter}")
	@Column(name = "estado_ejecucion", length = 1)
	public String getEstadoEjecucion() {
		return estadoEjecucion;
	}

	public void setEstadoEjecucion(String estadoEjecucion) {
		this.estadoEjecucion = estadoEjecucion;
	}

	public AppProcesoLog estadoEjecucion(String estadoEjecucion) {
		setEstadoEjecucion(estadoEjecucion);
		return this;
	}
	// -- [descripcionEstadoEjecucion] ------------------------

	@Size(max = 4000, message = "{message.appProcesoLog.descripcionEstadoEjecucion.sizeMax} {max} {message.caracter}")
	@Column(name = "descripcion_estado_ejecucion", length = 4000)
	public String getDescripcionEstadoEjecucion() {
		return descripcionEstadoEjecucion;
	}

	public void setDescripcionEstadoEjecucion(String descripcionEstadoEjecucion) {
		this.descripcionEstadoEjecucion = descripcionEstadoEjecucion;
	}

	public AppProcesoLog descripcionEstadoEjecucion(String descripcionEstadoEjecucion) {
		setDescripcionEstadoEjecucion(descripcionEstadoEjecucion);
		return this;
	}
	// -- [modulo] ------------------------

	@Size(max = 40, message = "{message.appProcesoLog.modulo.sizeMax} {max} {message.caracter}")
	@Column(name = "modulo", length = 40)
	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public AppProcesoLog modulo(String modulo) {
		setModulo(modulo);
		return this;
	}
	// -- [claseProgramacion] ------------------------

	@Size(max = 100, message = "{message.appProcesoLog.claseProgramacion.sizeMax} {max} {message.caracter}")
	@Column(name = "clase_programacion", length = 100)
	public String getClaseProgramacion() {
		return claseProgramacion;
	}

	public void setClaseProgramacion(String claseProgramacion) {
		this.claseProgramacion = claseProgramacion;
	}

	public AppProcesoLog claseProgramacion(String claseProgramacion) {
		setClaseProgramacion(claseProgramacion);
		return this;
	}
	// -- [metodoProgramacion] ------------------------

	@Size(max = 100, message = "{message.appProcesoLog.metodoProgramacion.sizeMax} {max} {message.caracter}")
	@Column(name = "metodo_programacion", length = 100)
	public String getMetodoProgramacion() {
		return metodoProgramacion;
	}

	public void setMetodoProgramacion(String metodoProgramacion) {
		this.metodoProgramacion = metodoProgramacion;
	}

	public AppProcesoLog metodoProgramacion(String metodoProgramacion) {
		setMetodoProgramacion(metodoProgramacion);
		return this;
	}
	// -- [parametroEntrada] ------------------------

	@Size(max = 4000, message = "{message.appProcesoLog.parametroEntrada.sizeMax} {max} {message.caracter}")
	@Column(name = "parametro_entrada", length = 4000)
	public String getParametroEntrada() {
		return parametroEntrada;
	}

	public void setParametroEntrada(String parametroEntrada) {
		this.parametroEntrada = parametroEntrada;
	}

	public AppProcesoLog parametroEntrada(String parametroEntrada) {
		setParametroEntrada(parametroEntrada);
		return this;
	}
	// -- [resultadoSalida] ------------------------

	@Size(max = 4000, message = "{message.appProcesoLog.resultadoSalida.sizeMax} {max} {message.caracter}")
	@Column(name = "resultado_salida", length = 4000)
	public String getResultadoSalida() {
		return resultadoSalida;
	}

	public void setResultadoSalida(String resultadoSalida) {
		this.resultadoSalida = resultadoSalida;
	}

	public AppProcesoLog resultadoSalida(String resultadoSalida) {
		setResultadoSalida(resultadoSalida);
		return this;
	}
	// -- [duracionMs] ------------------------

	@Digits(integer = 10, fraction = 0)
	@Column(name = "duracion_ms", precision = 10)
	public Integer getDuracionMs() {
		return duracionMs;
	}

	public void setDuracionMs(Integer duracionMs) {
		this.duracionMs = duracionMs;
	}

	public AppProcesoLog duracionMs(Integer duracionMs) {
		setDuracionMs(duracionMs);
		return this;
	}

	/**
	 * Apply the default values.
	 */
	public AppProcesoLog withDefaults() {
		return this;
	}

	/**
	 * Equals implementation using a business key.
	 */
	@Override
	public boolean equals(Object other) {
		return this == other || (other instanceof AppProcesoLog && hashCode() == other.hashCode());
	}

	private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

	@Override
	public int hashCode() {
		return identifiableHashBuilder.hash(log, this);
	}

	/**
	 * Construct a readable string representation for this AppProcesoLog instance.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this) //
				.add("id", getId()) //
				.add("fechaInicioEjecucion", getFechaInicioEjecucion()) //
				.add("fechaFinEjecucion", getFechaFinEjecucion()) //
				.add("estadoEjecucion", getEstadoEjecucion()) //
				.add("descripcionEstadoEjecucion", getDescripcionEstadoEjecucion()) //
				.add("modulo", getModulo()) //
				.add("claseProgramacion", getClaseProgramacion()) //
				.add("metodoProgramacion", getMetodoProgramacion()) //
				.add("parametroEntrada", getParametroEntrada()) //
				.add("resultadoSalida", getResultadoSalida()) //
				.add("duracionMs", getDuracionMs()) //
				.toString();
	}
}
