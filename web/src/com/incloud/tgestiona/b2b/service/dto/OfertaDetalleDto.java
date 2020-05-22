package com.incloud.tgestiona.b2b.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfertaDetalleDto {
    private Boolean activo;
    private Integer idcliente;
    private Integer id;
    private String sede;
    private String direccion;
    private Integer iddistrito;
    private String lat;
    private String lon;
    private String contacto;
    private String telefono;

    private Integer idcircuito;
    private String ncircuito;
    private Integer idservicio;
    private Integer idmedio;
    private String bw_actual;
    private String ldn_actual;
    private String voz_actual;
    private String video_actual;
    private String platinium_actual;
    private String oro_actual;
    private String plata_actual;
    private String bronce_actual;
    private String equipo;
    private String router;
    private String otros;
    private BigDecimal facturacion;
    private Integer idaccionisis;
    private Integer idtiposede;
    private Integer idmodo;

    private Integer idcircuito2;
    private String ncircuito2;
    private Integer idservicio2;
    private Integer idmedio2;
    private String sva;
    private String svadescripcion;
    private String bw_propuesto;
    private String ldn_propuesto;
    private String voz_propuesto;
    private String video_propuesto;
    private String platinium_propuesto;
    private String oro_propuesto;
    private String plata_propuesto;
    private String bronce_propuesto;
    private String equipo2;
    private String router2;
    private String otros2;
    private BigDecimal precio;
    private String observaciones;
    private String ofertaisis;
    private String sisego;
    private String zona;
    private BigDecimal ultima;
    private Integer dias;
    private String ubigeo;

    private Integer idoferta;

}
