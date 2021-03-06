package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.model.Adjunto;
import com.incloud.tgestiona.framework.JPACustomRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/adjuntos")
public class AdjuntosRest extends JPACustomRest<Adjunto, Integer> {
}
