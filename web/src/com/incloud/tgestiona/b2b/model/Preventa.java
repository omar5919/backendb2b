package com.incloud.tgestiona.b2b.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.*;

import com.incloud.tgestiona.domain.BaseDomain;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "preventa",schema = "oferta")
public class Preventa extends BaseDomain implements Identifiable<Integer>, Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "preventa_id", updatable = false, nullable = false)
    private Integer preventa_id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "activo")
    private boolean activo;

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
		return preventa_id;
	}

	@Override
	public void setId(Integer id) {
		this.preventa_id=id;
		
	}


}
