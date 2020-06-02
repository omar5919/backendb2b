package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.repository.FinanzasRepository;
import com.incloud.tgestiona.b2b.service.dto.finanzas.FlujocajaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    ){
        List<FlujocajaDto> res = new ArrayList<>();
        List<Object[]> flujocaja_list = fRepo.obtenerFlujoCaja(ofertaId);
        res = flujocaja_list.stream().map(s->FlujocajaDto.builder()
                .concepto_id((Integer) s[0])
                .periodo((Integer) s[1])
                .anio((Integer) s[2])
                .mes((Integer) s[3])
                .montosoles((BigDecimal) s[4])
                .montodolares((BigDecimal) s[5])
                .nombre((String) s[6])
                .parametros((String) s[7])
                .build()
        ).collect(Collectors.toList());
        return res;
    }

}
