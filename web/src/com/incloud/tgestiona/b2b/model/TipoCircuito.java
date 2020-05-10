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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.google.common.base.MoreObjects;
import com.incloud.tgestiona.domain.BaseDomain;
import com.sun.istack.NotNull;

@Entity
@Table(name = "tipo_circuito",schema="oferta")
//@Audited
//@AuditTable("_audi_tipo_circuito")
public class TipoCircuito extends BaseDomain  implements Identifiable<Integer>, Serializable  {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(TipoCircuito.class.getName());

	/***************************/
	/* Atributos de la Entidad */
	/***************************/

	// Raw attributes
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_circuito_id" ,nullable = true, precision = 10)
	private Integer id;
	

	@Column(name = "jerarquia")
	private Integer jerarquia;
	

	@Column(name = "descripcion")
	private String descripcion;
	

	 @Column(name = "codigo_isis")
     private boolean codigoIsis;
	
	 @Column(name = "activo")
	 private boolean activo;

 
	// -- [id] ------------------------

	/*@Override
	@Column(name = "tipo_circuito_id", precision = 10)
	@GeneratedValue(strategy = SEQUENCE, generator = "seq_tipo_circuito")
	@Id
	@SequenceGenerator(name = "seq_tipo_circuito", sequenceName = "seq_tipo_circuito", allocationSize = 1)*/
 

	@Override
	@Transient
	public boolean isIdSet() {
		return id != null;
	}
	// -- [jerarquia] ------------------------


	public Integer getJerarquia() {
		return jerarquia;
	}

	public void setJerarquia(Integer jerarquia) {
		this.jerarquia = jerarquia;
	}

	public TipoCircuito jerarquia(Integer jerarquia) {
		setJerarquia(jerarquia);
		return this;
	}
	// -- [descTipoCd] ------------------------

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoCircuito descTipoCd(String descripcion) {
		setDescripcion(descripcion);
		return this;
	}

	
	
	public boolean isCodigoIsis() {
		return codigoIsis;
	}

	public void setCodigoIsis(boolean codigoIsis) {
		this.codigoIsis = codigoIsis;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	/**
	 * Apply the default values.
	 */
	public TipoCircuito withDefaults() {
		return this;
	}

	/**
	 * Equals implementation using a business key.
	 */


	/**
	 * Construct a readable string representation for this TipoCircuito instance.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this) //
				.add("id", getId()) //
				.add("jerarquia", getJerarquia()) //
				.add("descTipoCd", getDescripcion()) //
				.toString();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public String entityClassName() {
		// TODO Auto-generated method stub
		return null;
	}
}
