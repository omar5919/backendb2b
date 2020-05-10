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
import javax.validation.constraints.Size;

import com.google.common.base.MoreObjects;
import com.incloud.tgestiona.domain.BaseDomain;

@Entity
@Table(name = "tipo_proyecto",schema="oferta")
//@Audited
//@AuditTable("_audi_tipo_proyecto")
public class TipoProyecto extends BaseDomain  implements Identifiable<Integer>, Serializable  {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(TipoProyecto.class.getName());

	/***************************/
	/* Atributos de la Entidad */
	/***************************/

	// Raw attributes
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_proyecto_id", updatable = false, nullable = false)
	private Integer id;
	
	private String descripcion;
	
	@Column(name = "activo" )
	private Boolean activo;


	// -- [id] ------------------------

	/*@Override
	@Column(name = "tipo_proyecto_id", precision = 10)
	@GeneratedValue(strategy = SEQUENCE, generator = "seq_tipo_proyecto")
	@Id
	@SequenceGenerator(name = "seq_tipo_proyecto", sequenceName = "seq_tipo_proyecto", allocationSize = 1)*/

	
	

	public Boolean getActivo() {
		return activo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	@Override
	@Transient
	public boolean isIdSet() {
		return id != null;
	}
	// -- [descripcion] ------------------------

	@Size(max = 50, message = "{message.tipoProyecto.descripcion.sizeMax} {max} {message.caracter}")
	@Column(name = "descripcion", length = 50)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoProyecto descripcion(String descripcion) {
		setDescripcion(descripcion);
		return this;
	}

	/**
	 * Apply the default values.
	 */
	public TipoProyecto withDefaults() {
		return this;
	}

	/**
	 * Equals implementation using a business key.
	 */


	/**
	 * Construct a readable string representation for this TipoProyecto instance.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this) //
				.add("id", getId()) //
				.add("descripcion", getDescripcion()) //
				.toString();
	}

	@Override
	public String entityClassName() {
		// TODO Auto-generated method stub
		return null;
	}
}
