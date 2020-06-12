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
@Table(name = "costosespeciales", schema = "finanzas")
public class CostosEspeciales extends BaseDomain implements Identifiable<Integer>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "costos_especiales", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "costo")
    private BigDecimal costo;

    @Column(name = "activo")
    private Boolean activo;

    @Column(name = "grupo_satelital")
    private Integer grupo_satelital;


    @Override
    public String entityClassName() {
        return CostosEspeciales.class.getSimpleName();
    }

    @Override
    public boolean isIdSet() {
        return id != null;
    }
}
