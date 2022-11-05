package com.rrs.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rrs.entity.BookOnTape;
public interface BookOntapeDao extends JpaRepository<BookOnTape, Long>{
	@Query("SELECT b FROM BookOnTape b WHERE b.seri =?1")
	BookOnTape getBookBySeri(Long seri);
}
