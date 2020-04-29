package com.incloud.tgestiona.b2b.services.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.cellprocessor.ParseInt;

import com.incloud.tgestiona.b2b.model.isis.Equipo;
import com.incloud.tgestiona.b2b.service.dto.equipoInIsisDto;
import com.incloud.tgestiona.b2b.service.dto.equipoOutIsisDto;
import com.incloud.tgestiona.framework.BindingErrorsResponse;
import com.incloud.tgestiona.framework.JPACustomRest;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/IsisEquipo")
public class IsisEquipoRest extends JPACustomRest<Equipo, Integer>{

	private final Logger log = LoggerFactory.getLogger(EquipoRest.class);

	@ApiOperation(value = "Adjuntar archivo para ISIS-Equipo", produces = "application/json")
	@PostMapping(value = "/uploadCVS", produces = APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<equipoOutIsisDto> uploadCVS(@RequestBody @Valid equipoInIsisDto equipoInputParam, BindingResult bindingResult) throws IOException {
		BindingErrorsResponse errors = new BindingErrorsResponse();

		HttpHeaders headers = new HttpHeaders();

		if (equipoInputParam.getUrl() == null) {
			String errorDevuelve = this.devuelveErrorHeaders(bindingResult, errors);
			if (this.devuelveRuntimeException) {
				throw new RuntimeException(errorDevuelve);
			}
			headers.add("errors", errorDevuelve);
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}

		byte[] fileContent = IOUtils.toByteArray(new URL(equipoInputParam.getUrl()));
		equipoOutIsisDto equipoDto = new equipoOutIsisDto();

		Equipo entity = null;
		//
		String row;
		long increment = 0;
		InputStream is = new ByteArrayInputStream(fileContent);
		BufferedReader csvReader = new BufferedReader(new InputStreamReader(is));
		while((row = csvReader.readLine()) != null) {
			if (increment > 0) {
				String[] data = row.split(";");
				try {
					entity = new Equipo();
					entity.setCodigoIsis(Integer.parseInt(data[0].trim()));
					entity.setB2bDedescripcion(data[1].trim());
					entity.setCodMarcEqui(Integer.parseInt(data[2].trim()));
					entity.setIndEqui(data[3].trim());
					entity.setMadesmar(data[4].trim());

					equipoDto.setTotalRecord(increment);

				}catch (ArrayIndexOutOfBoundsException e) {

				}finally {
					Equipo retorno = save(entity);
				}
			}
			increment++;
		}
		csvReader.close();
		is.close();

		equipoDto.setMsg("Record on table Equipo and schema Isis is OK");

		log.info("Total of records on table Equipo and schema Isis %s", equipoDto);

		try {
			return Optional.ofNullable(equipoDto).map(l -> new ResponseEntity<>(l, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		}catch(Exception e) {
			if (this.devuelveRuntimeException) {
				String error = getMensageErrorExceptionDebug(e);
				throw new RuntimeException(error);
			}
			headers = this.devuelveErrorHeaders(e);
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}
}