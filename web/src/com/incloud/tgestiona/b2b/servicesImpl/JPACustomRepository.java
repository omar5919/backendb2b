package com.incloud.tgestiona.b2b.servicesImpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.incloud.tgestiona.util.DateUtils;

@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class JPACustomRepository<T, I> {

	private final Logger log = LoggerFactory.getLogger(JPACustomRepository.class);

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

	public JPACustomRepository() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	@Transactional
	public T Save(T entity) {
		log.info("save entity into %s", type);
		return mainrepository.save(entity);
	}

	public Iterable<T> findAll() {
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
	public List<T> findEntityList(T req) {
		T bean = req;
		Example<T> entity = Example.of(bean);
		Sort sort = Sort.by("id");
		Stream<T> listaStream = this.mainrepository.findAll(entity, sort).parallelStream();
		return listaStream.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public T findEntity(T req) {
		T bean = req;
		Example<T> entity = Example.of(bean);
		if (this.mainrepository.exists(entity))
			return this.mainrepository.findOne(entity).get();
		return null;
	}

	@Transactional
	public T deleteByID(I id) {
		if (this.mainrepository.existsById(id)) {
			T entity = mainrepository.findById(id).get();
			mainrepository.delete(entity);
		}
		return null;
	}
	
	@Transactional
	public T deleteAll() {
		List<T> list = mainrepository.findAll();
		mainrepository.deleteAll(list);
		return null;
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

}
