package com.incloud.tgestiona.b2b.model;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Logger;

import javax.persistence.*;

import com.incloud.tgestiona.b2b.model.oferta.Estado;
import com.incloud.tgestiona.b2b.model.oferta.Ofertas;
import com.incloud.tgestiona.domain.BaseDomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bitacora", schema = "oferta")
public class Bitacora extends BaseDomain implements Identifiable<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bitacora_id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "usuario")
    private String nombreUsuario;

    @Column(name = "fecha")
    private String fecha;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "oferta_id")
    private Ofertas ofertas;

    @Override
    public String entityClassName() {
        return Bitacora.class.getSimpleName();
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