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
@Table(name = "medio_acceso", schema = "oferta")
public class MedioAcceso extends BaseDomain implements Identifiable<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medio_acceso_id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;

    @Override
    public String entityClassName() {
        return MedioAcceso.class.getSimpleName();
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id=id;
    }

    @Override
    public boolean isIdSet() {
        return id != null;
    }
}
