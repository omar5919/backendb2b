package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.repository.OfertasCapexRepository;
import com.incloud.tgestiona.b2b.repository.OfertasRepository;
import com.incloud.tgestiona.b2b.service.dto.OfertasCapexDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.incloud.tgestiona.b2b.model.Complejidad;
import com.incloud.tgestiona.b2b.model.oferta.OfertasCapex;
import com.incloud.tgestiona.framework.JPACustomRest;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/ofertacapex")
//@CrossOrigin(origins = "http://localhost:4200")
public class OfertaCapexRest  extends JPACustomRest<OfertasCapex, Integer> {

    @Autowired
    private OfertasCapexRepository oRepo;

    @PostMapping("/guardarequipamientos")
    public List<Integer> guardarequipamientos(@RequestBody List<OfertasCapexDto> equipamientos){
        List<Integer> res = new ArrayList<>();
        for (OfertasCapexDto e: equipamientos) {
            res.add(oRepo.guardarCapex(
                    e.getId(),
                    e.getActivo(),
                    e.getAntiguedad(),
                    e.getCantidad(),
                    e.getModelo(),
                    e.getTotal(),
                    e.getUnitario(),
                    e.getCondicion(),
                    e.getMarca(),
                    e.getMoneda(),
                    e.getTipo(),
                    e.getIdoferta(),
                    e.getProveedor(),
                    e.getInstalacion()
            ));
        }
        return res;
    }
}
