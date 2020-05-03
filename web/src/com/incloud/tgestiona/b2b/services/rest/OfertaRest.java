package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.model.oferta.Ofertas;
import com.incloud.tgestiona.b2b.serices.OfertasService;
import com.incloud.tgestiona.b2b.service.dto.ofertaDto;
import com.incloud.tgestiona.framework.JPACustomRest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/oferta")
public class OfertaRest extends JPACustomRest<Ofertas, Integer> {

    private static final String DATE_PATTERN = "yyyy/MM/dd";
    private final OfertasService oServ;

    public OfertaRest(OfertasService oServ) {
        this.oServ = oServ;
    }

    @GetMapping("/obtenerofertas")
    public List<ofertaDto> getStudents(@RequestParam(required = false) String codoportunidad,
                                       @RequestParam(required = false) Integer cliente,
                                       @RequestParam(required = false) String descripcion,
                                       @RequestParam(required = false) String complejidad,
                                       @RequestParam(required = false) Integer estado,
                                       @RequestParam(required = false) @DateTimeFormat(pattern = DATE_PATTERN) Date desde,
                                       @RequestParam(required = false) @DateTimeFormat(pattern = DATE_PATTERN) Date hasta,
                                       Pageable pageable) throws Exception{
        return oServ.getOfertas(desde, hasta, descripcion, pageable);
    }

    @PostMapping("/registraroferta")
    public void addStudent(@RequestBody ofertaDto student) {
        oServ.addOferta(student);
    }

}