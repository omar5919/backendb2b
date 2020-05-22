package com.incloud.tgestiona.b2b.services.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
class WelcomeRest {

	@RequestMapping("/")
	String home() {
		return "*********** ONLINE ***********";
	}

}