package com.websitebanlaptop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websitebanlaptop.common.dto.PromotionRequestDTO;
import com.websitebanlaptop.common.dto.ResponseDataDTO;
import com.websitebanlaptop.common.utils.Constants;
import com.websitebanlaptop.dao.entities.PromotionEntity;
import com.websitebanlaptop.services.PromotionService;

@Controller
@RequestMapping("/api/promotion")
@CrossOrigin
public class PromotionController {
	@Autowired 
	private PromotionService promotionService;
	
	@GetMapping(value = "/page", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody ResponseDataDTO<Page<PromotionEntity>> getPageable(Pageable pageable) {
		ResponseDataDTO<Page<PromotionEntity>> response = new ResponseDataDTO<>();

		Page<PromotionEntity> promotions = null;

		try {
			promotions = promotionService.getPageble(pageable);
			response.setData(promotions);
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
	public @ResponseBody ResponseDataDTO<Integer> create(@RequestBody PromotionRequestDTO promotion) {
		ResponseDataDTO<Integer> response = new ResponseDataDTO<>();
		
		try {
			int result = promotionService.create(promotion);
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
