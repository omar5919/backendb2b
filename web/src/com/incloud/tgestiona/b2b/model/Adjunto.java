package com.incloud.tgestiona.b2b.model;


import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.incloud.tgestiona.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import com.google.common.base.MoreObjects;

/**
 * Adjunto Documento
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "adjunto")
public class Adjunto extends BaseDomain implements Identifiable<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adjunto_id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "adjunto_usuario")
    private String adjunto_usuario;

    @Column(name = "archivo_id")
    private String archivo_id;

    @Column(name = "archivo_nombre")
    private String archivo_nombre;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "archivo_tipo")
    private String archivo_tipo;

    @Column(name = "carpeta_id")
    private String carpeta_id;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "ruta_catalogo")
    private String ruta_catalogo;

    @Column(name = "tipo_adjunto")
    private Integer tipo_adjunto;

    @Column(name = "modulo_id")
    private Integer modulo_id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;


    @Override
    public String entityClassName() {
        return Adjunto.class.getSimpleName();
    }

    @Override
    public boolean isIdSet() {
        return id != null;
    }
}
