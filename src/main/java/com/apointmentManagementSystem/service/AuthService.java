package com.apointmentManagementSystem.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import com.apointmentManagementSystem.dto.AuthRequestDto;
import com.apointmentManagementSystem.dto.AuthResponseDto;

public interface AuthService {
	
	AuthResponseDto authenticateUser(AuthRequestDto authRequest) throws UserPrincipalNotFoundException;

}
