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
@Table(name = "sisego_condicion",schema = "oferta")
public class SisegoCondicion extends BaseDomain implements Identifiable<Integer>, Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sisego_condicion_id" ,nullable = true, precision = 10)
	private Integer sisegoCondicionId ;
	
	@Column(name = "descripcion" )
	private String descripcion ;
	
	@Column(name = "activo"  )
	private Boolean activo ;
	
	@Override
	public String entityClassName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isIdSet() {
		// TODO Auto-generated method stub
		return false;
	}
}
