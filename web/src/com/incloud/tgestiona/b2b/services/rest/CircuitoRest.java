package com.incloud.tgestiona.b2b.services.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incloud.tgestiona.b2b.model.Circuito; 
import com.incloud.tgestiona.framework.JPACustomRest;

@RestController
@RequestMapping("/api/circuito")
public  class CircuitoRest extends JPACustomRest<Circuito, Integer> {

	
}