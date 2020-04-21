package com.incloud.tgestiona.b2b.services.rest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.incloud.tgestiona.b2b.model.Ubigeo;
import com.incloud.tgestiona.b2b.servicesImpl.UbigeoServiceImpl;
import com.incloud.tgestiona.common.BindingErrorsResponse;

import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/ubigeo")
public class UbigeoRest extends com.incloud.tgestiona.util.MessagesUtils {

	protected boolean devuelveRuntimeException = true;

	private final Logger log = LoggerFactory.getLogger(UbigeoRest.class);

	@Autowired
	protected UbigeoServiceImpl repository;

	@ApiOperation(value = "Lista los datos de Ubigeo", produces = "application/json")
	@RequestMapping(value = "/list", method = RequestMethod.GET, headers = "Accept=application/json")
	ResponseEntity<List<Ubigeo>> list() throws Exception {
		try {
			List<Ubigeo> result = repository.getAll();
			log.info(String.format("List information from Azure table Ubigeo ---> %s", result));
			return Optional.ofNullable(new ResponseEntity<List<Ubigeo>>(result, HttpStatus.OK))
					.orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		} catch (Exception e) {
			if (this.devuelveRuntimeException) {
				log.error(String.format("error:---> %s", e));
				throw new RuntimeException(e);
			}
			HttpHeaders headers = returnErrorHeaders(e);
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "Guarda JSON Array Ubigeo", produces = "application/json")
	@PostMapping(value = "/saveAll", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ubigeo>> saveAll(@RequestBody List<Ubigeo> entities, BindingResult bindingResult)
			throws URISyntaxException {

		BindingErrorsResponse errors = new BindingErrorsResponse();
		HttpHeaders headers = new HttpHeaders();

		if (bindingResult.hasErrors()) {
			errors.addAllErrors(bindingResult);
			if (this.devuelveRuntimeException) {
				throw new RuntimeException(errors.toJSON());
			}
			headers.add("errors", errors.toJSON());
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
		log.debug(" - Ingresando Ubigeo: " + entities.toString());
		try {
			return Optional
					.ofNullable(new ResponseEntity<List<Ubigeo>>(this.repository.saveAll(entities), HttpStatus.OK))
					.orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		} catch (Exception e) {

			if (this.devuelveRuntimeException) {
				String error = getErrorExceptionDebug(e);
				throw new RuntimeException(error);
			}

			headers = returnErrorHeaders(e);
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);

		}
	}

	@ApiOperation(value = "Guarda el Ubigeo", produces = "application/json")
	@PostMapping(value = "/save", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Ubigeo> save(@RequestBody Ubigeo entities, BindingResult bindingResult)
			throws URISyntaxException {

		BindingErrorsResponse errors = new BindingErrorsResponse();
		HttpHeaders headers = new HttpHeaders();

		if (bindingResult.hasErrors()) {
			errors.addAllErrors(bindingResult);
			if (this.devuelveRuntimeException) {
				throw new RuntimeException(errors.toJSON());
			}
			headers.add("errors", errors.toJSON());
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
		log.debug(" - Ingresando Ubigeo: " + entities.toString());
		try {
			Ubigeo result = this.repository.save(entities);
			return Optional.of(result).map(l -> new ResponseEntity<>(l, HttpStatus.OK))
					.orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		} catch (Exception e) {
			if (this.devuelveRuntimeException) {
				String error = getErrorExceptionDebug(e);
				throw new RuntimeException(error);
			}
			headers = returnErrorHeaders(e);
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "Delete All Log records ", produces = "application/json")
	@RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE, headers = "Accept=application/json")
	ResponseEntity<Ubigeo> deleteAll() throws Exception {
		try {
			return Optional.ofNullable(new ResponseEntity<Ubigeo>(repository.deleteAll(), HttpStatus.OK))
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