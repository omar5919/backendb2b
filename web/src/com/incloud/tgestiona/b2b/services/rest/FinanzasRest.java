package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.repository.FinanzasRepository;
import com.incloud.tgestiona.b2b.service.dto.finanzas.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/finanzas")
public class FinanzasRest {

    @Autowired
    private FinanzasRepository fRepo;

    @GetMapping("/obtenerflujocaja")
    public List<FlujocajaDto> obtenerFlujo(
            @RequestParam(required = false) Integer ofertaId
    ) {
        List<FlujocajaDto> res = new ArrayList<>();
        List<Object[]> flujocaja_list = fRepo.obtenerFlujoCaja(ofertaId);
        res = flujocaja_list.stream().map(s -> FlujocajaDto.builder()
                .concepto_id((Integer) s[0])
                .periodo((Integer) s[1])
                .anio((Integer) s[2])
                .mes((Integer) s[3])
                .montosoles((BigDecimal) s[4])
                .montodolares((BigDecimal) s[5])
                .nombre((String) s[6])
                .parametros((String) s[7])
                .grupo((Character) s[8])
                .build()
        ).collect(Collectors.toList());
        return res;
    }



    @GetMapping("/obtenermatrizescalamiento")
    public List<MatrizEscalamientoDto> obtenerMatrizEscalamiento(@RequestParam(required = false) Integer oferta_id) {
        List<MatrizEscalamientoDto> res = new ArrayList<>();
        List<Object[]> matriz_list = fRepo.obtenerMatrizEscalamiento();
        res = matriz_list.stream().map(s -> MatrizEscalamientoDto.builder()
                .matriz_escalamiento_id((Integer) s[0])
                .aprobador((String) s[1])
                .fullcontracvalue((BigDecimal) s[2])
                .vanvaimayor((BigDecimal) s[3])
                .vanvaimenor((BigDecimal) s[4])
                .paybackmayor((BigDecimal) s[5])
                .paybackmenor((BigDecimal) s[6])
                .build()
        ).collect(Collectors.toList());
        return res;
    }

    @GetMapping("/obtenerparametros")
    public List<ParametrosDto> obtenerparametros() {
        List<ParametrosDto> res = new ArrayList<>();
        List<Object[]> parametros_list = fRepo.obtenerParametros();
        res = parametros_list.stream().map(s -> ParametrosDto.builder()
                .parametro_id((Integer) s[0])
                .nombre((String) s[1])
                .descripcion((String) s[2])
                .valor((BigDecimal) s[3])
                .build()
        ).collect(Collectors.toList());
        return res;
    }

    @PostMapping("/guardarparametro")
    public Integer guardarparametro(@RequestParam(required = false) Integer parametro_id, @RequestParam(required = false) BigDecimal valor) {
        return fRepo.guardarparametro(parametro_id, valor, 1, "maria.ramos");
    }

    @PostMapping("/guardarparametrooferta")
    public Integer guardarparametrooferta(@RequestBody ParametrosOfertaDto req) {
        return fRepo.guardarparametrooferta(req.getParametro_oferta_id(), req.getOferta_id(), req.getParametro_id(), req.getConcepto_id(), req.getDescripcion(), req.getNombre(), req.getValor(), req.getUsuario_id());
    }

    @GetMapping("/obtenercmi")
    public List<CmiDto> obtenercmi(@RequestParam(required = false) Integer oferta_id) {
        List<CmiDto> res = new ArrayList<>();
        List<Object[]> cmi_list = fRepo.obtenerCmi(oferta_id);
        res = cmi_list.stream().map(s -> CmiDto.builder()
                .linea((String) s[0])
                .sublinea((String) s[1])
                .servicio((String) s[2])
                .producto((String) s[3])
                .porcentaje((BigDecimal) s[4])
                .build()
        ).collect(Collectors.toList());
        return res;
    }

    @PostMapping("/guardarmatrizescalamiento")
    public Integer guardarmatrizescalamiento(@RequestBody(required = false) MatrizEscalamientoDto req) {
        return fRepo.guardarmatrizescalamiento(req.getMatriz_escalamiento_id(),req.getAprobador(),req.getFullcontracvalue(),req.getVanvaimayor(),req.getVanvaimenor(),req.getPaybackmayor(),req.getPaybackmenor(),1);
    }

}
