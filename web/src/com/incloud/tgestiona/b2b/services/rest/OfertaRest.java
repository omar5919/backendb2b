package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.model.Usuarios;
import com.incloud.tgestiona.b2b.model.oferta.Ofertas;
import com.incloud.tgestiona.b2b.repository.OfertasRepository;
import com.incloud.tgestiona.b2b.repository.SeguridadRepository;
import com.incloud.tgestiona.b2b.serices.OfertasService;
import com.incloud.tgestiona.b2b.service.dto.BaseBandejaResponse;
import com.incloud.tgestiona.b2b.service.dto.OfertaReq;
import com.incloud.tgestiona.b2b.service.dto.distritoDto;
import com.incloud.tgestiona.b2b.service.dto.ofertaDto;
import com.incloud.tgestiona.framework.JPACustomRest;
import org.hibernate.jpa.TypedParameterValue;
import org.hibernate.type.ShortType;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    public BaseBandejaResponse<List<ofertaDto>> obtenerOfertas(
            @RequestParam(required = false) Integer usuarioid,
            @RequestParam(required = false) Boolean visualizartodo,
            @RequestParam(required = false) String codoportunidad,
            @RequestParam(required = false) String cliente,
            @RequestParam(required = false) String descripcion,
            @RequestParam(required = false) Integer complejidad,
            @RequestParam(required = false) Integer estado,
            @RequestParam(required = false) @DateTimeFormat(pattern = DATE_PATTERN) Date desde,
            @RequestParam(required = false) @DateTimeFormat(pattern = DATE_PATTERN) Date hasta,
            Pageable p) throws Exception {
        Query query = entityManager.createNativeQuery("select * from oferta.sp_obtener_ofertas(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11);")
                .setParameter(1, new TypedParameterValue(StandardBasicTypes.INTEGER, usuarioid))
                .setParameter(2, new TypedParameterValue(StandardBasicTypes.BOOLEAN, visualizartodo))
                .setParameter(3, new TypedParameterValue(StandardBasicTypes.STRING, codoportunidad))
                .setParameter(4, new TypedParameterValue(StandardBasicTypes.STRING, cliente))
                .setParameter(5, new TypedParameterValue(StandardBasicTypes.STRING, descripcion))
                .setParameter(6, new TypedParameterValue(StandardBasicTypes.INTEGER, complejidad))
                .setParameter(7, new TypedParameterValue(StandardBasicTypes.INTEGER, estado))
                .setParameter(8, desde, TemporalType.TIMESTAMP)
                .setParameter(9, hasta, TemporalType.TIMESTAMP)
                .setParameter(10, p.getPageNumber())
                .setParameter(11, p.getPageSize());
        List<Object[]> res = (List<Object[]>) query.getResultList();
        BaseBandejaResponse<List<ofertaDto>> oDto = new BaseBandejaResponse<>();
        oDto.setMsj("200");
        oDto.setRows(res.size() > 0 ? Long.parseLong(res.get(0)[16].toString()) : 0);
        List<ofertaDto> ol = res.stream().map(s ->
                ofertaDto.builder()
                        .id(Long.parseLong(s[0].toString()))
                        .codigo((String) s[1])
                        .color((String) s[2])
                        .observaciones((String) s[3])
                        .complejidad((String) s[4])
                        .preventa((String) s[5])
                        .analistafinanciero((String) s[6])
                        .version((Integer) s[7])
                        .fase((String) s[8])
                        .oportunidad((String) s[9])
                        .cliente((String) s[10])
                        .descripcion((String) s[11])
                        .estado((String) s[12])
                        .tipoproyecto((String) s[13])
                        .fechareg((Date) s[14])
                        .fechamod((Date) s[15])
                        .build()
        ).collect(Collectors.toList());
        oDto.setData(ol);
        return oDto;
    }

    @PostMapping("/guardaroferta")
    public int guardarOferta(@RequestBody OfertaReq o) {
        Integer res = oRepo.guardarOferta(
                o.getPoferta_id(),
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

    @PostMapping("/_derivaroferta")
    public String derivarOferta(@RequestParam(required = false) Integer ofertaId,
                                @RequestParam(required = false) Integer usuarioId
    ) {
        //PASAR A ESTADO 'DERIVADO A AF'
        return this.oServ.derivarOferta(ofertaId, usuarioId, 3, null, 0);
    }

    @PostMapping("/_asignaraf")
    public String asignaraf(@RequestParam(required = false) Integer ofertaId,
                            @RequestParam(required = false) Integer usuarioId,
                            @RequestParam(required = false) Integer analistafinancieroId) {
        //PASAR A ESADO 'ANALISIS FINACIERO'
        return this.oServ.derivarOferta(ofertaId, usuarioId, 4, analistafinancieroId, 0);
    }

    @PostMapping("/_aprobadoaf")
    public String aprobadoaf(@RequestParam(required = false) Integer ofertaId,
                             @RequestParam(required = false) Integer usuarioId)
    {
        //PASAR A ESTADO APROBADO AF
        return this.oServ.derivarOferta(ofertaId, usuarioId, 5, null, 0);
    }

    @PostMapping("/_rechazadoaf")
    public String rechazadoaf(@RequestParam(required = false) Integer ofertaId,
                              @RequestParam(required = false) Integer usuarioId,
                              @RequestParam(required = false) Integer motivoid) {
        //RECHAZADO
        //MOTIVO DE RECHAZO
        //TABLA DE MOTIVO DE RECHAZO LISTAR LOS REGISTROS
        return this.oServ.derivarOferta(ofertaId, usuarioId, 8, null, motivoid);
    }

    @PostMapping("/_estadonuevo")
    public String estadonuevo(@RequestParam(required = false) Integer ofertaId,
                              @RequestParam(required = false) Integer usuarioId) {
        //RECHAZADO
        //MOTIVO DE RECHAZO
        //TABLA DE MOTIVO DE RECHAZO LISTAR LOS REGISTROS
        return this.oServ.derivarOferta(ofertaId, usuarioId, 9, null, 0);
    }

    //finanzas costo especial

}