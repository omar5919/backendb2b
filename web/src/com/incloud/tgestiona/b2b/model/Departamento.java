package com.incloud.tgestiona.b2b.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.incloud.tgestiona.b2b.model.oferta.Estado;
import com.incloud.tgestiona.b2b.model.oferta.Ofertas;
import com.incloud.tgestiona.domain.BaseDomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "departamento", schema = "oferta")
public class Departamento extends BaseDomain implements Identifiable<Integer>, Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departamento_id", updatable = false, nullable = false)
    private Integer departamentoId;

    @Column(name = "codigo_departamento")
    private String codigoDepartamento;

    
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "activo")
    private Boolean activo;



	@Override
	public String entityClassName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return departamentoId;
	}

	@Override
	public void setId(Integer id) {
		this.departamentoId=id;
		
	}

	@Override
	public boolean isIdSet() {
		// TODO Auto-generated method stub
		return false;
	}
}
