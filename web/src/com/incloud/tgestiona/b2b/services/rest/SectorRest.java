package com.incloud.tgestiona.b2b.services.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incloud.tgestiona.b2b.model.Sector;
import com.incloud.tgestiona.framework.JPACustomRest;

@RestController
@RequestMapping("/api/sector")
public class SectorRest extends JPACustomRest<Sector, Integer> {

	@Override
	protected Sector createInstance() {
		// TODO Auto-generated method stub
		return null;
	} /// com.incloud.tgestiona.util.MessagesUtils {

	/// protected boolean devuelveRuntimeException = true;

	/// private final Logger log = LoggerFactory.getLogger(SectorRest.class);

	// @Autowired
	// protected SectorServiceImpl repository;

	/*
	 * @ApiOperation(value = "Lista todos los Sector", produces =
	 * "application/json")
	 * 
	 * @RequestMapping(value = "/list", method = RequestMethod.GET, headers =
	 * "Accept=application/json") ResponseEntity<List<Sector>> list() throws
	 * Exception { try { List<Sector> result = repository.getAll();
	 * log.info(String.format("List information from Azure table Sector ---> %s",
	 * result)); return Optional.ofNullable(new ResponseEntity<List<Sector>>(result,
	 * HttpStatus.OK)) .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT)); } catch
	 * (Exception e) { if (this.devuelveRuntimeException) {
	 * log.error(String.format("error:---> %s", e)); throw new RuntimeException(e);
	 * } HttpHeaders headers = returnErrorHeaders(e); return new
	 * ResponseEntity<>(headers, HttpStatus.BAD_REQUEST); } }
	 * 
	 * @ApiOperation(value = "Guarda JSON Array Sector", produces =
	 * "application/json")
	 * 
	 * @PostMapping(value = "/saveAll", produces = APPLICATION_JSON_VALUE) public
	 * ResponseEntity<List<Sector>> saveAll(@RequestBody List<Sector> entities,
	 * BindingResult bindingResult) throws URISyntaxException {
	 * 
	 * BindingErrorsResponse errors = new BindingErrorsResponse(); HttpHeaders
	 * headers = new HttpHeaders();
	 * 
	 * if (bindingResult.hasErrors()) { errors.addAllErrors(bindingResult); if
	 * (this.devuelveRuntimeException) { throw new
	 * RuntimeException(errors.toJSON()); } headers.add("errors", errors.toJSON());
	 * return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST); }
	 * log.debug(" - Ingresando Sector: " + entities.toString()); try { return
	 * Optional .ofNullable(new
	 * ResponseEntity<List<Sector>>(this.repository.saveAll(entities),
	 * HttpStatus.OK)) .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT)); } catch
	 * (Exception e) {
	 * 
	 * if (this.devuelveRuntimeException) { String error =
	 * getErrorExceptionDebug(e); throw new RuntimeException(error); }
	 * 
	 * headers = returnErrorHeaders(e); return new ResponseEntity<>(headers,
	 * HttpStatus.BAD_REQUEST);
	 * 
	 * } }
	 * 
	 * @ApiOperation(value = "Guarda el Sector", produces = "application/json")
	 * 
	 * @PostMapping(value = "/save", produces = APPLICATION_JSON_VALUE) public
	 * ResponseEntity<Sector> save(@RequestBody Sector entities, BindingResult
	 * bindingResult) throws URISyntaxException {
	 * 
	 * BindingErrorsResponse errors = new BindingErrorsResponse(); HttpHeaders
	 * headers = new HttpHeaders();
	 * 
	 * if (bindingResult.hasErrors()) { errors.addAllErrors(bindingResult); if
	 * (this.devuelveRuntimeException) { throw new
	 * RuntimeException(errors.toJSON()); } headers.add("errors", errors.toJSON());
	 * return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST); }
	 * log.debug(" - Ingresando Sector: " + repository.toString()); try { Sector
	 * result = this.repository.save(entities); return Optional.of(result).map(l ->
	 * new ResponseEntity<>(l, HttpStatus.OK)) .orElse(new
	 * ResponseEntity<>(HttpStatus.NO_CONTENT)); } catch (Exception e) { if
	 * (this.devuelveRuntimeException) { String error = getErrorExceptionDebug(e);
	 * throw new RuntimeException(error); } headers = returnErrorHeaders(e); return
	 * new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST); } }
	 * 
	 * @ApiOperation(value = "Delete All Log records ", produces =
	 * "application/json")
	 * 
	 * @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE, headers
	 * = "Accept=application/json") ResponseEntity<Sector> deleteAll() throws
	 * Exception { try { return Optional.ofNullable(new
	 * ResponseEntity<Sector>(repository.deleteAll(), HttpStatus.OK)) .orElse(new
	 * ResponseEntity<>(HttpStatus.NO_CONTENT)); } catch (Exception e) { if
	 * (this.devuelveRuntimeException) { log.error(String.format("error:---> %s",
	 * e)); throw new RuntimeException(e); } HttpHeaders headers =
	 * this.returnErrorHeaders(e); return new ResponseEntity<>(headers,
	 * HttpStatus.BAD_REQUEST); } }
	 */

}