package com.incloud.tgestiona.b2b.model.oferta;


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
@Table(name = "ofertas_opex",schema = "oferta")
public class OfertasOpex extends BaseDomain {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ofertas_opex_id" , nullable = false)
    private Integer ofertaOpexID;

    
    @ManyToOne
    @JoinColumn(name = "ofertas_id")
    //@Column(name = "oferta_id",nullable = true, precision = 10)
    private Integer ofertaId;

    @Column(name = "concepto_id",nullable = true, precision = 10)
    private Integer conceptoId;

    @Column(name = "nombre",  precision = 250)
    private String nombre;

    @Column(name = "cantidad",nullable = true, precision = 10)
    private Integer cantidad;

    @Column(name = "meses",nullable = true, precision = 10)
    private Integer meses;

    @Digits(integer = 4, fraction = 5)
    @Column(name = "factor", precision = 12, scale = 4)
    private BigDecimal factor;

    @Column(name = "moneda_id",nullable = true, precision = 10)
    private Integer monedaId;

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