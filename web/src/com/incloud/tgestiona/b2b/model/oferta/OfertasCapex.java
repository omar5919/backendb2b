package com.incloud.tgestiona.b2b.model.oferta;


import com.incloud.tgestiona.b2b.model.EquipamientoCondicion;
import com.incloud.tgestiona.b2b.model.EquipamientoMarca;
import com.incloud.tgestiona.b2b.model.Moneda;
import com.incloud.tgestiona.b2b.model.TipoEquipamiento;
import com.incloud.tgestiona.b2b.model.TipoPago;
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

    //@JoinColumn(name = "ofertas_id")
    //@Column(name = "oferta_id",nullable = true, precision = 10)
    //private Integer 	ofertaId;
    
    @ManyToOne
    @JoinColumn(name = "oferta Id",referencedColumnName = "oferta_Id")
    private Ofertas ofertas;
    

    //@Column(name = "tipoEquipamientoId",nullable = true, precision = 10)
    //private Integer 	tipoEquipamientoId;
    
    
    @ManyToOne
    @JoinColumn(name = "tipo_equipamiento_id",referencedColumnName = "tipo_equipamiento_id")
    private TipoEquipamiento tipoequipamiento;

    //@Column(name = "equipamiento_condicion_id",nullable = true, precision = 10)
    //private Integer 	equipamientoCondicionId;
    
    @ManyToOne
    @JoinColumn(name = "equipamiento_condicion_id",referencedColumnName = "equipamiento_condicion_id")
    private EquipamientoCondicion equipamientoCondicion;

    @Column(name = "cantidad",nullable = true, precision = 10)
    private Integer 	cantidad;

    @Column(name = "antiguedad",nullable = true, precision = 10)
    private Integer 	antiguedad;

    //@Column(name = "equipamiento_marca_id",nullable = true, precision = 10)
    //private Integer 	equipamientoMarcaId;
    
    @ManyToOne
    @JoinColumn(name = "equipamiento_marca_id",referencedColumnName = "equipamiento_marca_id")
    private EquipamientoMarca equipamientomarca;


    @Column(name = "modelo_descripcion",  precision = 250)
    private String	modeloDescripcion;

    //@JoinColumn(name = "monedaId")
    //@Column(name = "monedaId",nullable = true, precision = 10)
    //private Integer 	moneda_id;
    @ManyToOne
    @JoinColumn(name = "moneda_id",referencedColumnName = "moneda_id")
    private Moneda 	moneda;
    
    @Digits(integer = 4, fraction = 5)
    @Column(name = "unitario", precision = 12, scale = 4)
    private BigDecimal 	unitario;

    @Digits(integer = 4, fraction = 5)
    @Column(name = "total", precision = 12, scale = 4)
    private BigDecimal 	total;

	@Override
	public boolean isIdSet() {
		// TODO Auto-generated method stub
		//OfertasCapex m; 
		return false;
	}
	
	

}