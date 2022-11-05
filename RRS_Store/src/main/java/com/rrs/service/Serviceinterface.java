package com.rrs.service;

import java.util.List;

public interface Serviceinterface<T> {
	// create Entity
	public void add(T entity);
	// update Entity
	public void update(Long id, T entity);
	// delete Entity
	public void delete(Long id);
	// get List Entity
	public List<T> getAll();
	// get Entity by Id
	public T getById(Long id);
	// get Entity by Serial
	public T getBySeri(Long seri);
}
