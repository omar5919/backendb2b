package com.incloud.tgestiona.b2b.services.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incloud.tgestiona.b2b.model.Sisego;
import com.incloud.tgestiona.framework.JPACustomRest;

@RestController
@RequestMapping("/api/sisego")
public class SisegoRest extends JPACustomRest<Sisego, Integer> {

}