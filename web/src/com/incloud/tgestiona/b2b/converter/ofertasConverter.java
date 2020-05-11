package com.incloud.tgestiona.b2b.converter;

import com.incloud.tgestiona.b2b.model.oferta.Ofertas;
import com.incloud.tgestiona.b2b.service.dto.BaseBandejaResponse;
import com.incloud.tgestiona.b2b.service.dto.ofertaDto;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ofertasConverter {
    public static BaseBandejaResponse<List<ofertaDto>> convertToOfertaDTO(List<Ofertas> oList,Long total) {
        BaseBandejaResponse<List<ofertaDto>> oDto = new BaseBandejaResponse<>();
        oDto.setMsj("200");
        oDto.setRows(total);
        List<ofertaDto> ol = oList.stream().map(s ->
                ofertaDto.builder()
                        .id(s.getOferta_id())
                        .codigo(s.getCodigo())
                        .color(s.getEstado().getColor())
                        .observaciones(s.getObservaciones())
                        .complejidad(s.getComplejidad().getDescripcion())
                        .preventa(s.getPreventa().getNombre())
                        .analistafinanciero(s.getAnalistafinanciero().getNombre())
                        .version(s.getVersion())
                        .fase(s.getOportunidad().getFase())
                        .oportunidad(s.getOportunidad().getOportunidadcodigo())
                        .cliente(s.getCliente().getDescripcion())
                        .descripcion(s.getDescripcion())
                        .estado(s.getEstado().getDescripcion())
                        .tipoproyecto(s.getTipoproyecto().getDescripcion())
                        .fechareg(s.getFecha_reg())
                        .fechamod(s.getFecha_mod())
                        .build()
        ).collect(Collectors.toList());
        oDto.setData(ol);
        return oDto;
    }

    public static Ofertas convertToOferta(ofertaDto o) {
        Ofertas om = new Ofertas();
        om.setCodigo(o.getCodigo());
        om.setFecha_reg(o.getFechareg());
        om.setDescripcion(o.getDescripcion());
        return om;
    }
}
