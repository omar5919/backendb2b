package com.incloud.tgestiona.b2b.model.finanza;

import com.incloud.tgestiona.b2b.model.Identifiable;
import com.incloud.tgestiona.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "parametro_oferta", schema = "finanzas")
public class ParametroOferta extends BaseDomain implements Identifiable<Integer>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parametro_oferta_id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "oferta_id")
    private Integer oferta_id;

    @Column(name = "concepto_id")
    private Integer concepto_id;

    @Column(name = "parametro_id")
    private Integer parametro_id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "valor")
    private BigDecimal valor;


    @Override
    public String entityClassName() {
        return ParametroOferta.class.getSimpleName();
    }

    @Override
    public boolean isIdSet() {
        return id != null;
    }
}
