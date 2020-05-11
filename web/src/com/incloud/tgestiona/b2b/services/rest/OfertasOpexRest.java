package com.incloud.tgestiona.b2b.services.rest;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.incloud.tgestiona.b2b.model.oferta.OfertasOpex;
import com.incloud.tgestiona.b2b.serices.OfertasOpexService;
import com.incloud.tgestiona.b2b.service.dto.BaseBandejaResponse;
import com.incloud.tgestiona.b2b.service.dto.OfertasDetalleDto;
import com.incloud.tgestiona.b2b.service.dto.OfertasOpexDto;
import com.incloud.tgestiona.framework.JPACustomRest;


@RestController
@RequestMapping("/api/OfertasOpex")
public class OfertasOpexRest extends JPACustomRest<OfertasOpex, Integer> {


    private final OfertasOpexService oServ;


    public OfertasOpexRest(OfertasOpexService oServ) {
        this.oServ = oServ;
    }


    @GetMapping("/obtenerOfertasOpex")
    //@CrossOrigin(origins = "http://localhost:4200")
    public BaseBandejaResponse<List<OfertasOpexDto>> obtenerOfertasOpex(@RequestParam(required = false) Integer ofertaId,
                                                                        Pageable pageable) throws Exception {
        return oServ.getOfertasOpex(ofertaId, pageable);
    }
}
