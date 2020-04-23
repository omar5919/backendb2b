package com.incloud.tgestiona.b2b.services.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.incloud.tgestiona.b2b.model.Cliente;
import com.incloud.tgestiona.b2b.model.isis.cliente;
import com.incloud.tgestiona.b2b.service.dto.clienteIsisDto;
import com.incloud.tgestiona.framework.BindingErrorsResponse;
import com.incloud.tgestiona.framework.JPACustomRest;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/IsisCliente")
public class IsisClienteRest extends JPACustomRest<cliente, Integer> {

	private final Logger log = LoggerFactory.getLogger(ClientesRest.class);

	@ApiOperation(value = "Adjuntar archivo para ISIS-Cliente", produces = "application/json")
	@PostMapping(value = "/uploadCVS", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<clienteIsisDto> uploadCVS(@RequestParam("file") MultipartFile file) throws IOException {

		HttpHeaders headers = new HttpHeaders();
		clienteIsisDto clienteDto = new clienteIsisDto();

		cliente entity = null;

		String row;
		long increment=0;
		InputStream is = new ByteArrayInputStream(file.getBytes());
		BufferedReader csvReader = new BufferedReader(new InputStreamReader(is));
		while ((row = csvReader.readLine()) != null) {
			String[] data = row.split(";");

			try {

				entity = new cliente();
				entity.setClcodapli(data[0].trim());
				entity.setClnomcli(data[1].trim());
				entity.setClapecli(data[2].trim());
				entity.setClcodcli(data[3].trim());
				entity.setGctipdoc(data[4].trim());
				entity.setGcrucgc(data[5].trim());
				entity.setGctipgc(data[6].trim());
				entity.setGccladat(data[7].trim());
				
				//Setter total records
				increment++;
				clienteDto.setTotalRecord(increment);

			} catch (java.lang.ArrayIndexOutOfBoundsException e) {

			} finally {

				cliente retorno = Save(entity);

			}
			// do something with the data
		}
		csvReader.close();
		is.close();
		
		clienteDto.setMsg("Record on table Cliente and schema Isis...ok");
		
		log.info( "Total of record on table Cliente and schema Isis %s",clienteDto);

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
