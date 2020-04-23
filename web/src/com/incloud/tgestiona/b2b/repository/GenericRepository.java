package com.incloud.tgestiona.b2b.repository;

public interface GenericRepository<T> {

	T create(T t);

	void delete(T t);

	T find(T t);

	T update(T t);

	Iterable<T> findAll();
}