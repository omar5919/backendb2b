package com.incloud.tgestiona.b2b.services.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incloud.tgestiona.b2b.model.MedioAcceso;
import com.incloud.tgestiona.framework.JPACustomRest;


@RestController
@RequestMapping("/api/medioAcceso")
public  class MedioAccesoRest extends JPACustomRest<MedioAcceso, Integer>  {
	 


}