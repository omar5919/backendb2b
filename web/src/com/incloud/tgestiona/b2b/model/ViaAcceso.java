package com.incloud.tgestiona.b2b.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.incloud.tgestiona.b2b.model.oferta.Ofertas;
import com.incloud.tgestiona.domain.BaseDomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "via_acceso",schema = "oferta")
public class ViaAcceso   extends BaseDomain implements Identifiable<Integer>, Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "via_acceso_id" ,nullable = true, precision = 10)
	private Integer via_acceso_id;
	
	@Column(name = "codigo_isis", length = 2 )
	private String codigo_isis ;
	
	@Column(name = "descripcion", length = 60 )
	private String descripcion ;
	
	@Column(name = "tipo_servicio_id",  precision = 10 )
	private Integer tipo_servicio_id ;
	
	@Column(name = "activo" )
	private Boolean activo ;

	@Override
	public String entityClassName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return via_acceso_id;
	}

	@Override
	public void setId(Integer id) {
		this.via_acceso_id=id;
	}

	@Override
	public boolean isIdSet() {
		// TODO Auto-generated method stub
		return via_acceso_id!=null;
	}
}
