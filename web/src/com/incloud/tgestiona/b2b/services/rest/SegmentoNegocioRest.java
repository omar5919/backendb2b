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

import com.incloud.tgestiona.b2b.model.SegmentoNegocio;
import com.incloud.tgestiona.b2b.servicesImpl.SegmentoNegocioServiceImpl;
import com.incloud.tgestiona.common.BindingErrorsResponse;

import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/segmentoNegocio")
public class SegmentoNegocioRest extends com.incloud.tgestiona.util.MessagesUtils {

	protected boolean devuelveRuntimeException = true;

	private final Logger log = LoggerFactory.getLogger(SegmentoNegocioRest.class);

	@Autowired
	protected SegmentoNegocioServiceImpl repository;

	@ApiOperation(value = "Lista los datos de SegmentoNegocio", produces = "application/json")
	@RequestMapping(value = "/list", method = RequestMethod.GET, headers = "Accept=application/json")
	ResponseEntity<List<SegmentoNegocio>> list() throws Exception {
		try {
			List<SegmentoNegocio> result = repository.getAll();
			log.info(String.format("List information from Azure table SegmentoNegocio ---> %s", result));
			return Optional.ofNullable(new ResponseEntity<List<SegmentoNegocio>>(result, HttpStatus.OK))
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

	@ApiOperation(value = "Guarda JSON Array SegmentoNegocio", produces = "application/json")
	@PostMapping(value = "/saveAll", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SegmentoNegocio>> saveAll(@RequestBody List<SegmentoNegocio> entities,
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
		log.debug(" - Ingresando SegmentoNegocio: " + entities.toString());
		try {
			return Optional
					.ofNullable(
							new ResponseEntity<List<SegmentoNegocio>>(this.repository.saveAll(entities), HttpStatus.OK))
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

	@ApiOperation(value = "Guarda el SegmentoNegocio", produces = "application/json")
	@PostMapping(value = "/save", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<SegmentoNegocio> save(@RequestBody SegmentoNegocio entities, BindingResult bindingResult)
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
		log.debug(" - Ingresando SegmentoNegocio: " + entities.toString());
		try {
			SegmentoNegocio result = this.repository.save(entities);
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
	ResponseEntity<SegmentoNegocio> deleteAll() throws Exception {
		try {
			return Optional.ofNullable(new ResponseEntity<SegmentoNegocio>(repository.deleteAll(), HttpStatus.OK))
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