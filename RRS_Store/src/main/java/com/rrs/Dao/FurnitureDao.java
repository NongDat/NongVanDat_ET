package com.rrs.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rrs.entity.Furniture;

public interface FurnitureDao extends JpaRepository<Furniture, Long>{
	@Query("SELECT f FROM Furniture f WHERE f.seri = ?1")
	Furniture getFurnitureBySeri(Long seri);
}
