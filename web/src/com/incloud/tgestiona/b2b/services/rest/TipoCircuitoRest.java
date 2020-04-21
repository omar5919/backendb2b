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

import com.incloud.tgestiona.b2b.model.TipoCircuito;
import com.incloud.tgestiona.b2b.servicesImpl.TipoCircuitoServiceImpl;
import com.incloud.tgestiona.common.BindingErrorsResponse;

import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/tipoCircuito")
public class TipoCircuitoRest extends com.incloud.tgestiona.util.MessagesUtils {

	protected boolean devuelveRuntimeException = true;

	private final Logger log = LoggerFactory.getLogger(TipoCircuitoRest.class);

	@Autowired
	protected TipoCircuitoServiceImpl repository;

	@ApiOperation(value = "Lista los datos de TipoCircuito", produces = "application/json")
	@RequestMapping(value = "/list", method = RequestMethod.GET, headers = "Accept=application/json")
	ResponseEntity<List<TipoCircuito>> list() throws Exception {
		try {
			List<TipoCircuito> result = repository.getAll();
			log.info(String.format("List information from Azure table TipoCircuito ---> %s", result));
			return Optional.ofNullable(new ResponseEntity<List<TipoCircuito>>(result, HttpStatus.OK))
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

	@ApiOperation(value = "Guarda JSON Array TipoCircuito", produces = "application/json")
	@PostMapping(value = "/saveAll", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoCircuito>> saveAll(@RequestBody List<TipoCircuito> entities,
			BindingResult bindingResult) throws URISyntaxException {

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
		log.debug(" - Ingresando TipoCircuito: " + entities.toString());
		try {
			return Optional
					.ofNullable(
							new ResponseEntity<List<TipoCircuito>>(this.repository.saveAll(entities), HttpStatus.OK))
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

	@ApiOperation(value = "Guarda el Tipo de Circuito", produces = "application/json")
	@PostMapping(value = "/save", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoCircuito> save(@RequestBody TipoCircuito entities, BindingResult bindingResult)
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
		log.debug(" - Ingresando TipoCircuito: " + entities.toString());
		try {
			TipoCircuito result = this.repository.save(entities);
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
	ResponseEntity<TipoCircuito> deleteAll() throws Exception {
		try {
			return Optional.ofNullable(new ResponseEntity<TipoCircuito>(repository.deleteAll(), HttpStatus.OK))
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