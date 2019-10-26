package com.websitebanlaptop.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.websitebanlaptop.common.dto.InvoiceDetailResponseDTO;
import com.websitebanlaptop.common.dto.InvoiceRequestDTO;
import com.websitebanlaptop.common.dto.InvoiceResponseDTO;

public interface InvoiceService {

	List<InvoiceResponseDTO> getAll();

	int create(InvoiceRequestDTO invoice);

	Page<InvoiceResponseDTO> getPageble(Pageable pageable);

	InvoiceDetailResponseDTO getInvoiceDetailById(int id);
}
