package com.incloud.tgestiona.b2b.services.rest;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.incloud.tgestiona.b2b.model.oferta.OfertasDetalle;
import com.incloud.tgestiona.b2b.serices.OfertasDetalleService;
import com.incloud.tgestiona.b2b.service.dto.BaseBandejaResponse;
import com.incloud.tgestiona.b2b.service.dto.OfertasDetalleDto;
import com.incloud.tgestiona.b2b.service.dto.ofertaDto;
import com.incloud.tgestiona.framework.JPACustomRest;

@RestController
@RequestMapping("/api/ofertasDetalle")
public class OfertasDetalleRest extends JPACustomRest<OfertasDetalle, Integer> {


    private final OfertasDetalleService oServ;


    public OfertasDetalleRest(OfertasDetalleService oServ) {
        this.oServ = oServ;
    }

    @GetMapping("/obtenerOfertasDetalle")
    //@CrossOrigin(origins = "http://localhost:4200")
    public BaseBandejaResponse<List<OfertasDetalleDto>> obtenerOfertasDetalle(@RequestParam(required = false) Integer ofertaId,
                                                                              Pageable pageable) throws Exception {
        return oServ.getOfertasDetalle(ofertaId, pageable);
    }
}