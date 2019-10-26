package com.websitebanlaptop.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.websitebanlaptop.common.dto.PromotionRequestDTO;
import com.websitebanlaptop.dao.entities.PromotionEntity;

public interface PromotionService {

	Page<PromotionEntity> getPageble(Pageable pageable);

	int create(PromotionRequestDTO promotion);
}
