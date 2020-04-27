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

import org.springframework.data.annotation.Transient;

import com.google.common.base.MoreObjects;
import com.incloud.tgestiona.domain.BaseDomain;

@Entity
@Table(name = "usuarios", schema = "seguridad")
public class Usuarios extends BaseDomain implements Identifiable<Integer>, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(Usuarios.class.getName());

	@Column(name = "usuario_id", precision = 10)
	@GeneratedValue(strategy = SEQUENCE, generator = "seq_usuario")
	@Id
	@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1)

	private Integer id;

	@Override
	public String entityClassName() {
		return Usuarios.class.getSimpleName();
	}

	public Usuarios id(Integer id) {
		setId(id);
		return this;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	@Override
	@Transient
	public boolean isIdSet() {
		return id != null;
	}

	@Column(name = "nombres")
	private String nombres;
	@Column(name = "apellidos")
	private String apellidos;
	@Column(name = "usuario")
	private String usuario;
	@Column(name = "clave")
	private String clave;
	@Column(name = "activo")
	private int activo;
	@Column(name = "token")
	private String token;

	@javax.persistence.Transient
	private String mensaje;
	private String nombrecorto;

	public String getNombrecorto() {
		return nombrecorto;
	}

	public void setNombrecorto(String nombrecorto) {
		this.nombrecorto = nombrecorto;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * Equals implementation using a business key.
	 */
	@Override
	public boolean equals(Object other) {
		return this == other || (other instanceof Usuarios && hashCode() == other.hashCode());
	}

	private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

	@Override
	public int hashCode() {
		return identifiableHashBuilder.hash(log, this);
	}

	/**
	 * Construct a readable string representation for this FacImputacion instance.
	 * 
	 * @see Object#toString()
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("Id", getId()).toString();
	}
}
