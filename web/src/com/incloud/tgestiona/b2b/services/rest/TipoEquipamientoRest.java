package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.model.TipoEquipamiento;
import com.incloud.tgestiona.framework.JPACustomRest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tipoequipamiento")
//@CrossOrigin(origins = "http://localhost:4200")
public class TipoEquipamientoRest extends JPACustomRest<TipoEquipamiento,Integer> {

}
