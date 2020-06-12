package com.incloud.tgestiona.b2b.model.oferta;

import com.incloud.tgestiona.b2b.model.Identifiable;
import com.incloud.tgestiona.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "motivo_rechazo", schema = "oferta")
public class MotivoRechazo extends BaseDomain implements Identifiable<Integer>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "motivo_rechazo_id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;


    @Override
    public String entityClassName() {
        return MotivoRechazo.class.getSimpleName();
    }

    @Override
    public boolean isIdSet() {
        return id != null;
    }
}
