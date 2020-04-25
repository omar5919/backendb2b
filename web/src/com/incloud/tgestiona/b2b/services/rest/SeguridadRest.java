package com.incloud.tgestiona.b2b.services.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.incloud.tgestiona.b2b.model.Usuarios;
import com.incloud.tgestiona.b2b.servicesImpl.SeguridadServiceImpl;
import com.incloud.tgestiona.framework.BindingErrorsResponse;
import com.incloud.tgestiona.framework.JPACustomRest;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/seguridad")
public class SeguridadRest extends JPACustomRest<Usuarios, Integer> {

	private final Logger log = LoggerFactory.getLogger(OfertaRest.class);

	@Autowired
	protected SeguridadServiceImpl seguridadService;

	@ApiOperation(value = "Valida las credenciales del usuario si existe en bd", produces = "application/json")
	@RequestMapping(value = "/autenticacion", method = RequestMethod.POST, headers = "Accept=application/json")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Usuarios> autenticacion(@RequestBody Usuarios entity, BindingResult bindingResult)
			throws Exception {

		BindingErrorsResponse errors = new BindingErrorsResponse();
		if (bindingResult.hasErrors()) {
			log.error("Error into %s ", entity);
			errors.addAllErrors(bindingResult);
			throw new RuntimeException(errors.toJSON());
		}

		log.info(String.format("usuario %s - %s", entity.getUsuario(), entity.getClave()));
		Usuarios resutl = seguridadService.findEntity(entity);

		return ResponseEntity.ok().body(resutl);
	}

}
