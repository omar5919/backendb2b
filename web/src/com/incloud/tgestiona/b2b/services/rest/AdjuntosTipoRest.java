package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.model.AdjuntoTipo;
import com.incloud.tgestiona.framework.JPACustomRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tipoadjuntos")
public class AdjuntosTipoRest extends JPACustomRest<AdjuntoTipo, Integer> {
}
