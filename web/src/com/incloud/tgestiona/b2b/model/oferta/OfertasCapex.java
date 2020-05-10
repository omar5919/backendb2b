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
  
    //@Column(name = "tipoEquipamientoId",nullable = true, precision = 10)
    //private Integer 	tipoEquipamientoId;
    
   

    //@Column(name = "equipamiento_condicion_id",nullable = true, precision = 10)
    //private Integer 	equipamientoCondicionId;
    
    @Column(name = "cantidad", precision = 10)
    private Integer 	cantidad;

    @Column(name = "antiguedad", precision = 10)
    private Integer 	antiguedad;

    //@Column(name = "equipamiento_marca_id",nullable = true, precision = 10)
    //private Integer 	equipamientoMarcaId;

    @Column(name = "modelo",  precision = 250)
    private String	modelo;

    //@JoinColumn(name = "monedaId")
    //@Column(name = "monedaId",nullable = true, precision = 10)
    //private Integer 	moneda_id;
     

    @Column(name = "unitario")
    private BigDecimal 	unitario;


    @Column(name = "total")
    private BigDecimal 	total;

    @Column(name = "activo" )
	private Boolean activo;
    
    /**relaciones**/
    @ManyToOne
    @JoinColumn(name = "oferta_Id",referencedColumnName = "oferta_Id")
    private Ofertas ofertas;
    
    @ManyToOne
    @JoinColumn(name = "tipo_equipamiento_id",referencedColumnName = "tipo_equipamiento_id")
    private TipoEquipamiento tipoequipamiento;
    
    @ManyToOne
    @JoinColumn(name = "equipamiento_condicion_id",referencedColumnName = "equipamiento_condicion_id")
    private EquipamientoCondicion equipamientoCondicion;

    @ManyToOne
    @JoinColumn(name = "equipamiento_marca_id",referencedColumnName = "equipamiento_marca_id")
    private EquipamientoMarca equipamientomarca;
    
    @ManyToOne
    @JoinColumn(name = "moneda_id",referencedColumnName = "moneda_id")
    private Moneda 	moneda;

    
	@Override
	public boolean isIdSet() {
		return this.ofertaCapexId != null;
	}
	
	

}