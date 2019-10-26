package com.websitebanlaptop.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDetailDTO {
	private int invoiceId;
	
	private int laptopId;
	
	private String laptopName;
	
	private int amount;
	
	private float price;
}
