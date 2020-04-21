package com.incloud.tgestiona.b2b.services.rest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.incloud.tgestiona.b2b.model.AppProcesoLog;
import com.incloud.tgestiona.b2b.servicesImpl.AppProcesoLogServiceImpl;

import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appProcesoLog")
public class AppProcesoLogRest extends com.incloud.tgestiona.util.MessagesUtils {

	protected boolean devuelveRuntimeException = true;

	private final Logger log = LoggerFactory.getLogger(AppProcesoLogRest.class);

	@Autowired
	protected AppProcesoLogServiceImpl repository;

	@ApiOperation(value = "Lista los ProcesosLog", produces = "application/json")
	@RequestMapping(value = "/list", method = RequestMethod.GET, headers = "Accept=application/json")
	ResponseEntity<List<AppProcesoLog>> list() throws Exception {
		try {
			List<AppProcesoLog> result = repository.getAll();
			log.info(String.format("List information from Azure table AppProcesoLog ---> %s", result));
			return Optional.ofNullable(new ResponseEntity<List<AppProcesoLog>>(result, HttpStatus.OK))
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

	@ApiOperation(value = "Delete All Log records ", produces = "application/json")
	@RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE, headers = "Accept=application/json")
	ResponseEntity<AppProcesoLog> deleteAll() throws Exception {
		try {
			return Optional.ofNullable(new ResponseEntity<AppProcesoLog>(repository.deleteAll(), HttpStatus.OK))
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