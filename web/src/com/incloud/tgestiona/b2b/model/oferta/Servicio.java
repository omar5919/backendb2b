package com.incloud.tgestiona.b2b.model.oferta;

import com.incloud.tgestiona.b2b.model.Distrito;
import com.incloud.tgestiona.b2b.model.Identifiable;
import com.incloud.tgestiona.b2b.model.Oportunidad;
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
@Table(name = "servicios", schema = "oferta")
public class Servicio extends BaseDomain implements Identifiable<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "servicio_id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "sede")
    private String sede;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "lon")
    private String lon;

    @Column(name = "lat")
    private String lat;

    @Column(name = "contacto")
    private String contacto;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "circuito")
    private Integer circuito;

    @Column(name = "numero_circuito")
    private Integer numero_circuito;

    @Column(name = "servicio")
    private Integer servicio;

    @Column(name = "medio")
    private Integer medio;

    @Column(name = "bw")
    private Integer bw;

    @Column(name = "bw_value")
    private Integer bw_value;

    @Column(name = "ldn")
    private Integer ldn;

    @Column(name = "voz")
    private Integer voz;

    @Column(name = "voz_value")
    private Integer voz_value;

    @Column(name = "video")
    private Integer video;

    @Column(name = "video_value")
    private Integer video_value;

    @Column(name = "platinium")
    private Integer platinium;

    @Column(name = "platinium_value")
    private Integer platinium_value;

    @Column(name = "oro")
    private Integer oro;

    @Column(name = "oro_value")
    private Integer oro_value;

    @Column(name = "plata")
    private Integer plata;

    @Column(name = "plata_value")
    private Integer plata_value;

    @Column(name = "bronce")
    private Integer bronce;

    @Column(name = "bronce_value")
    private Integer bronce_value;

    @Column(name = "equipo_terminal")
    private String equipo_terminal;

    @Column(name = "router")
    private String router;

    @Column(name = "otros")
    private String otros;

    @Column(name = "facturacion")
    private String facturacion;

    @Column(name = "accion_isis")
    private Integer accion_isis;

    @Column(name = "tipo_sede")
    private Integer tipo_sede;

    @ManyToOne
    @JoinColumn(name = "distrito_id")
    private Distrito distrito;

    @ManyToOne
    @JoinColumn(name = "oferta_id")
    private Ofertas oferta;

    @Override
    public String entityClassName() {
        return Servicio.class.getSimpleName();
    }

    @Override
    public boolean isIdSet() {
        return id != null;
    }
}
