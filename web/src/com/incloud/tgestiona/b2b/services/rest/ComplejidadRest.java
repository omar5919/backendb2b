package com.incloud.tgestiona.b2b.services.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incloud.tgestiona.b2b.model.Complejidad;
import com.incloud.tgestiona.framework.JPACustomRest;

@RestController
@RequestMapping("/api/complejidad")
//@CrossOrigin(origins = "http://localhost:4200")
public class ComplejidadRest extends JPACustomRest<Complejidad, Integer> {

}