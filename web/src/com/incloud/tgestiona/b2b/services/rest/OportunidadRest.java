package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.model.Cliente;
import com.incloud.tgestiona.b2b.repository.ClienteRepository;
import com.incloud.tgestiona.b2b.repository.OportunidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.incloud.tgestiona.b2b.model.Oportunidad;
import com.incloud.tgestiona.framework.JPACustomRest;

import java.util.List;

@RestController
@RequestMapping("/api/oportunidad")
public class OportunidadRest extends JPACustomRest<Oportunidad, Integer> {

    @Autowired
    private OportunidadRepository<Oportunidad> oRepo;

    @GetMapping("/obteneroportunidad")
    public List<Oportunidad> obtenerOportunidades(@RequestParam(required = false) String search){
        return oRepo.findByOportunidadcodigoContaining(search);
    }
}