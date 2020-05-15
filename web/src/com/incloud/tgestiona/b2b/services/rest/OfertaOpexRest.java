package com.incloud.tgestiona.b2b.services.rest;
import com.incloud.tgestiona.b2b.repository.OfertasCapexRepository;
import com.incloud.tgestiona.b2b.repository.OfertasOpexRepository;
import com.incloud.tgestiona.b2b.serices.OfertasOpexService;
import com.incloud.tgestiona.b2b.service.dto.BaseBandejaResponse;
import com.incloud.tgestiona.b2b.service.dto.OfertasCapexDto;
import com.incloud.tgestiona.b2b.service.dto.OfertasOpexDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.incloud.tgestiona.b2b.model.Complejidad;
import com.incloud.tgestiona.b2b.model.oferta.OfertasOpex;
import com.incloud.tgestiona.framework.JPACustomRest;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api/ofertaopex")
//@CrossOrigin(origins = "http://localhost:4200")
public class OfertaOpexRest extends JPACustomRest<OfertasOpex, Integer>{
    private final Logger log = LoggerFactory.getLogger(AppProcesoLogRest.class);
    private final OfertasOpexService oServ;
    public OfertaOpexRest(OfertasOpexService oServ) {
        this.oServ = oServ;
    }

    @Autowired
    private OfertasOpexRepository oRepo;

    @PostMapping("/guardargastos")
    public List<Integer> guardargastos(@RequestBody List<OfertasOpexDto> gastos){
        List<Integer> res = new ArrayList<>();
        for (OfertasOpexDto e: gastos) {
            res.add(oRepo.guardarOpex(
                    e.getId(),
                    e.getActivo(),
                    e.getCantidad(),
                    e.getFactor(),
                    e.getMeses(),
                    e.getNombre(),
                    e.getTotalMensual(),
                    e.getUnitarioMensual(),
                    e.getConceptoId(),
                    e.getMoneda_id(),
                    e.getOfertaId()
            ));
            log.info(String.format("ok"));
        }
        return res;
    }

    @GetMapping("/obtenerOfertasOpex")
    public BaseBandejaResponse<List<OfertasOpexDto>> obtenerOfertasOpex(
            @RequestParam(required = false) Integer ofertaId,
            Pageable pageable) throws Exception {
        return oServ.getOfertasOpex(ofertaId, pageable);
    }


}
