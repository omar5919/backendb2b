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
@Table(name = "tipo_enlace", schema = "oferta")
public class Tipoenlace extends BaseDomain implements Identifiable<Integer>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_enlace_id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "activo")
    private boolean activo;


    @Override
    public String entityClassName() {
        return Tipoenlace.class.getSimpleName();
    }

    @Override
    public boolean isIdSet() {
        return id != null;
    }
}
