package com.websitebanlaptop.common.dto;

import java.util.List;

import com.websitebanlaptop.dao.entities.LaptopEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {
	
	private List<LaptopEntity> listProducts;
	
	private String promotionValue;
}
