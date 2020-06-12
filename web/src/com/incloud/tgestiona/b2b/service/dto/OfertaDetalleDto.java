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
    private Integer dte_actual;//INI NUEVAS COLUMNAS
    private String recurso_transporte_actual;
    private String tipo_antena_actual;
    private Integer segmento_satelital_actual;
    private String pozo_tierra_actual;
    private String ups_actual;
    private String vrf_actual;//FIN NUEVAS COLUMNAS
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
    private Integer condicion_servicio;
    private Date fecha_llegada_propuesto;//INI NUEVAS COLUMNAS
    private String componentes_propuesto;
    private String vrf_propuesto;
    private String detalle_accion_propuesto;//FIN NUEVAS COLUMNAS
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

    private BigDecimal transmision;
    private BigDecimal planta_externa;
    private Integer residual_antig;
    private BigDecimal residual_antig_costo;

    private Integer idoferta;

}
