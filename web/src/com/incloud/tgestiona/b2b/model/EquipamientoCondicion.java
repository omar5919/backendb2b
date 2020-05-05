package com.incloud.tgestiona.b2b.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.incloud.tgestiona.b2b.model.oferta.OfertasOpex;
import com.incloud.tgestiona.domain.BaseDomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "equipamiento_condicion",schema = "oferta_dev")
public class EquipamientoCondicion  extends BaseDomain {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "equipamiento_condicion_id" , nullable = false)
	 	private Integer equipamientoCondicionId;
	 
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
