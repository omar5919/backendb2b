package com.incloud.tgestiona.b2b.services.rest.custom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incloud.tgestiona.b2b.services.rest.MonedaRest;

@RestController
@RequestMapping("/api/moneda")
public class MonedaCustomRest extends MonedaRest {

	private final Logger log = LoggerFactory.getLogger(MonedaCustomRest.class);
	
	/*
	 * methods personalize
	 */	
	
}
