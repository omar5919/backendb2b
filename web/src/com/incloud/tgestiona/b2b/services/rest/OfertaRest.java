package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.model.oferta.Ofertas;
import com.incloud.tgestiona.b2b.serices.OfertasService;
import com.incloud.tgestiona.b2b.service.dto.BaseBandejaResponse;
import com.incloud.tgestiona.b2b.service.dto.ofertaDto;
import com.incloud.tgestiona.framework.JPACustomRest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/oferta")
//@CrossOrigin(origins = "http://localhost:4200")
public class OfertaRest extends JPACustomRest<Ofertas, Integer> {

    private static final String DATE_PATTERN = "yyyy/MM/dd";

    private final OfertasService oServ;


    public OfertaRest(OfertasService oServ) {
        this.oServ = oServ;
    }

    @GetMapping("/obtenerofertas")
    public BaseBandejaResponse<List<ofertaDto>> obtenerofertas(@RequestParam(required = false) String codoportunidad,
                                                               @RequestParam(required = false) String cliente,
                                                               @RequestParam(required = false) String descripcion,
                                                               @RequestParam(required = false) Integer complejidad,
                                                               @RequestParam(required = false) Integer estado,
                                                               @RequestParam(required = false) @DateTimeFormat(pattern = DATE_PATTERN) Date desde,
                                                               @RequestParam(required = false) @DateTimeFormat(pattern = DATE_PATTERN) Date hasta,
                                                               Pageable pageable) throws Exception {
        return oServ.getOfertas(codoportunidad, cliente, descripcion, complejidad, estado, desde, hasta, pageable);
    }

    @PostMapping("/registraroferta")
    public void addStudent(@RequestBody ofertaDto student) {
        oServ.addOferta(student);
    }

    @PostMapping("/copiaroferta")
    public int CopiarOferta(@RequestParam(required = false) int ofertaId,
                            @RequestParam(required = false) int usuarioId,
                            @RequestParam(required = false) String usuario) {

        return oServ.copiarOferta(ofertaId, usuarioId, usuario);

    }

    @PostMapping("/anularoferta")
    public int AnularOferta(@RequestParam(required = false) int ofertaId,
                            @RequestParam(required = false) int usuarioId,
                            @RequestParam(required = false) String usuario) {
        int respuesta = oServ.anularOferta(ofertaId, usuarioId, usuario);
        return respuesta;

    }

    @PostMapping("/versionaroferta")
    public int versionarOferta(@RequestParam(required = false) int ofertaId,
                               @RequestParam(required = false) int usuarioId,
                               @RequestParam(required = false) String usuario) {

        return oServ.versionarOferta(ofertaId, usuarioId, usuario);

    }

    @PostMapping("/ganaroferta")
    public int ganarOferta(@RequestParam(required = false) int ofertaId,
                           @RequestParam(required = false) int usuarioId,
                           @RequestParam(required = false) String usuario) {
        return this.oServ.ganarOferta(ofertaId, usuarioId, usuario);
    }

}