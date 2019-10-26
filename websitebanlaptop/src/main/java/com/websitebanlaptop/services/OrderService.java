package com.websitebanlaptop.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.websitebanlaptop.common.dto.OrderRequestDTO;
import com.websitebanlaptop.common.dto.OrderResponseDTO;

public interface OrderService {
	int create(OrderRequestDTO order);

	Page<OrderResponseDTO> getPageble(Pageable pageable);

	OrderResponseDTO getOrderDetailById(int id);
}
