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
public class OrderResponseDTO {
	private int orderId;
	private String userName;
	private String phone;
	private String address;
	private Timestamp createdate;
	private double totalPrice;
	private int totalItems;
	
	private List<OrderDetailDTO> listOrderDetails;
}
