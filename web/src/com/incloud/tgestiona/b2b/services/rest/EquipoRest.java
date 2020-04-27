package com.incloud.tgestiona.b2b.services.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incloud.tgestiona.b2b.model.isis.Equipo;
import com.incloud.tgestiona.framework.JPACustomRest;

@RestController
@RequestMapping("/api/equipo")
public class EquipoRest extends JPACustomRest<Equipo, Integer> {

}