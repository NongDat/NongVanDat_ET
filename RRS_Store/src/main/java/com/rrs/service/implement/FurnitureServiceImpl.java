package com.rrs.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrs.Dao.FurnitureDao;
import com.rrs.entity.Furniture;
import com.rrs.service.Serviceinterface;

@Service
public class FurnitureServiceImpl implements Serviceinterface<Furniture>{
	@Autowired
	FurnitureDao dao;
	
	@Override
	public void add(Furniture entity) {
		dao.save(entity);
	}

	@Override
	public void update(Long id, Furniture entity) {
		dao.save(entity);
	}

	@Override
	public void delete(Long id) {
		dao.deleteById(id);
	}

	@Override
	public List<Furniture> getAll() {
		return dao.findAll();
	}

	@Override
	public Furniture getById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public Furniture getBySeri(Long seri) {
		return dao.getFurnitureBySeri(seri);
	}

}
