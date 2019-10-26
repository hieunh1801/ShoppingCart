package com.websitebanlaptop.dao.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.websitebanlaptop.dao.entities.LaptopEntity;

@Repository
public interface LaptopRepository extends JpaRepository<LaptopEntity, Integer> {
	@Query(value = "select * from tbLaptop", nativeQuery = true)
	List<LaptopEntity> findAll();
	
	@Query(value = "select TOP 18 * from tbLaptop where tbLaptop.quantity > 0 order by laptopid desc ", nativeQuery = true)
	List<LaptopEntity> getList18Products();
	
	@Query(value = "select * from tbLaptop where tbLaptop.laptopId = :id", nativeQuery = true)
	LaptopEntity getOne(@Param("id") int id);
}
