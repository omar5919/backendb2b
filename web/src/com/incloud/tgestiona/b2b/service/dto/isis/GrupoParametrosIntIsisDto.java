package com.incloud.tgestiona.b2b.service.dto.isis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GrupoParametrosIntIsisDto {
    private String proyecto;
    private String version;
    private Integer cantidad;
    private Integer sec_grupo;
    private String grupo;
    private Integer sec_direccion;
    private String direccion;
    private Integer sec_prod;
    private String cod_prod;
    
    private String tipo_servicio;///ambito
    
    private String servicio;
    private String tipo_de_servicio;
    private String accion_isis;
    private String bw;
    private String medio_acceso;
    private String caudal_ldn;
    private String caudal_voz;
    private String caudal_video;
    private String caudal_platinum;
    private String caudal_oro;
    private String caudal_plata;
    private String caudal_bronce;
    private String tipo_de_cd;
}