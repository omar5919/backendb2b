package com.incloud.tgestiona.b2b.services.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incloud.tgestiona.b2b.model.ConceptosOpex;
import com.incloud.tgestiona.framework.JPACustomRest;

@RestController
@RequestMapping("/api/ConceptosOpex")
public class ConceptosOpexRest   extends JPACustomRest<ConceptosOpex, Integer>{

}
