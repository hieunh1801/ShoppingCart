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

import com.websitebanlaptop.common.dto.InvoiceDetailDTO;
import com.websitebanlaptop.common.dto.InvoiceDetailResponseDTO;
import com.websitebanlaptop.common.dto.InvoiceRequestDTO;
import com.websitebanlaptop.common.dto.InvoiceResponseDTO;
import com.websitebanlaptop.common.extensions.DateTimeExtension;
import com.websitebanlaptop.dao.entities.InvoiceDetailEntity;
import com.websitebanlaptop.dao.entities.InvoiceEntity;
import com.websitebanlaptop.dao.entities.LaptopEntity;
import com.websitebanlaptop.dao.entities.UserEntity;
import com.websitebanlaptop.dao.repositories.InvoiceDetailRepository;
import com.websitebanlaptop.dao.repositories.InvoiceRepository;
import com.websitebanlaptop.dao.repositories.LaptopRepository;
import com.websitebanlaptop.dao.repositories.SupplierRepository;
import com.websitebanlaptop.dao.repositories.UserRepository;
import com.websitebanlaptop.services.InvoiceService;


@Service
public class InvoiceServiceImpl implements InvoiceService {
	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LaptopRepository laptopRepository;

	@Autowired
	private InvoiceDetailRepository invoiceDetailRepository;

	@Autowired
	private SupplierRepository supplierRepository;

	private Logger LOGGER = LoggerFactory.getLogger(InvoiceServiceImpl.class);

	@Override
	public List<InvoiceResponseDTO> getAll() {
		List<InvoiceResponseDTO> invoices = new ArrayList<InvoiceResponseDTO>();

		try {
			for (InvoiceEntity invoice : invoiceRepository.findAll()) {
				InvoiceResponseDTO invoiceResponseDTO = new InvoiceResponseDTO();
				invoiceResponseDTO.setInvoiceId(invoice.getInvoiceId());
				invoiceResponseDTO.setCreatedDate(invoice.getCreatedDate());
				invoiceResponseDTO.setNotes(invoice.getNotes());
				invoiceResponseDTO.setEmployeeName(userRepository.getOne(invoice.getEmployeeId()).getFullName());
				for (InvoiceDetailEntity invoiceDetail : invoice.getInvoiceDetails()) {
					invoiceResponseDTO.setTotalPrice(
							invoiceResponseDTO.getTotalPrice() + invoiceDetail.getPrice() * invoiceDetail.getAmonut());
				}

				invoices.add(invoiceResponseDTO);
			}
		} catch (Exception e) {

			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}

		return invoices;
	}

	@Override
	public Page<InvoiceResponseDTO> getPageble(Pageable pageable) {
		Page<InvoiceEntity> invoices = invoiceRepository.findAll(pageable);
		
		try {
			Page<InvoiceResponseDTO> result = invoices.map(new Function<InvoiceEntity, InvoiceResponseDTO>() {
			    @Override
			    public InvoiceResponseDTO apply(InvoiceEntity invoice) {
			    	InvoiceResponseDTO invoiceResponseDTO = new InvoiceResponseDTO();
					invoiceResponseDTO.setInvoiceId(invoice.getInvoiceId());
					invoiceResponseDTO.setCreatedDate(invoice.getCreatedDate());
					invoiceResponseDTO.setNotes(invoice.getNotes());
					invoiceResponseDTO.setSupplierName(invoice.getSupplier().getName());
					invoiceResponseDTO.setEmployeeName(userRepository.getOne(invoice.getEmployeeId()).getFullName());
					for (InvoiceDetailEntity invoiceDetail : invoice.getInvoiceDetails()) {
						invoiceResponseDTO.setTotalPrice(
								invoiceResponseDTO.getTotalPrice() + invoiceDetail.getPrice() * invoiceDetail.getAmonut());
					}


			        return invoiceResponseDTO;
			    }
			});
			return result;
		} catch (Exception e) {

			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}

		return null;
	}
	

	@Override
	public int create(InvoiceRequestDTO invoice) {
		// TODO Auto-generated method stub
		try {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			UserEntity currentUser = userRepository.findByUserName(userDetails.getUsername());

			InvoiceEntity newInvoice = new InvoiceEntity(currentUser.getUserId(), DateTimeExtension.getCurrentDate(),
					invoice.getNotes(), supplierRepository.getOne(invoice.getSupplierId()));

			InvoiceEntity saveEntity = invoiceRepository.save(newInvoice);

			List<InvoiceDetailDTO> listInvoiceDetails = invoice.getListInvoiceDetails();

			for (InvoiceDetailDTO invoiceDetailDTO : listInvoiceDetails) {
				LaptopEntity laptop = laptopRepository.getOne(invoiceDetailDTO.getLaptopId());
				InvoiceDetailEntity invoiceDetail = new InvoiceDetailEntity(invoiceDetailDTO.getAmount(),
						invoiceDetailDTO.getPrice(), laptop, saveEntity);
				invoiceDetailRepository.save(invoiceDetail);

				int quantity = (laptop.getQuantity() == null) ? 0 : laptop.getQuantity();
				laptop.setQuantity(quantity + invoiceDetailDTO.getAmount());
				laptop.setPrice(invoiceDetailDTO.getPrice());
				laptopRepository.save(laptop);

			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	@Override
	public InvoiceDetailResponseDTO getInvoiceDetailById(int id) {
		try {
			InvoiceDetailResponseDTO response = new InvoiceDetailResponseDTO();
			InvoiceEntity invoice = invoiceRepository.getOne(id);
			
			// set value
			response.setInvoiceId(id);
			response.setCreatedDate(invoice.getCreatedDate());
			response.setNotes(invoice.getNotes());
			response.setSupplierName(invoice.getSupplier().getName());
			
			List<InvoiceDetailDTO> list = new ArrayList<InvoiceDetailDTO>();
			for (InvoiceDetailEntity invoiceDetail : invoice.getInvoiceDetails()) {
				InvoiceDetailDTO dto = new InvoiceDetailDTO();
				dto.setAmount(invoiceDetail.getAmonut());
				dto.setLaptopName(invoiceDetail.getLaptop().getName());
				dto.setLaptopId(invoiceDetail.getLaptop().getLaptopId());
				dto.setPrice(invoiceDetail.getPrice());
				dto.setInvoiceId(id);
				
				list.add(dto);
			}
			response.setListInvoiceDetails(list);
			
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		
		// TODO Auto-generated method stub
		return null;
	}
}
