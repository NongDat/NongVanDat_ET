package com.rrs.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrs.Dao.BookOntapeDao;
import com.rrs.entity.BookOnTape;
import com.rrs.service.Serviceinterface;

@Service
public class BookOnTapeServiceImpl implements Serviceinterface<BookOnTape>{

	@Autowired
	BookOntapeDao dao;
	
	@Override
	public void add(BookOnTape entity) {
		dao.save(entity);
	}

	@Override
	public void update(Long id, BookOnTape entity) {
		
	}

	@Override
	public void delete(Long id) {
		dao.deleteById(id);
	}

	@Override
	public List<BookOnTape> getAll() {
		return dao.findAll();
	}

	@Override
	public BookOnTape getById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public BookOnTape getBySeri(Long seri) {
		return dao.getBookBySeri(seri);
	}

}
