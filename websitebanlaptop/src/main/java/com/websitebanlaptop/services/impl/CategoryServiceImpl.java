package com.websitebanlaptop.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websitebanlaptop.dao.entities.CategoryEntity;
import com.websitebanlaptop.dao.repositories.CategoryRepository;
import com.websitebanlaptop.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	private Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);
	
	@Override
	public List<CategoryEntity> getAll() {
		List<CategoryEntity> categories = null;

		try {
			categories = categoryRepository.findAll();
		} catch (Exception e) {
			
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}

		return categories;
	}

	@Override
	public int create(CategoryEntity category) {
		try {
			categoryRepository.save(category);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}

		return 0;
	}

}
