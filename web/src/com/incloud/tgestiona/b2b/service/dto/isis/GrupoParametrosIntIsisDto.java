package com.incloud.tgestiona.b2b.service.dto.isis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GrupoParametrosIntIsisDto {
    private String numero_proyecto_isis;
    private String version_oferta;
    private Integer cantidad;
    private Integer sec_grupo;
    private String grupo;
    private Integer sec_direccion;
    private String direccion;
    private Integer sec_producto;
    private String producto;
    private String tipo_ambito;
    private String servicio;
    private String tipo_servicio;
    private String accion;
    private String acceso;
    private String via_acceso;
    private String caudal_ldn;
    private String voz;
    private String video;
    private String platinum;
    private String plata;
    private String bronce;
    private String tipo_cd;
}