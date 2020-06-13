package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.model.Complejidad;
import com.incloud.tgestiona.b2b.model.finanza.CostosEspeciales;
import com.incloud.tgestiona.framework.JPACustomRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/costosespeciales")
public class CostosEspecialesRest extends JPACustomRest<CostosEspeciales, Integer> {
}
