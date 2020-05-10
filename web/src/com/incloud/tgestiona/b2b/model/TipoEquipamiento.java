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
//tipo_equipamiento
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipo_equipamiento",schema = "oferta")
public class TipoEquipamiento  extends BaseDomain implements Identifiable<Integer>, Serializable {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_equipamiento_id" ,nullable = true, precision = 10)
	private Integer tipoEquipamientoId  ;
	
	@Column(name = "categoria_equipamiento_id"  )
	private String categoriaEquipamientoId ;
	
	@Column(name = "descripcion"  )
	private String descripcion ;
	
	@Column(name = "activo"  )
	private Boolean activo ;
	@Override
	public boolean isIdSet() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String entityClassName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return tipoEquipamientoId;
	}
	@Override
	public void setId(Integer id) {
		this.tipoEquipamientoId=id;
		
	}
}
