package com.websitebanlaptop.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.websitebanlaptop.common.dto.OrderDetailDTO;
import com.websitebanlaptop.common.dto.OrderRequestDTO;
import com.websitebanlaptop.common.dto.OrderResponseDTO;
import com.websitebanlaptop.common.extensions.DateTimeExtension;
import com.websitebanlaptop.dao.entities.LaptopEntity;
import com.websitebanlaptop.dao.entities.OrderDetailEntity;
import com.websitebanlaptop.dao.entities.OrderEntity;
import com.websitebanlaptop.dao.entities.PromotionEntity;
import com.websitebanlaptop.dao.entities.UserEntity;
import com.websitebanlaptop.dao.repositories.OrderDetailRepository;
import com.websitebanlaptop.dao.repositories.OrderRepository;
import com.websitebanlaptop.dao.repositories.PromotionRepository;
import com.websitebanlaptop.dao.repositories.UserRepository;
import com.websitebanlaptop.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PromotionRepository promotionRepository;
	
	private Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Override
	public int create(OrderRequestDTO order) {
		// TODO Auto-generated method stub
		try {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			
			UserEntity currentUser = userRepository.findByUserName(userDetails.getUsername());
			
			Double totalPrice = 0d;
			
			List<OrderDetailEntity> lisOrderDetailEntities = new ArrayList<OrderDetailEntity>();
			
			for (LaptopEntity product: order.getListProducts()) {
				PromotionEntity promotion = promotionRepository.getPromotionByCode(order.getPromotionValue(), product.getLaptopId());
				if (promotion != null) {
					totalPrice = totalPrice + promotion.getDiscount() / 100 * (product.getPrice() *  product.getQuantity());
					
					OrderDetailEntity orderDetail = new OrderDetailEntity(promotion.getDiscount() / 100 * (product.getPrice() *  product.getQuantity()), 
							product.getQuantity(), product);
					lisOrderDetailEntities.add(orderDetail);
				} else {
					totalPrice = totalPrice + product.getPrice() * product.getQuantity();
					
					OrderDetailEntity orderDetail = new OrderDetailEntity((double)(product.getPrice() *  product.getQuantity()), 
							product.getQuantity(), product);
					lisOrderDetailEntities.add(orderDetail);
				}
			}
			
			OrderEntity newOrder = new OrderEntity(true, DateTimeExtension.getCurrentDate(), totalPrice, "", currentUser.getUserId());
			
			OrderEntity orderEntity = orderRepository.save(newOrder);
			
			for (OrderDetailEntity orderDetailEntity : lisOrderDetailEntities) {
				orderDetailEntity.setOrder(orderEntity);
				orderDetailRepository.save(orderDetailEntity);
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	@Override
	public Page<OrderResponseDTO> getPageble(Pageable pageable) {
		Page<OrderEntity> orders = orderRepository.findAll(pageable);
		
		try {
			Page<OrderResponseDTO> result = orders.map(new Function<OrderEntity, OrderResponseDTO>() {
			    @Override
			    public OrderResponseDTO apply(OrderEntity order) {
			    	OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
				
			    	orderResponseDTO.setOrderId(order.getOrderId());
					orderResponseDTO.setUserName(userRepository.getOne(order.getCustomerId()).getFullName());
					orderResponseDTO.setCreatedate(order.getCreateDate());
					orderResponseDTO.setTotalPrice(order.getTotalPrice());
					orderResponseDTO.setTotalItems(order.getOrderDetails().size());


			        return orderResponseDTO;
			    }
			});
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderResponseDTO getOrderDetailById(int id) {
		OrderEntity order = orderRepository.getOne(id);
		
		try {
			OrderResponseDTO dto = new OrderResponseDTO();
			dto.setOrderId(id);
			dto.setCreatedate(order.getCreateDate());
			dto.setTotalItems(order.getOrderDetails().size());
			dto.setTotalPrice(order.getTotalPrice());
			dto.setUserName(userRepository.getOne(order.getCustomerId()).getFullName());
			dto.setAddress(userRepository.getOne(order.getCustomerId()).getAddress());
			dto.setPhone(userRepository.getOne(order.getCustomerId()).getPhone());
			
			List<OrderDetailDTO> listOrderDetails = new ArrayList<OrderDetailDTO>();
			for (OrderDetailEntity orderDetail : order.getOrderDetails()) {
				OrderDetailDTO orderDetailDTO = new OrderDetailDTO(orderDetail.getLaptop().getName(), orderDetail.getLaptop().getPrice(), 
						orderDetail.getQuantity(), orderDetail.getTotalprice());
				listOrderDetails.add(orderDetailDTO);
			}
			
			dto.setListOrderDetails(listOrderDetails);
			
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	
}
