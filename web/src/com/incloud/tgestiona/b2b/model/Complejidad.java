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
	private Integer id;
	
	@Column(name = "codigo_isis")
	private String codigoIsis;
	
	@Column(name = "descripcion")
	private String descripcion;

	   @Column(name = "activo")
	    private Boolean activo;
	
	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	@Override
	public String entityClassName() {
		return Complejidad.class.getSimpleName();
	}

	// -- [id] ------------------------

	@Override
	@Column(name = "complejidad_id", precision = 10)
	@GeneratedValue(strategy = SEQUENCE, generator = "seq_complejidad")
	@Id
	@SequenceGenerator(name = "seq_complejidad", sequenceName = "seq_complejidad", allocationSize = 1)
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Complejidad id(Integer id) {
		setId(id);
		return this;
	}

	@Override
	@Transient
	public boolean isIdSet() {
		return id != null;
	}


	/**
	 * Apply the default values.
	 */
	public Complejidad withDefaults() {
		return this;
	}

	public String getCodigoIsis() {
		return codigoIsis;
	}

	public void setCodigoIsis(String codigoIsis) {
		this.codigoIsis = codigoIsis;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Equals implementation using a business key.
	 */
	@Override
	public boolean equals(Object other) {
		return this == other || (other instanceof Complejidad && hashCode() == other.hashCode());
	}



	/**
	 * Construct a readable string representation for this Complejidad instance.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this) //
				.add("id", getId()) //
				.add("codigoIsis", getCodigoIsis()) //
				.add("descripcion", getDescripcion()) //
				.toString();
	}
}
