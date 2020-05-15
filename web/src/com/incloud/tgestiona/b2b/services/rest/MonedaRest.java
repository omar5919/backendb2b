package com.incloud.tgestiona.b2b.services.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incloud.tgestiona.b2b.model.Moneda;
import com.incloud.tgestiona.framework.JPACustomRest;

@RestController
@RequestMapping("/api/moneda")
//@CrossOrigin(origins = "http://localhost:4200")
public class MonedaRest extends JPACustomRest<Moneda, Integer> {

}