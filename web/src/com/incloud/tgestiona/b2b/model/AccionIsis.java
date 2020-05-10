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
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import com.google.common.base.MoreObjects;
import com.incloud.tgestiona.domain.BaseDomain;

@Entity
@Table(name = "accion_isis",schema="oferta")
//@Audited
//@AuditTable("_audi_accion_isis")
public class AccionIsis extends BaseDomain  implements Identifiable<Integer> , Serializable{
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(AccionIsis.class.getName());

	/***************************/
	/* Atributos de la Entidad */
	/***************************/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "accion_isis_id", updatable = false, nullable = false)
	private Integer id;

	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "codigo_isis")
	private String codigoIsis;
	
	@Column(name = "activo")
	private Boolean activo;
	
 

	public String getCodigoIsis() {
		return codigoIsis;
	}

	public void setCodigoIsis(String codigoIsis) {
		this.codigoIsis = codigoIsis;
	}

	public Boolean getActivo() {
		return activo;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public AccionIsis descripcion(String descripcion) {
		setDescripcion(descripcion);
		return this;
	}
 
 

	/**
	 * Construct a readable string representation for this AccionIsis instance.
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
