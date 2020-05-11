package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.model.Usuarios;
import com.incloud.tgestiona.b2b.repository.ClienteRepository;
import com.incloud.tgestiona.b2b.repository.SeguridadRepository;
import com.incloud.tgestiona.b2b.servicesImpl.AdjuntoServiceImpl;
import com.incloud.tgestiona.b2b.servicesImpl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.incloud.tgestiona.b2b.model.Cliente;
import com.incloud.tgestiona.framework.JPACustomRest;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClientesRest extends JPACustomRest<Cliente, Integer> {

    @Autowired
    private ClienteRepository<Cliente> cRepo;

    @GetMapping("/obtenerclientes")
    public List<Cliente> obtenerClientes(@RequestParam(required = false) String search){

        List<Cliente> res = cRepo.findByDescripcionContainingOrNumeroidentificadorfiscalContainingOrCodigoisisContaining(search,search,search);
        return res;
    }
}