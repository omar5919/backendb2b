package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.model.oferta.MedioAcceso;
import com.incloud.tgestiona.framework.JPACustomRest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medioacceso")
//@CrossOrigin(origins = "http://localhost:4200")
public class MedioAccesoRest extends JPACustomRest<MedioAcceso,Integer> {

}
