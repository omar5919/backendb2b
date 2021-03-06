package com.incloud.tgestiona.b2b.model;

import com.incloud.tgestiona.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente", schema = "oferta")
public class Cliente extends BaseDomain implements Identifiable<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id", updatable = false, nullable = false)
    private Integer cliente_id;

    @Column(name = "codigo_isis")
    private String codigoisis;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "numero_identificador_fiscal")
    private String numeroidentificadorfiscal;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "codigo_facturacion")
    private String codigo_facturacion;

    @Column(name = "gerente_cuenta")
    private String gerente_cuenta;
    
    @Column(name = "segmento_negocio")
    private String segmentoNegocio;

    @Column(name = "activo")
    private Boolean activo;
    
    @Override
    public String entityClassName() {
        return Cliente.class.getSimpleName();
    }

    @Override
    public Integer getId() {
        return cliente_id;
    }

    @Override
    public void setId(Integer id) {
        this.cliente_id = id;
    }

    @Override
    public boolean isIdSet() {
        return cliente_id != null;
    }
}