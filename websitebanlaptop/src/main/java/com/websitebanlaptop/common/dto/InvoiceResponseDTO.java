package com.websitebanlaptop.common.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceResponseDTO {
	private int invoiceId;
	private String supplierName;
	private String employeeName;
	private Timestamp createdDate;
	private String notes;
	private float totalPrice;
}
