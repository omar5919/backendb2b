package com.incloud.tgestiona.b2b.model;

import com.incloud.tgestiona.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "condicion_servicio", schema = "oferta")
public class CondicionServicio extends BaseDomain implements Identifiable<Integer>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "condicion_servicio_id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;


    @Override
    public String entityClassName() {
        return CondicionServicio.class.getSimpleName();
    }

    @Override
    public boolean isIdSet() {
        return id != null;
    }
}
