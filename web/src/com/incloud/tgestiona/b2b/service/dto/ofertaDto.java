package com.incloud.tgestiona.b2b.service.dto;

import lombok.*;

import java.util.Date;

@Builder
@Getter
public class ofertaDto {
    private long id;
    private String codigo;
    private Integer version;
    private String oportunidad;
    private String cliente;
    private String descripcion;
    private String observaciones;
    private String complejidad;
    private String preventa;
    private String analistafinanciero;
    private String estado;
    private String tipoproyecto;
    private String fase;
    private String color;
    private Date fechareg;
    private Date fechamod;
}
