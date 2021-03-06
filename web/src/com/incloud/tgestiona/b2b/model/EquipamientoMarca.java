package com.incloud.tgestiona.b2b.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.incloud.tgestiona.domain.BaseDomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "equipamiento_marca",schema = "oferta")
public class EquipamientoMarca  extends BaseDomain implements Identifiable<Integer>, Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipamiento_marca_id" ,nullable = true, precision = 10)
	private Integer  equipamientoMarcaId;
	
	@Column(name = "descripcion", length = 50 )
	private String descripcion ;
	
	@Column(name = "codigo_isis", length = 50 )
	private String codigo_isis ;
	
	@Column(name = "activo"  )
	private Boolean activo ;

	@Override
	public boolean isIdSet() {
		// TODO Auto-generated method stub
		return equipamientoMarcaId!=null;
	}

	@Override
	public String entityClassName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return equipamientoMarcaId;
	}

	@Override
	public void setId(Integer id) {
		this.equipamientoMarcaId=id;
		
	}
	
	

}
