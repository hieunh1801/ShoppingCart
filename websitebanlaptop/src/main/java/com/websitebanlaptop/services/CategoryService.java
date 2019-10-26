package com.websitebanlaptop.services;

import java.util.List;

import com.websitebanlaptop.dao.entities.CategoryEntity;

public interface CategoryService {
	List<CategoryEntity> getAll();
	
	int create(CategoryEntity category);
}
