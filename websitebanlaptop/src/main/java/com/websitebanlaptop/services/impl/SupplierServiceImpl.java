package com.websitebanlaptop.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websitebanlaptop.dao.entities.SupplierEntity;
import com.websitebanlaptop.dao.repositories.SupplierRepository;
import com.websitebanlaptop.services.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;
	
	private Logger LOGGER = LoggerFactory.getLogger(SupplierServiceImpl.class);
	
	@Override
	public List<SupplierEntity> getAll() {
		List<SupplierEntity> list = null;
		// TODO Auto-generated method stub
		try {
			list = supplierRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return list;
	}

}
