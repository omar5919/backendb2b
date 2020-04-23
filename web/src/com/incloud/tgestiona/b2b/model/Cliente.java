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
import javax.validation.constraints.Size;

import com.google.common.base.MoreObjects;
import com.incloud.tgestiona.domain.BaseDomain;

@Entity
@Table(name = "cliente")
//@Audited
//@AuditTable("_audi_cliente")
public class Cliente extends BaseDomain implements Identifiable<Integer>, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(Cliente.class.getName());

	/***************************/
	/* Atributos de la Entidad */
	/***************************/

	// Raw attributes
	private Integer id;
	private String codigoIsis;
	private String descripcion;
	private String numeroIdentificadorFiscal;
	private String direccion;
	private String codigoFacturacion;
	private String gerenteCuenta;

	@Override
	public String entityClassName() {
		return Cliente.class.getSimpleName();
	}

	// -- [id] ------------------------

	@Override
	@Column(name = "cliente_id", precision = 10)
	@GeneratedValue(strategy = SEQUENCE, generator = "seq_cliente")
	@Id
	@SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente", allocationSize = 1)
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente id(Integer id) {
		setId(id);
		return this;
	}

	@Override
	@Transient
	public boolean isIdSet() {
		return id != null;
	}
	// -- [codigoIsis] ------------------------

	@Size(max = 20, message = "{message.cliente.codigoIsis.sizeMax} {max} {message.caracter}")
	@Column(name = "codigo_isis", length = 20)
	public String getCodigoIsis() {
		return codigoIsis;
	}

	public void setCodigoIsis(String codigoIsis) {
		this.codigoIsis = codigoIsis;
	}

	public Cliente codigoIsis(String codigoIsis) {
		setCodigoIsis(codigoIsis);
		return this;
	}
	// -- [descripcion] ------------------------

	@Size(max = 250, message = "{message.cliente.descripcion.sizeMax} {max} {message.caracter}")
	@Column(name = "descripcion", length = 250)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente descripcion(String descripcion) {
		setDescripcion(descripcion);
		return this;
	}
	// -- [numeroIdentificadorFiscal] ------------------------

	@Size(max = 25, message = "{message.cliente.numeroIdentificadorFiscal.sizeMax} {max} {message.caracter}")
	@Column(name = "numero_identificador_fiscal", length = 25)
	public String getNumeroIdentificadorFiscal() {
		return numeroIdentificadorFiscal;
	}

	public void setNumeroIdentificadorFiscal(String numeroIdentificadorFiscal) {
		this.numeroIdentificadorFiscal = numeroIdentificadorFiscal;
	}

	public Cliente numeroIdentificadorFiscal(String numeroIdentificadorFiscal) {
		setNumeroIdentificadorFiscal(numeroIdentificadorFiscal);
		return this;
	}
	// -- [direccion] ------------------------

	@Size(max = 500, message = "{message.cliente.direccion.sizeMax} {max} {message.caracter}")
	@Column(name = "direccion", length = 500)
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Cliente direccion(String direccion) {
		setDireccion(direccion);
		return this;
	}
	// -- [codigoFacturacion] ------------------------

	@Size(max = 8, message = "{message.cliente.codigoFacturacion.sizeMax} {max} {message.caracter}")
	@Column(name = "codigo_facturacion", length = 8)
	public String getCodigoFacturacion() {
		return codigoFacturacion;
	}

	public void setCodigoFacturacion(String codigoFacturacion) {
		this.codigoFacturacion = codigoFacturacion;
	}

	public Cliente codigoFacturacion(String codigoFacturacion) {
		setCodigoFacturacion(codigoFacturacion);
		return this;
	}
	// -- [gerenteCuenta] ------------------------

	@Size(max = 200, message = "{message.cliente.gerenteCuenta.sizeMax} {max} {message.caracter}")
	@Column(name = "gerente_cuenta", length = 200)
	public String getGerenteCuenta() {
		return gerenteCuenta;
	}

	public void setGerenteCuenta(String gerenteCuenta) {
		this.gerenteCuenta = gerenteCuenta;
	}

	public Cliente gerenteCuenta(String gerenteCuenta) {
		setGerenteCuenta(gerenteCuenta);
		return this;
	}

	/**
	 * Apply the default values.
	 */
	public Cliente withDefaults() {
		return this;
	}

	/**
	 * Equals implementation using a business key.
	 */
	@Override
	public boolean equals(Object other) {
		return this == other || (other instanceof Cliente && hashCode() == other.hashCode());
	}

	private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

	@Override
	public int hashCode() {
		return identifiableHashBuilder.hash(log, this);
	}

	/**
	 * Construct a readable string representation for this Cliente instance.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this) //
				.add("id", getId()) //
				.add("codigoIsis", getCodigoIsis()) //
				.add("descripcion", getDescripcion()) //
				.add("numeroIdentificadorFiscal", getNumeroIdentificadorFiscal()) //
				.add("direccion", getDireccion()) //
				.add("codigoFacturacion", getCodigoFacturacion()) //
				.add("gerenteCuenta", getGerenteCuenta()) //
				.toString();
	}
}
