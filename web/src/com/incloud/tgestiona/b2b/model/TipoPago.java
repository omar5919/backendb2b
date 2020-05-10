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
@Table(name="tipo_pago",schema = "oferta")
public class TipoPago extends BaseDomain implements Identifiable<Integer>, Serializable {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_pago_id", updatable = false, nullable = false)
    private Integer tipoPagoId;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "activo")
    private boolean activo;

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
