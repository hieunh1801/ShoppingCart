package com.websitebanlaptop.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderDetailDTO {
	private String laptopName;
	private float price;
	private int quantity;
	private double totalPrice;
}
