package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.model.oferta.Tipoenlace;
import com.incloud.tgestiona.framework.JPACustomRest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tipoenlace")
//@CrossOrigin(origins = "http://localhost:4200")
public class TipoEnlaceRest extends JPACustomRest<Tipoenlace,Integer> {
}
