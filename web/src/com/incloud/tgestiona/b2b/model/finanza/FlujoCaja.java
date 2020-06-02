package com.incloud.tgestiona.b2b.model.finanza;

import com.incloud.tgestiona.b2b.model.Identifiable;
import com.incloud.tgestiona.b2b.model.Oportunidad;
import com.incloud.tgestiona.b2b.model.oferta.Ofertas;
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
@Table(name = "flujocaja", schema = "finanzas")
public class FlujoCaja extends BaseDomain implements Identifiable<Integer>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flujo_caja_id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "oferta_id")
    private Integer oferta_id;

    @Column(name = "concepto_id")
    private Integer concepto_id;

    @Column(name = "periodo")
    private Integer periodo;

    @Column(name = "anio")
    private Integer anio;

    @Column(name = "mes")
    private Integer mes;

    @Column(name = "montosoles")
    private BigDecimal montosoles;

    @Column(name = "montodolares")
    private BigDecimal montodolares;

    @Override
    public String entityClassName() {
        return FlujoCaja.class.getSimpleName();
    }

    @Override
    public boolean isIdSet() {
        return id != null;
    }
}
