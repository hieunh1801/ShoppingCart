package com.websitebanlaptop.common.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class LaptopRequestDTO {
	private MultipartFile image;
	private int laptopId;
	private String name;
	private String title;
	private String description;
	private String size;
	private String weight;
	private String height;
	private String color;
	private String memory;
	private String os;
	private String ram;
	private String cpu;
	private String battery;
	private int categoryId;
	private int status;
}
