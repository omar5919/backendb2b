package com.incloud.tgestiona.b2b.model.oferta;

import com.incloud.tgestiona.b2b.model.*;
import com.incloud.tgestiona.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ofertas", schema = "oferta")
public class Ofertas extends BaseDomain implements Identifiable<Integer>, Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oferta_id", updatable = false, nullable = false)
    private Integer oferta_id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "version")
    private Integer version;

    @Column(name = "oportunidad")
    private String oportunidadSalesforce;

    @Column(name = "contacto")
    private String contacto;

    @Column(name = "telefono_contacto")
    private String telefono_contacto;

    @Column(name = "correo_contacto")
    private String correo_contacto;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "observaciones", length = 255)
    private String observaciones;

    @Column(name = "periodo_contrato")
    private Integer periodo_contrato;

    @Column(name = "tiempo_implantacion")
    private Integer tiempo_implantacion;

    @Column(name = "pago_unico")
    private BigDecimal pago_unico;

    @Column(name = "pago_recurrente")
    private BigDecimal pago_recurrente;

    @Column(name = "pago_recurrente_actual")
    private BigDecimal pago_recurrente_actual;

    @Column(name = "diferencia_ingresos")
    private BigDecimal diferencia_ingresos;

    @Column(name = "vanvai")
    private BigDecimal vanvai;

    @Column(name = "payback")
    private Integer payback;

    @Column(name = "resultado")
    private String resultado;

    @Column(name = "aprobadores")
    private String aprobadores;

    @Column(name = "fullcontractvalue")
    private BigDecimal fullcontractvalue;

    @Column(name = "opex")
    private BigDecimal opex;

    @Column(name = "capex")
    private BigDecimal capex;

    @Column(name = "fecha_reg")
    private Date fecha_reg;

    @Column(name = "fecha_mod")
    private Date fecha_mod;

	@Column(name = "numero_caso_salesforce" )
	private String numeroCasoSalesforce;
	
	@Column(name = "activo" )
	private Boolean activo;

    /*relaciones**/
	
	@ManyToOne
    @JoinColumn(name = "oportunidad_id")
    private Oportunidad oportunidad;
	
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "complejidad_id")
    private Complejidad complejidad;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "tipo_contrato_id")
    private TipoContrato tipocontrato;

    @ManyToOne
    @JoinColumn(name = "tipo_proyecto_id")
    private TipoProyecto tipoproyecto;

    @ManyToOne
    @JoinColumn(name = "tipo_pago_id", referencedColumnName = "tipo_pago_id")
    private TipoPago tipopago;

    @ManyToOne
    @JoinColumn(name = "analista_financiero_id")
    private AnalistaFinaciero analistafinanciero;

    @ManyToOne
    @JoinColumn(name = "moneda_id")
    private Moneda moneda;

    @ManyToOne
    @JoinColumn(name = "preventa_id")
    private Preventa preventa;

    @Override
    public boolean isIdSet() {
        return oferta_id != null;
    }

	@Override
	public String entityClassName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return oferta_id;
	}

	@Override
	public void setId(Integer id) {
		this.oferta_id=id;
		
	}
}
