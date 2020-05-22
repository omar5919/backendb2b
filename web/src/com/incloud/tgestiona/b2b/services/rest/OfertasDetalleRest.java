package com.incloud.tgestiona.b2b.services.rest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.incloud.tgestiona.b2b.repository.DistritoRepository;
import com.incloud.tgestiona.b2b.repository.OfertasDetalleRepository;
import com.incloud.tgestiona.b2b.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import com.incloud.tgestiona.b2b.model.oferta.OfertasDetalle;
import com.incloud.tgestiona.b2b.serices.OfertasDetalleService;
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

    @Autowired
    private OfertasDetalleRepository odRepo;

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
    public List<Integer> guardarservicios(@RequestBody List<OfertaDetalleDto> servicios) {
        List<Integer> res = new ArrayList<>();
        for (OfertaDetalleDto e: servicios) {
            res.add(odRepo.guardarServicio(
                    e.getIdoferta(),
                    e.getActivo(),
                    e.getId(),
                    e.getSede(),
                    e.getDireccion(),
                    e.getIddistrito(),
                    e.getLat(),
                    e.getLon(),
                    e.getContacto(),
                    e.getTelefono(),
                    e.getIdcircuito(),
                    e.getNcircuito(),
                    e.getIdservicio(),
                    e.getIdmedio(),
                    e.getBw_actual(),
                    e.getLdn_actual(),
                    e.getVoz_actual(),
                    e.getVideo_actual(),
                    e.getPlatinium_actual(),
                    e.getOro_actual(),
                    e.getPlata_actual(),
                    e.getBronce_actual(),
                    e.getEquipo(),
                    e.getRouter(),
                    e.getOtros(),
                    e.getFacturacion(),
                    e.getIdaccionisis(),
                    e.getIdtiposede(),
                    e.getIdmodo(),
                    e.getIdcircuito2(),
                    e.getNcircuito2(),
                    e.getIdservicio2(),
                    e.getIdmedio2(),
                    e.getSva(),
                    e.getSvadescripcion(),
                    e.getBw_propuesto(),
                    e.getLdn_propuesto(),
                    e.getVoz_propuesto(),
                    e.getVideo_propuesto(),
                    e.getPlatinium_propuesto(),
                    e.getOro_propuesto(),
                    e.getPlata_propuesto(),
                    e.getBronce_propuesto(),
                    e.getEquipo2(),
                    e.getRouter2(),
                    e.getOtros2(),
                    e.getPrecio(),
                    e.getObservaciones(),
                    e.getOfertaisis(),
                    e.getSisego(),
                    e.getZona(),
                    e.getUltima(),
                    e.getDias(),
                    e.getUbigeo()
            ));
            System.out.println("");
        }
        return res;
    }
}