package com.apointmentManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apointmentManagementSystem.dto.AuthRequestDto;
import com.apointmentManagementSystem.dto.ErrorMessageResponseDto;
import com.apointmentManagementSystem.dto.MessageResponseDto;
import com.apointmentManagementSystem.service.AuthService;
import com.apointmentManagementSystem.utils.ApiUrl;

@RestController
@RequestMapping(ApiUrl.AUTH)
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody AuthRequestDto authRequest){
		try {
			
			return ResponseEntity.ok(new MessageResponseDto("Login successfully" , authService.authenticateUser(authRequest) , 200));
		}
		catch(Exception e) {
			return ResponseEntity.badRequest().body(new ErrorMessageResponseDto(e.getMessage() , 400));
		}
	}
	
	

}
