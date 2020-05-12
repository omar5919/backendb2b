package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.model.Usuarios;
import com.incloud.tgestiona.b2b.model.oferta.Ofertas;
import com.incloud.tgestiona.b2b.repository.OfertasRepository;
import com.incloud.tgestiona.b2b.repository.SeguridadRepository;
import com.incloud.tgestiona.b2b.serices.OfertasService;
import com.incloud.tgestiona.b2b.service.dto.BaseBandejaResponse;
import com.incloud.tgestiona.b2b.service.dto.OfertaReq;
import com.incloud.tgestiona.b2b.service.dto.ofertaDto;
import com.incloud.tgestiona.framework.JPACustomRest;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private OfertasRepository oRepo;

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

    @PostMapping("/guardaroferta")
    public int guardarOferta(@RequestBody OfertaReq o) {
        Integer res = oRepo.guardarOferta(o.getPoferta_id(),
                o.getPcliente_id(),
                o.getPoportunidad_id(),
                o.getPcontacto(),
                o.getPtelefono_contacto(),
                o.getPcorreo_contacto(),
                o.getPnumero_caso_salesforce(),
                o.getPdescripcion(),
                o.getPpreventa_id(),
                o.getPtipo_proyecto_id(),
                o.getPcomplejidad_id(),
                o.getPtipo_contrato_id(),
                o.getPtiempo_implantacion(),
                o.getPperiodo_contrato(),
                o.getPmoneda_id(),
                o.getPpago_unico(),
                o.getPpago_recurrente(),
                o.getPpago_recurrente_actual(),
                o.getPobservaciones(),
                o.getPusuario());
        return res;
    }

    @PostMapping("/registraroferta")
    public void registrarOferta(@RequestBody ofertaDto student) {
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