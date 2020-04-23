package com.incloud.tgestiona.b2b.services.rest;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.incloud.tgestiona.b2b.model.Usuarios;
import com.incloud.tgestiona.b2b.servicesImpl.SeguridadServiceImpl;
import com.incloud.tgestiona.framework.JPACustomRest;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/seguridad")
public class SeguridadRest extends  JPACustomRest<Usuarios, Integer>{

	private final Logger log = LoggerFactory.getLogger(OfertaRest.class);

	@Autowired
	protected SeguridadServiceImpl seguridadService;

	@ApiOperation(value = "Valida las credenciales del usuario si existe en bd", produces = "application/json")
	@RequestMapping(value = "/autenticacion", method = RequestMethod.POST, headers = "Accept=application/json")
	/// @CrossOrigin(origins = "http://localhost:4200")
	ResponseEntity<Optional<Usuarios>> autenticacion(@RequestBody Usuarios u, BindingResult bindingResult)
			throws Exception {
		log.info(String.format("usuario ---> %s", u.getUsuario()));
		log.info(String.format("clave ---> %s", u.getClave()));
		

		try {
			return Optional.ofNullable(seguridadService.findByCredenciales(u.getUsuario(), u.getClave()))
					.map(l -> new ResponseEntity<>(l, HttpStatus.OK))
					.orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		} catch (Exception e) {
			if (this.devuelveRuntimeException) {
				log.error(String.format("error:---> %s", e));
				throw new RuntimeException(e);
			}
			HttpHeaders headers = this.returnErrorHeaders(e);
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}
}
