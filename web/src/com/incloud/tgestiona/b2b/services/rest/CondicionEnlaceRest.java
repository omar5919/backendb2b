package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.model.oferta.Condicionenlace;
import com.incloud.tgestiona.framework.JPACustomRest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/condicionenlace")
//@CrossOrigin(origins = "http://localhost:4200")
public class CondicionEnlaceRest extends JPACustomRest<Condicionenlace,Integer> {
}
