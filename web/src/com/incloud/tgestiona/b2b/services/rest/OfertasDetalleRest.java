package com.incloud.tgestiona.b2b.services.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.incloud.tgestiona.b2b.repository.DistritoRepository;
import com.incloud.tgestiona.b2b.service.dto.distritoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import com.incloud.tgestiona.b2b.model.oferta.OfertasDetalle;
import com.incloud.tgestiona.b2b.serices.OfertasDetalleService;
import com.incloud.tgestiona.b2b.service.dto.BaseBandejaResponse;
import com.incloud.tgestiona.b2b.service.dto.OfertasDetalleDto;
import com.incloud.tgestiona.b2b.service.dto.ofertaDto;
import com.incloud.tgestiona.framework.JPACustomRest;

@RestController
@RequestMapping("/api/ofertasDetalle")
//@CrossOrigin(origins = "http://localhost:4200")
public class OfertasDetalleRest extends JPACustomRest<OfertasDetalle, Integer> {

    private final OfertasDetalleService oServ;
    public OfertasDetalleRest(OfertasDetalleService oServ) {
        this.oServ = oServ;
    }

    @Autowired
    private DistritoRepository dRepo;

    @GetMapping("/obtenerOfertasDetalle")
    public BaseBandejaResponse<List<OfertasDetalleDto>> obtenerOfertasDetalle(@RequestParam(required = false) Integer ofertaId,
                                                                              Pageable pageable) throws Exception {
        return oServ.getOfertasDetalle(ofertaId, pageable);
    }

    @GetMapping("/buscardistrito")
    public List<distritoDto> buscardistrito(@RequestParam(required = false) String search, Pageable pageable) {

        List<distritoDto> res =new ArrayList<>();
        List<Object[]> distritos = dRepo.buscarDistrito(search);
        for (Object[] obj : distritos ) {
            res.add(new distritoDto((Integer)obj[0],(Integer)obj[1],(Integer)obj[2],(String) obj[3]));
        }

        return res;
    }

    @PostMapping("/guardarservicios")
    public int guardarservicios(@RequestBody List<OfertasDetalle> servicioslist) {
        return 0;
    }

}