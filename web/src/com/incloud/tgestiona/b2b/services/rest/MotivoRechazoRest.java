package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.model.oferta.MotivoRechazo;
import com.incloud.tgestiona.framework.JPACustomRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/motivorechazo")
public class MotivoRechazoRest extends JPACustomRest<MotivoRechazo, Integer> {
}