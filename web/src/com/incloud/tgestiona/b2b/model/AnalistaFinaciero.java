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

import com.google.common.base.MoreObjects;
import com.incloud.tgestiona.domain.BaseDomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "analista_financiero",schema="oferta")
//@Audited
//@AuditTable("_audi_analista_finaciero")
public class AnalistaFinaciero extends BaseDomain implements Identifiable<Integer> , Serializable  {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(AnalistaFinaciero.class.getName());

	/***************************/
	/* Atributos de la Entidad */
	/***************************/
	// Raw attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "analista_financiero_id", updatable = false, nullable = false)
	private Integer id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "activo")
	private Boolean activo;

	/**
	 * Equals implementation using a business key.
	
	@Override
	public boolean equals(Object other) {
		return this == other || (other instanceof AnalistaFinaciero && hashCode() == other.hashCode());
	}

	private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

	@Override
	public int hashCode() {
		return identifiableHashBuilder.hash(log, this);
	}
 */
	/**
	 * Construct a readable string representation for this AnalistaFinaciero
	 * instance.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this) //
				.add("id", getId()) //
				.toString();
	}

	@Override
	public boolean isIdSet() {
		// TODO Auto-generated method stub
		return id != null;
	}

	@Override
	public String entityClassName() {
		// TODO Auto-generated method stub
		return null;
	}
}
