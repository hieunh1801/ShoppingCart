package com.websitebanlaptop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.websitebanlaptop")
	public class WebsitebanlaptopApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebsitebanlaptopApplication.class, args);
	}
}
