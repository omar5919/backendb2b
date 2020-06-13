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
@Table(name = "tipo_servicio",schema="oferta")
//@Audited
//@AuditTable("_audi_tipo_servicio")
public class TipoServicio extends BaseDomain  implements Identifiable<Integer>, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(TipoServicio.class.getName());

	/***************************/
	/* Atributos de la Entidad */
	/***************************/

	// Raw attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_servicio_id", updatable = false, nullable = false)
	private Integer id;
	
	@Column(name = "servicio_id" )
	private String servicoId;
	

	private String descripcion;
	private String codigoIsis;
	
	@Column(name = "codigo_producto_isis" )
	private String codigoProductoIsis;
	
	
	@Column(name = "satelital" )
	private Boolean satelital;
	
	@Column(name = "activo" )
	private Boolean activo;
	
	@Column(name = "grupo_satelital" )
	private Integer grupoSatelital;
	

	// -- [id] ------------------------
 
 

	@Override
	@Transient
	public boolean isIdSet() {
		return id != null;
	}
	// -- [codigoIsis] ------------------------

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotEmpty(message = "{message.tipoServicio.codigoIsis.requerido}")
	@Size(max = 15, message = "{message.tipoServicio.codigoIsis.sizeMax} {max} {message.caracter}")
	@Column(name = "codigo_isis", nullable = false, length = 15)
	public String getCodigoIsis() {
		return codigoIsis;
	}

	public void setCodigoIsis(String codigoIsis) {
		this.codigoIsis = codigoIsis;
	}

	public TipoServicio codigoIsis(String codigoIsis) {
		setCodigoIsis(codigoIsis);
		return this;
	}
	// -- [descripcion] ------------------------

	@Size(max = 50, message = "{message.tipoServicio.descripcion.sizeMax} {max} {message.caracter}")
	@Column(name = "descripcion", length = 50)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	
	
	
	public String getServicoId() {
		return servicoId;
	}

	public void setServicoId(String servicoId) {
		this.servicoId = servicoId;
	}

	public String getCodigoProductoIsis() {
		return codigoProductoIsis;
	}

	public void setCodigoProductoIsis(String codigoProductoIsis) {
		this.codigoProductoIsis = codigoProductoIsis;
	}

	public Boolean getSatelital() {
		return satelital;
	}

	public void setSatelital(Boolean satelital) {
		this.satelital = satelital;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public void setgrupoSatelital(Integer grupoSatelital) {
		this.grupoSatelital = grupoSatelital;
	}

	public Integer getgrupoSatelital() {
		return grupoSatelital;
	}

	public TipoServicio descripcion(String descripcion) {
		setDescripcion(descripcion);
		return this;
	}

	/**
	 * Apply the default values.
	 */
	public TipoServicio withDefaults() {
		return this;
	}

	/**
	 * Equals implementation using a business key.
	 */
 

	/**
	 * Construct a readable string representation for this TipoServicio instance.
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

	@Override
	public String entityClassName() {
		// TODO Auto-generated method stub
		return null;
	}
}
