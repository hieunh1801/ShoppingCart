package com.websitebanlaptop.controllers.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websitebanlaptop.common.dto.ProductDisplayHomeDTO;
import com.websitebanlaptop.common.dto.ResponseDataDTO;
import com.websitebanlaptop.common.utils.Constants;
import com.websitebanlaptop.dao.entities.LaptopEntity;
import com.websitebanlaptop.dao.entities.SupplierEntity;
import com.websitebanlaptop.services.LaptopService;
import com.websitebanlaptop.services.SupplierService;

@Controller
@RequestMapping("/home/product")
@CrossOrigin
public class ProductHomeController {
	@Autowired
	private LaptopService laptopService;
	
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping(value = "/get-products-promotion", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody ResponseDataDTO<List<ProductDisplayHomeDTO>> getProductsPromotion() {
		ResponseDataDTO<List<ProductDisplayHomeDTO>> response = new ResponseDataDTO<>();

		List<ProductDisplayHomeDTO> laptops = null;

		try {
			laptops = laptopService.getProductsPromotion();
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
	
	@GetMapping(value = "/all", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody ResponseDataDTO<List<ProductDisplayHomeDTO>> getListProducts() {
		ResponseDataDTO<List<ProductDisplayHomeDTO>> response = new ResponseDataDTO<>();

		List<ProductDisplayHomeDTO> laptops = null;

		try {
			laptops = laptopService.getList18Products();
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
	
	@GetMapping(value = "/get-laptops-by-ids/{ids}", 
			produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody ResponseDataDTO<List<LaptopEntity>> getLaptopById(@PathVariable("ids") int[] ids) {
		ResponseDataDTO<List<LaptopEntity>> response = new ResponseDataDTO<>();

		List<LaptopEntity> laptops = null;

		try {
			laptops = laptopService.getLaptopsByIds(ids);
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
	
	@GetMapping(value = "/suppliers", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
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
