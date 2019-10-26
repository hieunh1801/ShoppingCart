package com.websitebanlaptop.services.impl;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.websitebanlaptop.common.dto.PromotionRequestDTO;
import com.websitebanlaptop.common.extensions.PromotionExtension;
import com.websitebanlaptop.dao.entities.PromotionEntity;
import com.websitebanlaptop.dao.repositories.LaptopRepository;
import com.websitebanlaptop.dao.repositories.PromotionRepository;
import com.websitebanlaptop.services.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService {
	@Autowired
	private PromotionRepository promotionRepository;
	
	@Autowired
	private LaptopRepository laptopRepository;
	
	private Logger LOGGER = LoggerFactory.getLogger(PromotionServiceImpl.class);
	
	@Override
	public Page<PromotionEntity> getPageble(Pageable pageable) {
		// TODO Auto-generated method stub
		try {
			Page<PromotionEntity> page = promotionRepository.findAll(pageable);
			return page;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int create(PromotionRequestDTO promotion) {
		try {
			PromotionEntity newPromotion = 
					new PromotionEntity(PromotionExtension.generateRandomCode(), promotion.getDiscount(), 
							promotion.getStartDate(), promotion.getEndDate(), laptopRepository.getOne(promotion.getLaptopId()));
			
			promotionRepository.save(newPromotion);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
	
	
}
