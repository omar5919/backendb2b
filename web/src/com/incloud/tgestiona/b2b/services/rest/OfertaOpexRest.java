package com.incloud.tgestiona.b2b.services.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incloud.tgestiona.b2b.model.Complejidad;
import com.incloud.tgestiona.b2b.model.oferta.OfertasOpex;
import com.incloud.tgestiona.framework.JPACustomRest;


@RestController
@RequestMapping("/api/ofertaopex")
public class OfertaOpexRest extends JPACustomRest<OfertasOpex, Integer>{

}
