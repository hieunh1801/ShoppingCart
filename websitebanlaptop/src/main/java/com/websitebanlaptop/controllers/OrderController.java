package com.websitebanlaptop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websitebanlaptop.common.dto.OrderRequestDTO;
import com.websitebanlaptop.common.dto.OrderResponseDTO;
import com.websitebanlaptop.common.dto.ResponseDataDTO;
import com.websitebanlaptop.common.utils.Constants;
import com.websitebanlaptop.services.OrderService;

@Controller
@RequestMapping("/api/order")
@CrossOrigin
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping(value = "/create", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody ResponseDataDTO<Integer> create(@RequestBody OrderRequestDTO order) {
		ResponseDataDTO<Integer> response = new ResponseDataDTO<>();
		
		try {
			int result = orderService.create(order);
			response.setData(result);
			response.setCode(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS_MSG);
		} catch (Exception e) {
			// TODO: handle exception
			response.setData(0);
			response.setCode(Constants.ERR_CODE_BAD_REQUEST);
			response.setMessage(Constants.MSG_TEMP + Constants.ERR_MSG_BAD_REQUEST);
			
			e.printStackTrace();
		}

		return response;
		
	}
	
	@GetMapping(value = "/page", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody ResponseDataDTO<Page<OrderResponseDTO>> getPageable(Pageable pageable) {
		ResponseDataDTO<Page<OrderResponseDTO>> response = new ResponseDataDTO<>();

		Page<OrderResponseDTO> orders = null;

		try {
			orders = orderService.getPageble(pageable);
			response.setData(orders);
			response.setCode(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS_MSG);
		} catch (Exception e) {
			// TODO: handle exception
			response.setData(null);
			response.setCode(Constants.ERR_CODE_BAD_REQUEST);
			response.setMessage(Constants.MSG_TEMP + Constants.ERR_MSG_BAD_REQUEST);
		}

		return response;
	}
	
	@GetMapping(value = "/get-order-by-id/{id}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody ResponseDataDTO<OrderResponseDTO> getOrderDetailById(@PathVariable("id") int id) {
		ResponseDataDTO<OrderResponseDTO> response = new ResponseDataDTO<>();

		OrderResponseDTO order = null;

		try {
			order = orderService.getOrderDetailById(id);
			response.setData(order);
			response.setCode(Constants.SUCCESS_CODE);
			response.setMessage(Constants.SUCCESS_MSG);
		} catch (Exception e) {
			// TODO: handle exception
			response.setData(null);
			response.setCode(Constants.ERR_CODE_BAD_REQUEST);
			response.setMessage(Constants.MSG_TEMP + Constants.ERR_MSG_BAD_REQUEST);
		}

		return response;
	}
	
	
}
