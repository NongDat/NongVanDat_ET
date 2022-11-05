package com.rrs.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rrs.entity.Video;

public interface VideoDao extends JpaRepository<Video, Long>{
	@Query("SELECT v FROM Video v WHERE v.seri = ?1")
	Video getListBySeri(Long seri);
}
