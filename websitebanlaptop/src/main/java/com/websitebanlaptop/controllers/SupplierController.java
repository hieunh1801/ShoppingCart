package com.websitebanlaptop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websitebanlaptop.common.dto.ResponseDataDTO;
import com.websitebanlaptop.common.utils.Constants;
import com.websitebanlaptop.dao.entities.SupplierEntity;
import com.websitebanlaptop.services.SupplierService;

@Controller
@RequestMapping("/api/supplier")
@CrossOrigin
public class SupplierController {
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping(value = "/all", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody ResponseDataDTO<List<SupplierEntity>> getAll() {
		ResponseDataDTO<List<SupplierEntity>> response = new ResponseDataDTO<>();

		List<SupplierEntity> suppliers = null;

		try {
			suppliers = supplierService.getAll();
			response.setData(suppliers);
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
