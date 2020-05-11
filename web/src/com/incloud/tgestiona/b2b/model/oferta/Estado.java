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
@Table(name = "estado", schema = "oferta")
public class Estado extends BaseDomain implements Identifiable<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estado_id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "color")
    private String color;

    @Column(name = "orden")
    private Integer orden;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "codigoestado")
    private String codigoEstado;

    @Column(name = "activo")
    private Boolean activo;

    @Override
    public String entityClassName() {
        return Estado.class.getSimpleName();
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean isIdSet() {
        return id != null;
    }
}
