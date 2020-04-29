package com.incloud.tgestiona.b2b.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tipo_pago",schema = "b2b_dev")
public class TipoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_pago", updatable = false, nullable = false)
    private Integer tipo_pago;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "activo")
    private boolean activo;


}
