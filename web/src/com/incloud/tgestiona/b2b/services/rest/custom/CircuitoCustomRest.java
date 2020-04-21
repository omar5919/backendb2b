package com.incloud.tgestiona.b2b.services.rest.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.incloud.tgestiona.b2b.model.Circuito;
import com.incloud.tgestiona.b2b.services.rest.CircuitoRest;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/circuito")
public class CircuitoCustomRest extends CircuitoRest {

	private final Logger log = LoggerFactory.getLogger(CircuitoCustomRest.class);

	/*
	 * methods personalize
	 */

	@ApiOperation(value = "Lista los datos de Circuito", produces = "application/json")
	@RequestMapping(value = "/listCirculo", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Circuito>> list() throws Exception {

		try {
			List<Circuito> result = new ArrayList<Circuito>();

			Circuito e = new Circuito();
			e.setServicioPropuestoId(12);

			result.add(e);

			log.info(String.format("List information from Azure table Circuito ---> %s", result));

			return Optional.ofNullable(new ResponseEntity<List<Circuito>>(result, HttpStatus.OK))
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

}
