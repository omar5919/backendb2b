package com.incloud.tgestiona.b2b.converter;

import com.incloud.tgestiona.b2b.model.oferta.Ofertas;
import com.incloud.tgestiona.b2b.service.dto.ofertaDto;

import java.util.List;
import java.util.stream.Collectors;

public class ofertasConverter {
    public static List<ofertaDto> convertToOfertaDTO(List<Ofertas> oList) {
        return oList.stream().map(s ->
                ofertaDto.builder()
                        .id(s.getOferta_id())
                        .codigo(s.getCodigo())
                        .version(s.getVersion())
                        .oportunidad(s.getOportunidad())
                        .cliente(s.getCliente_id().getDescripcion())
                        .descripcion(s.getDescripcion())
                        .estado(s.getEstado().getDescripcion())
                        .tipoproyecto(s.getTipoproyecto().getDescripcion())
                        .fechareg(s.getFecha_reg())
                        .build()
        ).collect(Collectors.toList());
    }

    public static Ofertas convertToOferta(ofertaDto o) {
        Ofertas om = new Ofertas();
        om.setCodigo(o.getCodigo());
        om.setFecha_reg(o.getFechareg());
        om.setDescripcion(o.getDescripcion());
        return om;
    }
}
