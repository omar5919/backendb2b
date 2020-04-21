package com.incloud.tgestiona.framework;

import java.net.URISyntaxException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.incloud.tgestiona.domain.BaseDomain;

import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public abstract class JPACustomRest<T extends BaseDomain, I> extends BaseRest {
	
	
	private final Logger log = LoggerFactory.getLogger(JPACustomRest.class);
	
	//@Autowired
	//private SectorRepository<T,I> mainService;
	
	
	  protected abstract T createInstance();

	// @Autowired
	// protected JPACustomService<T, I> mainService;

// 	protected JPACustomServiceImpl<T, I> mainService;
	/// protected JPACustomRepositoryImpl<T, I> mainService;

	///@Autowired
//	protected SectorServiceImpl<T, I> mainService;
	
	
//	@Autowired
 //   protected JPACustomRepository<Sector, I> mainRepository;

	/**
	 * Update entity
	 */
	  
	  /*
	 
	@ApiOperation(value = "Modifica o crea registro de tipo <T>", produces = "application/json")
	@PostMapping(value = "/save", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<T> save(@RequestBody @Valid T bean, BindingResult bindingResult) throws URISyntaxException {
		
		BindingErrorsResponse errors = new BindingErrorsResponse();
		HttpHeaders headers = new HttpHeaders();
		
		if (bindingResult.hasErrors()) {
			String errorDevuelve = this.devuelveErrorHeaders(bindingResult, errors);
			if (this.devuelveRuntimeException) {
				throw new RuntimeException(errorDevuelve);
			}
			headers.add("errors", errorDevuelve);
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
		
		log.debug( "Into...to...--> %s" + bean.toString());
		
		try {
			T result = mainService.save(bean);
			
			return (ResponseEntity<T>) Optional.of(result).map(l -> new ResponseEntity<>(l, HttpStatus.OK))
					.orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		} catch (Exception e) {
			if (this.devuelveRuntimeException) {
				String error = e.getLocalizedMessage();/// Utils.obtieneMensajeErrorExceptionDepurado(e);
				throw new RuntimeException(error);
			}
			headers = this.devuelveErrorHeaders(e);
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	 
	@ApiOperation(value = "Devuelve lista de registros de tipo <T> en base a los parámetros ingresados", produces = "application/json")
	@PostMapping(value = "/find", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<T>> find() throws URISyntaxException {
		try {
			return Optional.ofNullable(this.mainService.findAll()).map(l -> new ResponseEntity<>(l, HttpStatus.OK))
					.orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		} catch (Exception e) {
			if (this.devuelveRuntimeException) {
				String error = e.getMessage();// Utils.obtieneMensajeErrorExceptionDepurado(e);
				throw new RuntimeException(error);
			}
			HttpHeaders headers = this.devuelveErrorHeaders(e);
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	} */

}
