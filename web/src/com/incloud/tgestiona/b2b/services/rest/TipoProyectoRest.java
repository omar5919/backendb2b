package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.model.TipoProyecto;
import com.incloud.tgestiona.framework.JPACustomRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tipoproyecto")
public class TipoProyectoRest extends JPACustomRest<TipoProyecto, Integer> {

}
