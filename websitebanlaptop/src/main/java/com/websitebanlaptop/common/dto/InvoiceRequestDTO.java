package com.websitebanlaptop.common.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceRequestDTO {
	private int invoiceId;
	
	private int supplierId;
	
	private String notes;
	
	private List<InvoiceDetailDTO> listInvoiceDetails;
}
