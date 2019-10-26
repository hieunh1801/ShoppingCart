package com.websitebanlaptop.common.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDetailResponseDTO {
	private int invoiceId;
	
	private String supplierName;
	
	private String notes;
	
	private Timestamp createdDate;
	
	private List<InvoiceDetailDTO> listInvoiceDetails;
}
