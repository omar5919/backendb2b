package com.incloud.tgestiona.b2b.model.oferta;


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
@Table(name = "ofertas_capex",schema = "oferta")
public class OfertasCapex extends BaseDomain {
 

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ofertas_capex_id" , nullable = false)
    private Integer 	ofertaCapexId;

    @JoinColumn(name = "ofertas_id")
    //@Column(name = "oferta_id",nullable = true, precision = 10)
    private Integer 	ofertaId;

    @Column(name = "tipoEquipamientoId",nullable = true, precision = 10)
    private Integer 	tipoEquipamientoId;

    @Column(name = "equipamiento_condicion_id",nullable = true, precision = 10)
    private Integer 	equipamientoCondicionId;

    @Column(name = "cantidad",nullable = true, precision = 10)
    private Integer 	cantidad;

    @Column(name = "antiguedad",nullable = true, precision = 10)
    private Integer 	antiguedad;

    @Column(name = "equipamiento_marca_id",nullable = true, precision = 10)
    private Integer 	equipamientoMarcaId;

    @Column(name = "modelo_descripcion",  precision = 250)
    private String	modeloDescripcion;

    @Column(name = "monedaId",nullable = true, precision = 10)
    private Integer 	moneda_id;

    @Digits(integer = 4, fraction = 5)
    @Column(name = "unitario", precision = 12, scale = 4)
    private BigDecimal 	unitario;

    @Digits(integer = 4, fraction = 5)
    @Column(name = "total", precision = 12, scale = 4)
    private BigDecimal 	total;

	@Override
	public boolean isIdSet() {
		// TODO Auto-generated method stub
		return false;
	}

  

}