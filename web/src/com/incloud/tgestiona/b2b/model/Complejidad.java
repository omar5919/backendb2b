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
@Table(name = "complejidad",schema="oferta")
//@Audited
//@AuditTable("_audi_complejidad")
public class Complejidad extends BaseDomain implements Identifiable<Integer>, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(Complejidad.class.getName());

	/***************************/
	/* Atributos de la Entidad */
	/***************************/

	// Raw attributes
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "complejidad_id", updatable = false, nullable = false)
	private Integer id;
    

	@Column(name = "codigo_isis")
	private String complejidadCodigo;
	
	@Column(name = "descripcion" )
	private String complejidadTipologiaDescrip;
	
	@Column(name = "activo")
	private Boolean activo;
	
	



	// -- [id] ------------------------





	@Override
	@Transient
	public boolean isIdSet() {
		return id != null;
	}
	// -- [complejidadCodigo] ------------------------


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getComplejidadCodigo() {
		return complejidadCodigo;
	}

	public void setComplejidadCodigo(String complejidadCodigo) {
		this.complejidadCodigo = complejidadCodigo;
	}

	public Complejidad complejidadCodigo(String complejidadCodigo) {
		setComplejidadCodigo(complejidadCodigo);
		return this;
	}
	// -- [complejidadTipologiaDescrip] ------------------------


	public String getComplejidadTipologiaDescrip() {
		return complejidadTipologiaDescrip;
	}

	public void setComplejidadTipologiaDescrip(String complejidadTipologiaDescrip) {
		this.complejidadTipologiaDescrip = complejidadTipologiaDescrip;
	}

	public Complejidad complejidadTipologiaDescrip(String complejidadTipologiaDescrip) {
		setComplejidadTipologiaDescrip(complejidadTipologiaDescrip);
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
	public Complejidad withDefaults() {
		return this;
	}

	/**
	 * Equals implementation using a business key.
	 */


	/**
	 * Construct a readable string representation for this Complejidad instance.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this) //
				.add("id", getId()) //
				.add("complejidadCodigo", getComplejidadCodigo()) //
				.add("complejidadTipologiaDescrip", getComplejidadTipologiaDescrip()) //
				.toString();
	}


	@Override
	public String entityClassName() {
		// TODO Auto-generated method stub
		return null;
	}
}
