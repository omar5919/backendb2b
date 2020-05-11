package com.incloud.tgestiona.b2b.model;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.google.common.base.MoreObjects;
import com.incloud.tgestiona.domain.BaseDomain;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "oportunidad", schema = "oferta")
public class Oportunidad extends BaseDomain implements Identifiable<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oportunidad_id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "fase")
    private String fase;

    @Column(name = "oportunidad_codigo")
    private String oportunidadcodigo;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

    @Override
    public String entityClassName() {
        return Oportunidad.class.getSimpleName();
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
