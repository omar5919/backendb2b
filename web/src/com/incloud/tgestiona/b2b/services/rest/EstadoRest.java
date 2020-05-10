package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.model.oferta.Estado;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incloud.tgestiona.b2b.model.*;

import com.incloud.tgestiona.framework.JPACustomRest;

@RestController
@RequestMapping("/api/estadoRest")
//@CrossOrigin(origins = "http://localhost:4200")
public class EstadoRest extends JPACustomRest<Estado, Integer> {

}