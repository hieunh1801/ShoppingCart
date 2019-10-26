package com.websitebanlaptop.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.websitebanlaptop.common.dto.LoginRequestDTO;
import com.websitebanlaptop.common.dto.LoginResponseDTO;
import com.websitebanlaptop.common.dto.ResponseDataDTO;
import com.websitebanlaptop.common.filters.JwtTokenProvider;
import com.websitebanlaptop.common.utils.Constants;
import com.websitebanlaptop.dao.entities.CustomUserDetails;

@RestController
public class AuthenticationController {
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@PostMapping(value = "/login", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseDataDTO<LoginResponseDTO> login(@RequestBody LoginRequestDTO user) {
		// Authentication from user name and password
		Authentication authentication = authenticationManager
											.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
		
		ResponseDataDTO<LoginResponseDTO> response = new ResponseDataDTO<LoginResponseDTO>();
		response.setData(new LoginResponseDTO(jwt));
		response.setCode(Constants.SUCCESS_CODE);
		response.setMessage(Constants.SUCCESS_MSG);
		
		return response;
	}
}
