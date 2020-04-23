package com.incloud.tgestiona.b2b.services.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incloud.tgestiona.b2b.model.Estado;

import com.incloud.tgestiona.framework.JPACustomRest;

@RestController
@RequestMapping("/api/estadoRest")
public class EstadoRest extends JPACustomRest<Estado, Integer> {



}