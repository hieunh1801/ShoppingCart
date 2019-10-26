package com.websitebanlaptop.controllers;

import java.util.List;

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

import com.websitebanlaptop.common.dto.InvoiceDetailResponseDTO;
import com.websitebanlaptop.common.dto.InvoiceRequestDTO;
import com.websitebanlaptop.common.dto.InvoiceResponseDTO;
import com.websitebanlaptop.common.dto.ResponseDataDTO;
import com.websitebanlaptop.common.utils.Constants;
import com.websitebanlaptop.services.InvoiceService;

@Controller
@RequestMapping("/api/invoice")
@CrossOrigin
public class InvoiceController {
	@Autowired
	private InvoiceService invoiceService;
	
	@GetMapping(value = "/all", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody ResponseDataDTO<List<InvoiceResponseDTO>> getAll() {
		ResponseDataDTO<List<InvoiceResponseDTO>> response = new ResponseDataDTO<>();

		List<InvoiceResponseDTO> invoices = null;

		try {
			invoices = invoiceService.getAll();
			response.setData(invoices);
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
	
	@GetMapping(value = "/page", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody ResponseDataDTO<Page<InvoiceResponseDTO>> getPageable(Pageable pageable) {
		ResponseDataDTO<Page<InvoiceResponseDTO>> response = new ResponseDataDTO<>();

		Page<InvoiceResponseDTO> invoices = null;

		try {
			invoices = invoiceService.getPageble(pageable);
			response.setData(invoices);
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
	
	@GetMapping(value = "/getbyid/{id}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody ResponseDataDTO<InvoiceDetailResponseDTO> getInvoiceDetailById(@PathVariable("id") int id) {
		ResponseDataDTO<InvoiceDetailResponseDTO> response = new ResponseDataDTO<>();

		InvoiceDetailResponseDTO invoice = null;

		try {
			invoice = invoiceService.getInvoiceDetailById(id);
			response.setData(invoice);
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
	
	@PostMapping(value = "/create", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody ResponseDataDTO<Integer> create(@RequestBody InvoiceRequestDTO invoice) {
		ResponseDataDTO<Integer> response = new ResponseDataDTO<>();
		
		try {
			int result = invoiceService.create(invoice);
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
}
