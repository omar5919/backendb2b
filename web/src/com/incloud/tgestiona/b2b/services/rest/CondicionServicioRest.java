package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.model.CondicionServicio;
import com.incloud.tgestiona.framework.JPACustomRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/condicionservicio")
public class CondicionServicioRest extends JPACustomRest<CondicionServicio, Integer> {
}
