package com.incloud.tgestiona.b2b.model.oferta;

import com.incloud.tgestiona.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estado",schema = "oferta")
public class Estado extends BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estado_id", updatable = false, nullable = false)
    private Integer estado_id;

    @Column(name = "codigo_estado")
    private String codigo_estado;

    @Column(name = "color")
    private String color;

    @Column(name = "descripcion")
    private String descripcion;

    @Override
    public boolean isIdSet() {
        return estado_id != null;
    }
}
