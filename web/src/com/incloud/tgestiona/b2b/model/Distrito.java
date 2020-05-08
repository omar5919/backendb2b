package com.incloud.tgestiona.b2b.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "distrito", schema = "oferta")
public class Distrito {

    @Id
    @Column(name = "distrito_id", nullable = false)
    private String distritoId;

    @Column(name = "provincia_id")
    private String provinciaId;

    @Column(name = "departamento_id")
    private String departamentoId;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "activo")
    private Boolean activo;
}
