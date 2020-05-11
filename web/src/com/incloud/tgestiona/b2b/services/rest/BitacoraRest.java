package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.model.Bitacora;
import com.incloud.tgestiona.framework.JPACustomRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bitacora")
//@CrossOrigin(origins = "http://localhost:4200")
public class BitacoraRest extends JPACustomRest<Bitacora, Integer> {

}
