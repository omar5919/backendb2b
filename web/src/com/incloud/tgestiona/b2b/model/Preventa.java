package com.incloud.tgestiona.b2b.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "preventa",schema = "b2b_dev")
public class Preventa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "preventa_id", updatable = false, nullable = false)
    private Integer preventa_id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "activo")
    private boolean activo;


}
