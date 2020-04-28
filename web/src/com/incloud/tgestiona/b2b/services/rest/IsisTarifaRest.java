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
import com.incloud.tgestiona.b2b.model.isis.Tarifa;
import com.incloud.tgestiona.b2b.service.dto.clienteInIsisDto;
import com.incloud.tgestiona.b2b.service.dto.clienteOutIsisDto;
import com.incloud.tgestiona.framework.BindingErrorsResponse;
import com.incloud.tgestiona.framework.JPACustomRest;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/IsisTarifa")
public class IsisTarifaRest extends JPACustomRest<Tarifa, Integer> {


	//private final Logger log = LoggerFactory.getLogger(ClientesRest.class);

	@ApiOperation(value = "Adjuntar archivo para ISIS-Tarifa", produces = "application/json")
	@PostMapping(value = "/uploadCVS", produces = APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<clienteOutIsisDto> uploadCVS(@RequestBody @Valid clienteInIsisDto clienteInputParam,
			BindingResult bindingResult) throws IOException {

		BindingErrorsResponse errors = new BindingErrorsResponse();
		HttpHeaders headers = new HttpHeaders();

		if (clienteInputParam.getUrl() == null) {

			String errorDevuelve = this.devuelveErrorHeaders(bindingResult, errors);
			if (this.devuelveRuntimeException) {
				throw new RuntimeException(errorDevuelve);
			}
			headers.add("errors", errorDevuelve);
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}

		byte[] fileContent = IOUtils.toByteArray(new URL(clienteInputParam.getUrl()));

		clienteOutIsisDto clienteDto = new clienteOutIsisDto();

		Tarifa entity = null;

		String row;
		long increment = 0;
		InputStream is = new ByteArrayInputStream(fileContent);
		BufferedReader csvReader = new BufferedReader(new InputStreamReader(is));
		while ((row = csvReader.readLine()) != null) {
			String[] data = row.split(";");

			try {

			 	entity = new Tarifa();
				entity.setCodTari(data[0].trim());
				entity.setDesTari(data[1].trim());
				entity.setMonto(data[2].trim());
				entity.setMontoSolariza(data[3].trim());
				entity.setTipPagoTari(data[4].trim());
				entity.setFecInicTariVige(data[5].trim());
				entity.setFecFinaTariVige(data[6].trim());
				entity.setCodCon(data[7].trim());
				entity.setDesConc(data[8].trim());
				entity.setCodMone(data[9].trim());
				entity.setCodGrupDsct(data[10].trim());
				entity.setSec(data[11].trim());
				// Setter total records
				increment++;
				clienteDto.setTotalRecord(increment);

			} catch (java.lang.ArrayIndexOutOfBoundsException e) {

			} finally {

				Tarifa retorno = save(entity);

			}
			// do something with the data
		}
		csvReader.close();
		is.close();

		clienteDto.setMsg("Record on table Cliente and schema Isis...ok");

		//log.info("Total of record on table Cliente and schema Isis %s", clienteDto);

		try {
			return Optional.ofNullable(clienteDto).map(l -> new ResponseEntity<>(l, HttpStatus.OK))
					.orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		} catch (Exception e) {
			if (this.devuelveRuntimeException) {
				String error = getMensageErrorExceptionDebug(e);
				throw new RuntimeException(error);
			}
			headers = this.devuelveErrorHeaders(e);
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

}
