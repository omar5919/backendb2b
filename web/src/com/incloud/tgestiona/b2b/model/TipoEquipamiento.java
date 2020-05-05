package com.incloud.tgestiona.b2b.model;

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
@Table(name = "tipo_equipamiento",schema = "oferta_dev")
public class TipoEquipamiento  extends BaseDomain{
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_equipamiento_id" ,nullable = true, precision = 10)
	private Integer tipoEquipamientoId  ;
	
	@Column(name = "descripcion", length = 25 )
	private String descripcion ;
	@Column(name = "activo"  )
	private Boolean activo ;
	@Override
	public boolean isIdSet() {
		// TODO Auto-generated method stub
		return false;
	}
}
