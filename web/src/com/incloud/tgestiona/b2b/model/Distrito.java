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
@Table(name = "distrito", schema = "oferta")
public class Distrito extends BaseDomain implements Identifiable<Integer>, Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "distrito_id", updatable = false, nullable = false)
    private Integer distritoId;

    @Column(name = "departamento_id")
    private Integer departamentoId;
    
    @Column(name = "provincia_id")
    private Integer provinciaId;

    @Column(name = "departamento_codigo")
    private String departamentoCodigo;
    
    @Column(name = "provincia_codigo")
    private String provinciaCodigo;
    
    @Column(name = "distrito_codigo")
    private String distritoCodigo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "activo")
    private Boolean activo;

	@Override
	public boolean isIdSet() {
		// TODO Auto-generated method stub
		return distritoId!=null;
	}

	@Override
	public String entityClassName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return distritoId;
	}

	@Override
	public void setId(Integer id) {
		this.distritoId=id;
		
	}
}


