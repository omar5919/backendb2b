package com.incloud.tgestiona.b2b.services.rest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.incloud.tgestiona.b2b.model.Ofertas;
import com.incloud.tgestiona.b2b.servicesImpl.OfertaServiceImpl;
import com.incloud.tgestiona.common.BindingErrorsResponse;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public abstract class OfertaRest extends com.incloud.tgestiona.util.MessagesUtils {

	protected boolean devuelveRuntimeException = true;

	private final Logger log = LoggerFactory.getLogger(OfertaRest.class);

	@Autowired
	protected OfertaServiceImpl repository;

	// , response =
	// Ofertas.class,
	// tags =
	// "listOferta"
	@ApiOperation(value = "Optiene dato de la Oferta segun parametro", produces = "application/json")
	@RequestMapping(value = "/getOferta/{idoferta}", method = RequestMethod.GET, headers = "Accept=application/json")
	ResponseEntity<Optional<Ofertas>> getOferta(@PathVariable Integer id) throws Exception {
		log.info(String.format("Consultando ID Oferta ---> %s", id));

		if (!Optional.ofNullable(id).isPresent()) {
			log.error(String.format("No se encontró el idoferta:---> %s", id));
			throw new Exception("No se encontró el id  oferta:" + id);
		}

		try {
			return Optional.ofNullable(repository.findByID(id)).map(l -> new ResponseEntity<>(l, HttpStatus.OK))
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

	@ApiOperation(value = "Lista los datos de la Oferta", produces = "application/json")
	@RequestMapping(value = "/list", method = RequestMethod.GET, headers = "Accept=application/json")
	ResponseEntity<List<Ofertas>> list() throws Exception {
		try {
			List<Ofertas> result = repository.getAll();
			log.info(String.format("List information from Azure table Oferta ---> %s", result));
			return Optional.ofNullable(new ResponseEntity<List<Ofertas>>(result, HttpStatus.OK))
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

	@ApiOperation(value = "Guarda JSON Array Ofertas", produces = "application/json")
	@PostMapping(value = "/saveAll", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ofertas>> saveAll(@RequestBody List<Ofertas> entities, BindingResult bindingResult)
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
		log.debug(" - Ingresando Ofertas: " + entities.toString());
		try {
			return Optional
					.ofNullable(new ResponseEntity<List<Ofertas>>(this.repository.saveAll(entities), HttpStatus.OK))
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

	@ApiOperation(value = "Guarda datos de la Oferta", produces = "application/json")
	@PostMapping(value = "/saveOferta", produces = APPLICATION_JSON_VALUE)
//	@RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<Ofertas> save(@RequestBody Ofertas entities, BindingResult bindingResult)
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
		log.debug(" - Ingresando saveOferta: " + entities.toString());
		try {
			Ofertas result = this.repository.save(entities);
			return Optional.of(result).map(l -> new ResponseEntity<>(l, HttpStatus.OK))
					.orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		} catch (Exception e) {
			if (this.devuelveRuntimeException) {
				String error = getErrorExceptionDebug(e);
				throw new RuntimeException(error);
			}
			headers = this.returnErrorHeaders(e);
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "Elimina Oferta", produces = "application/json")
	@RequestMapping(value = "/deleteOferta/{idOferta}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<Ofertas> deleteOferta(@PathVariable("idOferta") Integer id) throws Exception {
		if (!Optional.ofNullable(id).isPresent()) {
			log.error(String.format("No se encontró el idoferta:---> %s", id));
			throw new Exception("No se encontró el id  oferta:" + id);
		}
		return Optional.of(new ResponseEntity<Ofertas>(this.repository.deleteById(id), HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
	}

	@ApiOperation(value = "Delete All Log records ", produces = "application/json")
	@RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE, headers = "Accept=application/json")
	ResponseEntity<Ofertas> deleteAll() throws Exception {
		try {
			return Optional.ofNullable(new ResponseEntity<Ofertas>(repository.deleteAll(), HttpStatus.OK))
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