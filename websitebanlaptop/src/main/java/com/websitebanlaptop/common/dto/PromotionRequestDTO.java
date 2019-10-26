package com.websitebanlaptop.common.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PromotionRequestDTO {
	private int laptopId;
	private double discount;
	private Timestamp startDate;
	private Timestamp endDate;
}
