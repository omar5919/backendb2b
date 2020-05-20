package com.incloud.tgestiona.b2b.services.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incloud.tgestiona.b2b.model.EquipamientoCondicion;
import com.incloud.tgestiona.framework.JPACustomRest;

 
@RestController
@RequestMapping("/api/EquipamientoCondicion")
//@CrossOrigin(origins = "http://localhost:4200")
public class EquipamientoCondicionRest  extends JPACustomRest<EquipamientoCondicion, Integer> {

}
 