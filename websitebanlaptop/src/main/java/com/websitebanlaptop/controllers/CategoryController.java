package com.websitebanlaptop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websitebanlaptop.common.dto.ResponseDataDTO;
import com.websitebanlaptop.common.utils.Constants;
import com.websitebanlaptop.dao.entities.CategoryEntity;
import com.websitebanlaptop.services.CategoryService;

@Controller
@RequestMapping("/api/categories")
@CrossOrigin
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value = "/all", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody ResponseDataDTO<List<CategoryEntity>> getAll() {
		ResponseDataDTO<List<CategoryEntity>> response = new ResponseDataDTO<>();

		List<CategoryEntity> categories = null;

		try {
			categories = categoryService.getAll();
			response.setData(categories);
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
	public @ResponseBody ResponseDataDTO<Integer> create(@RequestBody CategoryEntity category) {
		ResponseDataDTO<Integer> response = new ResponseDataDTO<>();
		try {
			int result = categoryService.create(category);
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
