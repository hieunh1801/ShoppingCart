package com.websitebanlaptop.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDisplayHomeDTO {
	private int laptopId;
	private String name;
	private Float price;
	private double discount;
	private String image;
}
