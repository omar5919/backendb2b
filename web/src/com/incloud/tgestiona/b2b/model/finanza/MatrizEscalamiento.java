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
@Table(name = "matriz_escalamiento", schema = "finanzas")
public class MatrizEscalamiento extends BaseDomain implements Identifiable<Integer>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matriz_escalamiento_id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "aprobador")
    private String aprobador;

    @Column(name = "fullcontracvalue")
    private BigDecimal fullcontracvalue;

    @Column(name = "vanvaimayor")
    private BigDecimal vanvaimayor;

    @Column(name = "vanvaimenor")
    private BigDecimal vanvaimenor;

    @Column(name = "paybackmayor")
    private BigDecimal paybackmayor;

    @Column(name = "paybackmenor")
    private BigDecimal paybackmenor;


    @Override
    public String entityClassName() {
        return MatrizEscalamiento.class.getSimpleName();
    }

    @Override
    public boolean isIdSet() {
        return id != null;
    }
}
