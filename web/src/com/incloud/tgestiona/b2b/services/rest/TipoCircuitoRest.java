package com.incloud.tgestiona.b2b.services.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incloud.tgestiona.b2b.model.TipoCircuito;
import com.incloud.tgestiona.framework.JPACustomRest;

@RestController
@RequestMapping("/api/tipoCircuito")
public class TipoCircuitoRest extends JPACustomRest<TipoCircuito, Integer> {


}