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

import com.incloud.tgestiona.b2b.model.Moneda;
import com.incloud.tgestiona.b2b.servicesImpl.MonedaServiceImpl;
import com.incloud.tgestiona.common.BindingErrorsResponse;

import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public abstract class MonedaRest extends com.incloud.tgestiona.util.MessagesUtils {

	protected boolean devuelveRuntimeException = true;

	private final Logger log = LoggerFactory.getLogger(MonedaRest.class);

	@Autowired
	protected MonedaServiceImpl repository;

	@ApiOperation(value = "Lista los datos de Moneda", produces = "application/json")
	@RequestMapping(value = "/list", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Moneda>> list() throws Exception {
		try {
			List<Moneda> result = repository.getAll();
			log.info(String.format("List information from Azure table Moneda ---> %s", result));
			return Optional.ofNullable(new ResponseEntity<List<Moneda>>(result, HttpStatus.OK))
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

	@ApiOperation(value = "Guarda JSON Array Moneda", produces = "application/json")
	@PostMapping(value = "/saveAll", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Moneda>> saveAll(@RequestBody List<Moneda> entities, BindingResult bindingResult)
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
		log.debug(" - Ingresando Moneda: " + entities.toString());
		try {
			return Optional
					.ofNullable(new ResponseEntity<List<Moneda>>(this.repository.saveAll(entities), HttpStatus.OK))
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

	@ApiOperation(value = "Guarda la Moneda", produces = "application/json")
	@PostMapping(value = "/save", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Moneda> save(@RequestBody Moneda entities, BindingResult bindingResult)
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
		log.debug(" - Ingresando Moneda: " + entities.toString());
		try {
			Moneda result = this.repository.save(entities);
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
	ResponseEntity<Moneda> deleteAll() throws Exception {
		try {
			return Optional.ofNullable(new ResponseEntity<Moneda>(repository.deleteAll(), HttpStatus.OK))
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