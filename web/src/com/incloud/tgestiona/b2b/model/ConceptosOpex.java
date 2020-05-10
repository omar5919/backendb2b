package com.incloud.tgestiona.b2b.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.incloud.tgestiona.b2b.model.oferta.Ofertas;
import com.incloud.tgestiona.b2b.model.oferta.OfertasOpex;
import com.incloud.tgestiona.domain.BaseDomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "concepto_opex",schema = "oferta")
public class ConceptosOpex  extends BaseDomain implements Identifiable<Integer>, Serializable {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "concepto_id" , nullable = false)
	 	private Integer conceptoId ;
	 	
 		@Column(name = "descripcion", length = 200 )
		private String descripcion ;
	 	
 		@Column(name = "tipo"  )
		private String tipo ;

 		@Column(name = "factor"  )
		private BigDecimal factor ;

	 	
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
			return null;
		}

		@Override
		public void setId(Integer id) {
			// TODO Auto-generated method stub
			
		}
}
