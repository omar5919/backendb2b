package com.incloud.tgestiona.b2b.model.oferta;


import com.incloud.tgestiona.b2b.model.ConceptosOpex;
import com.incloud.tgestiona.b2b.model.Identifiable;
import com.incloud.tgestiona.b2b.model.Moneda;
import com.incloud.tgestiona.b2b.model.Preventa;
import com.incloud.tgestiona.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Digits;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ofertas_opex",schema = "oferta")
public class OfertasOpex extends BaseDomain implements Identifiable<Integer>, Serializable  {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ofertas_opex_id" , nullable = false)
    private Integer ofertaOpexId;

    
    //@ManyToOne
    //@JoinColumn(name = "ofertas_id")
    //@Column(name = "oferta_id",nullable = true, precision = 10)
    //private Integer ofertaId;
     
    //@Column(name = "concepto_id",nullable = true, precision = 10)
    //private Integer conceptoId;

   
    @Column(name = "nombre",  precision = 250)
    private String nombre;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "meses")
    private Integer meses;

    @Column(name = "factor")
    private BigDecimal factor;

    //@JoinColumn(name = "monedaId")
    //@Column(name = "monedaId",nullable = true, precision = 10)
    //private Integer 	moneda_id;

    @Column(name = "unitario_mensual")
    private BigDecimal unitarioMensual;

    @Column(name = "total_mensual")
    private BigDecimal totalMensual;
    
    @Column(name = "activo")
    private Boolean activo;
    

    /***relaciones**/
    @ManyToOne
    @JoinColumn(name = "oferta_Id",referencedColumnName = "oferta_Id")
    //@Column(name = "oferta_id",nullable = true, precision = 10)
    private Ofertas oferta;

    @ManyToOne
    @JoinColumn(name = "concepto_id",referencedColumnName = "concepto_id")
    //@Column(name = "oferta_id",nullable = true, precision = 10)
    private ConceptosOpex conceptosOpex;

    @ManyToOne
    @JoinColumn(name = "moneda_id",referencedColumnName = "moneda_id")
    private Moneda 	moneda;

    
    
	@Override
	public boolean isIdSet() {
		// TODO Auto-generated method stub
		return ofertaOpexId!=null;
	}



	@Override
	public String entityClassName() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return ofertaOpexId;
	}



	@Override
	public void setId(Integer id) {
		this.ofertaOpexId=id;
		
	}

    


	 
    	

}