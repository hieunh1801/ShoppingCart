package com.websitebanlaptop.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.websitebanlaptop.common.dto.FileRequestDTO;
import com.websitebanlaptop.common.dto.LaptopRequestDTO;
import com.websitebanlaptop.common.dto.ProductDisplayHomeDTO;
import com.websitebanlaptop.common.enums.LaptopStatusEnum;
import com.websitebanlaptop.common.extensions.FileExtension;
import com.websitebanlaptop.dao.entities.CategoryEntity;
import com.websitebanlaptop.dao.entities.LaptopEntity;
import com.websitebanlaptop.dao.entities.PromotionEntity;
import com.websitebanlaptop.dao.repositories.CategoryRepository;
import com.websitebanlaptop.dao.repositories.LaptopRepository;
import com.websitebanlaptop.dao.repositories.PromotionRepository;
import com.websitebanlaptop.services.LaptopService;

@Service
public class LaptopServiceImpl implements LaptopService {

	@Autowired
	private LaptopRepository laptopRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private PromotionRepository promotionRepository;

	private Logger LOGGER = LoggerFactory.getLogger(LaptopServiceImpl.class);

	@Override
	public List<LaptopEntity> getAll() {
		List<LaptopEntity> list = null;
		try {
			list = laptopRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return list;
	}

	@Override
	public Page<LaptopEntity> getPageable(Pageable pageable) {
		Page<LaptopEntity> laptops = null;
		try {
			laptops = laptopRepository.findAll(pageable);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return laptops;
	}
	
	@Override
	public int create(LaptopRequestDTO laptop) {
		String pathFile = FileExtension.saveFile(laptop.getImage());

		CategoryEntity categoryExist = categoryRepository.getOne(laptop.getCategoryId());

		LaptopEntity newLaptop = new LaptopEntity(laptop.getName(), laptop.getTitle(), laptop.getDescription(),
				laptop.getSize(), laptop.getWeight(), laptop.getHeight(), laptop.getColor(), pathFile,
				laptop.getMemory(), laptop.getOs(), laptop.getRam(), laptop.getCpu(), laptop.getBattery(),
				categoryExist, LaptopStatusEnum.ACTIVE.getStatus());

		try {
			laptopRepository.save(newLaptop);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	@Override
	public int update(LaptopRequestDTO laptop) {
		String pathFile = FileExtension.saveFile(laptop.getImage());

		CategoryEntity categoryExist = categoryRepository.getOne(laptop.getCategoryId());
		
		LaptopEntity laptopExist = laptopRepository.getOne(laptop.getLaptopId());

		LaptopEntity newLaptop = new LaptopEntity(laptop.getLaptopId(), laptop.getName(), laptop.getTitle(), laptop.getDescription(),
				laptopExist.getQuantity(),
				laptop.getSize(), laptop.getWeight(), laptop.getHeight(), laptop.getColor(), pathFile,
				laptop.getMemory(), laptop.getOs(), laptop.getRam(), laptop.getCpu(), laptop.getBattery(),
				categoryExist, laptop.getStatus());

		try {
			laptopRepository.save(newLaptop);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	@Override
	public int changeStatus(LaptopRequestDTO laptop) {
		// TODO Auto-generated method stub
		LaptopEntity laptopExist = laptopRepository.getOne(laptop.getLaptopId());
		
		laptopExist.setStatus(laptop.getStatus());
		
		laptopRepository.save(laptopExist);
		try {
			laptopRepository.save(laptopExist);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	@Override
	public String uploadImage(FileRequestDTO file) {
		String pathFile = "";
		try {
			pathFile = FileExtension.saveFile(file.getImage());
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return pathFile;
	}

	@Override
	public LaptopEntity getLapTopById(int id) {
		LaptopEntity laptop = null;
		try {
			laptop = laptopRepository.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return laptop;
	}

	@Override
	public List<ProductDisplayHomeDTO> getProductsPromotion() {
		// TODO Auto-generated method stub
		List<ProductDisplayHomeDTO> listLaptops = new ArrayList<ProductDisplayHomeDTO>();
		try {
			for (LaptopEntity laptopEntity : laptopRepository.findAll()) {
				List<PromotionEntity> promotions = promotionRepository.getAvailablePromotionsByLapTopId(laptopEntity.getLaptopId());
				if (promotions.size() > 0) {
					ProductDisplayHomeDTO laptopDisplayDTO = new ProductDisplayHomeDTO(laptopEntity.getLaptopId(), 
							laptopEntity.getName(), laptopEntity.getPrice(), promotions.get(0).getDiscount(), laptopEntity.getImage());
					listLaptops.add(laptopDisplayDTO);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return listLaptops;
	}

	@Override
	public List<ProductDisplayHomeDTO> getList18Products() {
		List<ProductDisplayHomeDTO> listLaptops = new ArrayList<ProductDisplayHomeDTO>();
		try {
			for (LaptopEntity laptopEntity : laptopRepository.getList18Products()) {
				List<PromotionEntity> promotions = promotionRepository.getAvailablePromotionsByLapTopId(laptopEntity.getLaptopId());
				if (promotions.size() > 0) {
					ProductDisplayHomeDTO laptopDisplayDTO = new ProductDisplayHomeDTO(laptopEntity.getLaptopId(), 
							laptopEntity.getName(), laptopEntity.getPrice(), promotions.get(0).getDiscount(), laptopEntity.getImage());
					listLaptops.add(laptopDisplayDTO);
				} else {
					ProductDisplayHomeDTO laptopDisplayDTO = new ProductDisplayHomeDTO();
					laptopDisplayDTO.setLaptopId(laptopEntity.getLaptopId());
					laptopDisplayDTO.setPrice(laptopEntity.getPrice());
					laptopDisplayDTO.setImage(laptopEntity.getImage());
					laptopDisplayDTO.setName(laptopEntity.getName());
					
					listLaptops.add(laptopDisplayDTO);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return listLaptops;
	}

	@Override
	public List<LaptopEntity> getLaptopsByIds(int[] ids) {
		// TODO Auto-generated method stub
		List<LaptopEntity> laptops = new ArrayList<LaptopEntity>();
		try {
			for (int id : ids) {
				LaptopEntity laptop = laptopRepository.getOne(id);
				if (laptop != null) {
					laptops.add(laptop);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return laptops;
	}
}
