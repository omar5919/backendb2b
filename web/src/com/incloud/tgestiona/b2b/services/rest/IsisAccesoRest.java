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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.incloud.tgestiona.b2b.model.isis.Acceso;
import com.incloud.tgestiona.b2b.model.isis.cliente;
import com.incloud.tgestiona.b2b.service.dto.clienteInIsisDto;
import com.incloud.tgestiona.b2b.service.dto.clienteOutIsisDto;
import com.incloud.tgestiona.framework.BindingErrorsResponse;
import com.incloud.tgestiona.framework.JPACustomRest;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/IsisAcceso")
public class IsisAccesoRest extends JPACustomRest<Acceso, Integer> {

	/*private final Logger log = LoggerFactory.getLogger(IsisAccesoRest.class);
	
	@ApiOperation(value = "Adjuntar archivo para ISIS-Acceso", produces = "application/json")
	@PostMapping(value = "/uploadCVS", produces = APPLICATION_JSON_VALUE)
	//@RequestMapping(value = "/uploadCVS", method = RequestMethod.POST, headers = "Accept=application/json")	  	   
	//public ResponseEntity<clienteOutIsisDto> uploadCVS(@RequestParam("file") MultipartFile file) throws IOException {
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
		
		Acceso entityAcceso = null;

		String row;
		long increment = 0;
		InputStream is = new ByteArrayInputStream(fileContent);
		//InputStream is = new ByteArrayInputStream(file.getBytes());
		BufferedReader csvReader = new BufferedReader(new InputStreamReader(is));
		
		while ((row = csvReader.readLine()) != null) {
			String[] data = row.split(";");
			if(increment > 0) {
				try {
					
						entityAcceso = new Acceso();
						entityAcceso.setCodigoIsis(data[0].trim());
						entityAcceso.setVelocidad(convertToDouble(data[1].trim()));
						entityAcceso.setTipoServicioId(Integer.parseInt(data[2].trim()));
						entityAcceso.setActivo(true);
						clienteDto.setTotalRecord(increment);
									
					// Setter total records
				
				} catch (java.lang.ArrayIndexOutOfBoundsException e) {

				} finally {
					Acceso retorno = save(entityAcceso);
				}
			}else {
				increment++;
				continue;
			}
					
			increment++;
			// do something with the data
		}
		csvReader.close();
		is.close();

		clienteDto.setMsg("Record on table Cliente and schema Isis...ok");

		log.info("Total of record on table Cliente and schema Isis %s", clienteDto);

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

	 public static double convertToDouble(String temp){
	       String a = temp;
	       //replace all commas if present with no comma
	       String s = a.replaceAll(",","").trim(); 
	      // if there are any empty spaces also take it out.          
	      String f = s.replaceAll(" ", ""); 
	      //now convert the string to double
	      double result = Double.parseDouble(f); 
	      return result; // return the result
	}*/
	 
	
}
