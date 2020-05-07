package com.incloud.tgestiona.b2b.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.incloud.tgestiona.b2b.model.oferta.Estado;
import com.incloud.tgestiona.b2b.model.oferta.Ofertas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "departamento", schema = "oferta")
public class Departamento {

	
	 	@Id
	    @Column(name = "departamento_id", nullable = false)
	    private String departamentoId;
	 	
	 	@Column(name = "descripcion")
		 private String descripcion;
	 	
	 	@Column(name = "activo")
		 private Boolean activo;
}
