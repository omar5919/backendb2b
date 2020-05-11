package com.incloud.tgestiona.b2b.services.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incloud.tgestiona.b2b.model.Distrito;
import com.incloud.tgestiona.framework.JPACustomRest;


@RestController
@RequestMapping("/api/Distrito")
public class DistritoRest  extends JPACustomRest<Distrito, Integer> {

}
 