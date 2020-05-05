package com.incloud.tgestiona.b2b.model.oferta;


import com.incloud.tgestiona.b2b.model.ConceptosOpex;
import com.incloud.tgestiona.b2b.model.Moneda;
import com.incloud.tgestiona.b2b.model.Preventa;
import com.incloud.tgestiona.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Digits;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ofertas_opex",schema = "oferta_dev")
public class OfertasOpex extends BaseDomain {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ofertas_opex_id" , nullable = false)
    private Integer ofertaOpexId;

    
    //@ManyToOne
    //@JoinColumn(name = "ofertas_id")
    //@Column(name = "oferta_id",nullable = true, precision = 10)
    //private Integer ofertaId;

    @ManyToOne
    @JoinColumn(name = "oferta_Id",referencedColumnName = "oferta_Id")
    //@Column(name = "oferta_id",nullable = true, precision = 10)
    private Ofertas oferta;
   
    
    //@Column(name = "concepto_id",nullable = true, precision = 10)
    //private Integer conceptoId;
    
    @ManyToOne
    @JoinColumn(name = "concepto_id",referencedColumnName = "concepto_id")
    //@Column(name = "oferta_id",nullable = true, precision = 10)
    private ConceptosOpex conceptosOpex;

    @Column(name = "nombre",  precision = 250)
    private String nombre;

    @Column(name = "cantidad",nullable = true, precision = 10)
    private Integer cantidad;

    @Column(name = "meses",nullable = true, precision = 10)
    private Integer meses;

    @Digits(integer = 4, fraction = 5)
    @Column(name = "factor", precision = 12, scale = 4)
    private BigDecimal factor;

    //@JoinColumn(name = "monedaId")
    //@Column(name = "monedaId",nullable = true, precision = 10)
    //private Integer 	moneda_id;
    @ManyToOne
    @JoinColumn(name = "moneda_id",referencedColumnName = "moneda_id")
    private Moneda 	moneda;

    @Digits(integer = 4, fraction = 5)
    @Column(name = "unitario_mensual", precision = 12, scale = 4)
    private BigDecimal unitarioMensual;

    @Digits(integer = 4, fraction = 5)
    @Column(name = "total_mensual", precision = 12, scale = 4)
    private BigDecimal totalMensual;

	@Override
	public boolean isIdSet() {
		// TODO Auto-generated method stub
		return false;
	}

    


	 
    	

}