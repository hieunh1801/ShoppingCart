package com.websitebanlaptop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websitebanlaptop.common.dto.FileRequestDTO;
import com.websitebanlaptop.common.dto.LaptopRequestDTO;
import com.websitebanlaptop.common.dto.ResponseDataDTO;
import com.websitebanlaptop.common.utils.Constants;
import com.websitebanlaptop.dao.entities.LaptopEntity;
import com.websitebanlaptop.services.LaptopService;

@Controller
@RequestMapping("/api/products")
@CrossOrigin
public class LaptopController {
	@Autowired
	private LaptopService laptopService;
	
	@GetMapping(value = "/all", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody ResponseDataDTO<List<LaptopEntity>> getAll() {
		ResponseDataDTO<List<LaptopEntity>> response = new ResponseDataDTO<>();

		List<LaptopEntity> laptops = null;

		try {
			laptops = laptopService.getAll();
			response.setData(laptops);
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
	public @ResponseBody ResponseDataDTO<Page<LaptopEntity>> getPageable(Pageable pageable) {
		ResponseDataDTO<Page<LaptopEntity>> response = new ResponseDataDTO<>();

		Page<LaptopEntity> laptops = null;

		try {
			laptops = laptopService.getPageable(pageable);
			response.setData(laptops);
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
	public @ResponseBody ResponseDataDTO<LaptopEntity> getLaptopById(@PathVariable("id") int id) {
		ResponseDataDTO<LaptopEntity> response = new ResponseDataDTO<>();

		LaptopEntity laptop = null;

		try {
			laptop = laptopService.getLapTopById(id);
			response.setData(laptop);
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
	
	@PostMapping(value = "/create", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public @ResponseBody ResponseDataDTO<Integer> create(@ModelAttribute LaptopRequestDTO laptop) {
		ResponseDataDTO<Integer> response = new ResponseDataDTO<>();
		try {
			response.setData(laptopService.create(laptop));
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
	
	@PostMapping(value = "/upload-image", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public @ResponseBody ResponseDataDTO<String> uploadImage(@ModelAttribute FileRequestDTO file) {
		ResponseDataDTO<String> response = new ResponseDataDTO<>();
		try {
			response.setData(laptopService.uploadImage(file));
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
	
	@PutMapping(value = "/update", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public @ResponseBody ResponseDataDTO<Integer> update(@ModelAttribute LaptopRequestDTO laptop) {
		ResponseDataDTO<Integer> response = new ResponseDataDTO<>();
		try {
			response.setData(laptopService.update(laptop));
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
	
	@PutMapping(value = "/change-status", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseDataDTO<Integer> delete(@RequestBody LaptopRequestDTO laptop) {
		ResponseDataDTO<Integer> response = new ResponseDataDTO<>();
		try {
			response.setData(laptopService.changeStatus(laptop));
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
