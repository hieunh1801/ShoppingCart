package com.websitebanlaptop.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.websitebanlaptop.dao.entities.PromotionEntity;

@Repository
public interface PromotionRepository extends JpaRepository<PromotionEntity, Integer> {

	@Query(value = "select * from tbPromotion where laptopid = :id and startdate <= GETDATE() and enddate >= GETDATE() order by discount desc", nativeQuery = true)
	List<PromotionEntity> getAvailablePromotionsByLapTopId(@Param("id") int laptopId);
	
	@Query(value = "select * from tbPromotion where value = :code and startdate  <= GETDATE() and GETDATE() <= enddate and laptopid = :id", nativeQuery = true)
	PromotionEntity getPromotionByCode(@Param("code") String code, @Param("id") int id);
}
