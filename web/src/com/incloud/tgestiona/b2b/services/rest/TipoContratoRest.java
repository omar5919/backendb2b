package com.incloud.tgestiona.b2b.services.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incloud.tgestiona.b2b.model.TipoContrato;
import com.incloud.tgestiona.framework.JPACustomRest;

@RestController
@RequestMapping("/api/tipoContrato")
//@CrossOrigin(origins = "http://localhost:4200")
public class TipoContratoRest extends JPACustomRest<TipoContrato, Integer> {


}