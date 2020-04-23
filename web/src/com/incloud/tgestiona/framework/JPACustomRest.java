package com.incloud.tgestiona.framework;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URISyntaxException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.incloud.tgestiona.util.DateUtils;

import io.swagger.annotations.ApiOperation;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public abstract class JPACustomRest<T, I> extends BaseRest {

	private final Logger log = LoggerFactory.getLogger(JPACustomRest.class);

	@PersistenceContext
	protected EntityManager entityManager;

	@Autowired
	protected JpaRepository<T, I> mainrepository;

	private Class<T> type;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public JPACustomRest() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	@Transactional
	public T Save(T entity) {
		return mainrepository.save(entity);
	}

	private Iterable<T> findAll() {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = cb.createQuery(type);
		Root<T> root = criteriaQuery.from(type);
		criteriaQuery.select(root);
		TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Transactional(readOnly = true)
	public Optional<T> findOne(I id) {
		return this.mainrepository.findById(id);
	}

	@Transactional(readOnly = true)
	public List<T> findByAttributeLeftContainsText(String attributeName, String text) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(type);
		Root<T> root = query.from(type);
		query.select(root).where(builder.like(root.<String>get(attributeName), "%" + text));
		TypedQuery<T> q = entityManager.createQuery(query);
		Stream<T> listaStream = q.getResultStream();
		return listaStream.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<T> finds(T req) {
		T bean = req;
		Example<T> employeeExample = Example.of(bean);
		Sort sort = Sort.by("id");
		Stream<T> listaStream = this.mainrepository.findAll(employeeExample, sort).parallelStream();
		return listaStream.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<T> findByAttributeBetweenDate(String attributeName, String sfecha) throws Exception {

		Date fechaInicio = DateUtils.convertStringToDate("dd-MM-yyyy", sfecha);
		Date fechaFin = DateUtils.convertStringToDate("dd-MM-yyyy", sfecha);

		fechaFin = DateUtils.sumarRestarHoras(fechaFin, 23);
		fechaFin = DateUtils.sumarRestarMinutos(fechaFin, 59);
		fechaFin = DateUtils.sumarRestarSegundos(fechaFin, 59);

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(type);
		Root<T> root = query.from(type);
		query.select(root).where(builder.between(root.<Date>get(attributeName), fechaInicio, fechaFin));
		TypedQuery<T> q = entityManager.createQuery(query);
		Stream<T> listaStream = q.getResultStream();
		return listaStream.collect(Collectors.toList());

	}

	/**
	 * Update entity
	 */
	@ApiOperation(value = "Modifica o crea registro de tipo ", produces = "application/json")
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
		log.debug("Into...to...--> %s", bean.toString());
		try {
			T result = mainrepository.save(bean);
			return (ResponseEntity<T>) Optional.of(result).map(l -> new ResponseEntity<>(l, HttpStatus.OK))
					.orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		} catch (Exception e) {
			if (this.devuelveRuntimeException) {
				throw new RuntimeException(getMensageErrorExceptionDebug(e));
			}
			headers = this.devuelveErrorHeaders(e);
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "Devuelve lista de registros en base al Campo y su valor Date (String en formato dd-mm-yyyy)", produces = "application/json")
	@GetMapping(value = "/findByFieldBetweenDate/{attributeName}/{valor}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<T>> findByFieldBetweenDate(@PathVariable String attributeName,
			@PathVariable String valor) throws URISyntaxException {
		try {
			return Optional.ofNullable(findByAttributeBetweenDate(attributeName, valor))
					.map(l -> new ResponseEntity<>(l, HttpStatus.OK))
					.orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		} catch (Exception e) {
			if (this.devuelveRuntimeException) {
				String error = getMensageErrorExceptionDebug(e);
				throw new RuntimeException(error);
			}
			HttpHeaders headers = this.devuelveErrorHeaders(e);
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "Devuelve lista de registros de tipo <T> en base a los parámetros ingresados", produces = "application/json")
	@PostMapping(value = "/findAll", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<T>> findAllRest() throws URISyntaxException {
		try {
			return Optional.ofNullable(findAll()).map(l -> new ResponseEntity<>(l, HttpStatus.OK))
					.orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		} catch (Exception e) {
			if (this.devuelveRuntimeException) {
				throw new RuntimeException(getMensageErrorExceptionDebug(e));
			}
			HttpHeaders headers = this.devuelveErrorHeaders(e);
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Find by Id
	 */
	/*
	 * @ApiOperation(value = "Busca registro de tipo <T> en base al id enviado",
	 * produces = "application/json")
	 * 
	 * @GetMapping(value = "/findById/{id}", produces = APPLICATION_JSON_VALUE)
	 * public ResponseEntity<T> findById(@PathVariable I id) throws
	 * URISyntaxException { try { return
	 * Optional.ofNullable(findOne(id).get()).map(bean -> new ResponseEntity<>(bean,
	 * HttpStatus.OK)) .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); } catch
	 * (Exception e) { if (this.devuelveRuntimeException) { throw new
	 * RuntimeException(getMensageErrorExceptionDebug(e)); } HttpHeaders headers =
	 * this.devuelveErrorHeaders(e); return new ResponseEntity<>(headers,
	 * HttpStatus.BAD_REQUEST); } }
	 */

	@ApiOperation(value = "Devuelve lista de registros en base al Campo y su valor (Left Contains)", produces = "application/json")
	@GetMapping(value = "/findByFieldLeftContainsText/{attributeName}/{valor}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<T>> findByFieldLeftContainsText(@PathVariable String attributeName,
			@PathVariable String valor) throws URISyntaxException {
		try {
			return Optional.ofNullable(this.findByAttributeLeftContainsText(attributeName, valor))
					.map(l -> new ResponseEntity<>(l, HttpStatus.OK))
					.orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		} catch (Exception e) {
			if (this.devuelveRuntimeException) {
				throw new RuntimeException(getMensageErrorExceptionDebug(e));
			}
			HttpHeaders headers = this.devuelveErrorHeaders(e);
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "Devuelve lista de registros de tipo <T> en base a los parámetros ingresados", produces = "application/json")
	@PostMapping(value = "/findQuery", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<T>> find(@RequestBody T bean, BindingResult bindingResult) throws URISyntaxException {
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
		try {
			return Optional.ofNullable(this.finds(bean)).map(l -> new ResponseEntity<>(l, HttpStatus.OK))
					.orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		} catch (Exception e) {
			if (this.devuelveRuntimeException) {
				throw new RuntimeException(getMensageErrorExceptionDebug(e));
			}
			headers = this.devuelveErrorHeaders(e);
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Delete by id
	 */
	@ApiOperation(value = "Elimina registro de tipo <T>", produces = "application/json")
	@DeleteMapping(value = "/deleteById/{id}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> delete(@PathVariable I id) throws URISyntaxException {
		try {
			this.delete(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			if (this.devuelveRuntimeException) {
				throw new RuntimeException(getMensageErrorExceptionDebug(e));
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

	/**
	 * Delete all record.
	 */
	@ApiOperation(value = "Elimina todos los registros de tipo <T>", produces = "application/json")
	@DeleteMapping(value = "/deleteAll", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<T> deleteAll() throws URISyntaxException {
		try {
			this.mainrepository.deleteAll();
			this.mainrepository.flush();
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			if (this.devuelveRuntimeException) {
				throw new RuntimeException(getMensageErrorExceptionDebug(e));
			}
			throw new RuntimeException(getMensageErrorExceptionDebug(e));
		}
	}

	/**
	 * Update or created en forma Masiva en misma Transaction
	 */
	@ApiOperation(value = "Modifica o crea registro de tipo <T> en forma Masiva en misma Transaction", produces = "application/json")
	@PostMapping(value = "/saveAll", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<T>> saveAll(@RequestBody @Valid List<T> listaBean, BindingResult bindingResult)
			throws URISyntaxException {
		BindingErrorsResponse errors = new BindingErrorsResponse();
		HttpHeaders headers = new HttpHeaders();
		if (bindingResult.hasErrors()) {
			String errorDevuelve = this.devuelveErrorHeaders(bindingResult, errors);
			if (this.devuelveRuntimeException) {
				throw new RuntimeException(errorDevuelve);
			}
			headers.add("errors", errorDevuelve);
		}
		try {
			List<T> result = mainrepository.saveAll(listaBean);
			return Optional.of(result).map(l -> new ResponseEntity<>(l, HttpStatus.OK))
					.orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		} catch (Exception e) {
			throw new RuntimeException(getMensageErrorExceptionDebug(e));
		}
	}

	/************************/
	/* Instancia de Bean */
	/************************/
	// protected abstract T createInstance();

	private T createInstance() {
		System.out.println("new Instancia");
		try {
			Type sooper = getClass().getGenericSuperclass();
			Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];
			return (T) (Class.forName(t.toString()).newInstance());
		} catch (Exception e) {
			return null;
		}
	}

}
