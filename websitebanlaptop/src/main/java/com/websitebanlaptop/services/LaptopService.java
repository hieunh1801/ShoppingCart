package com.websitebanlaptop.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.websitebanlaptop.common.dto.FileRequestDTO;
import com.websitebanlaptop.common.dto.LaptopRequestDTO;
import com.websitebanlaptop.common.dto.ProductDisplayHomeDTO;
import com.websitebanlaptop.dao.entities.LaptopEntity;

public interface LaptopService {
	List<LaptopEntity> getAll();
	
	Page<LaptopEntity> getPageable(Pageable pageable);
	
	int create(LaptopRequestDTO laptop);
	
	int update(LaptopRequestDTO laptop);
	
	int changeStatus(LaptopRequestDTO laptop);
	
	String uploadImage(FileRequestDTO file);

	LaptopEntity getLapTopById(int id);

	List<ProductDisplayHomeDTO> getProductsPromotion();

	List<ProductDisplayHomeDTO> getList18Products();

	List<LaptopEntity> getLaptopsByIds(int[] ids);
}
