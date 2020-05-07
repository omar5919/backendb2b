package com.incloud.tgestiona.framework.Service;

import java.util.List;
import java.util.Optional;

public interface JPACustomService<T, I> {

	public T save(T entity);

	public Iterable<T> findAll();

	public Optional<T> findOne(I id);

	public List<T> findByAttributeLeftContainsText(String attributeName, String text);

	public List<T> findEntityList(T req);

	public T findEntity(T req);

	public void delete(I id) throws Exception;

	public T deleteAll();

	public List<T> findByAttributeBetweenDate(String attributeName, String sfecha) throws Exception;

}
