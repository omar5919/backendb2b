package com.incloud.tgestiona.b2b.services.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.incloud.tgestiona.b2b.model.isis.Tarifa;
import com.incloud.tgestiona.framework.JPACustomRest;

@RestController
@RequestMapping("/api/IsisTarifa")
public class IsisTarifaRest extends JPACustomRest<Tarifa, Integer> {

}
