package com.apointmentManagementSystem.serviceImpl;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.apointmentManagementSystem.configuration.CustomeUserDetail;
import com.apointmentManagementSystem.dto.AuthRequestDto;
import com.apointmentManagementSystem.dto.AuthResponseDto;
import com.apointmentManagementSystem.entity.User;
import com.apointmentManagementSystem.repository.IUserRepository;
import com.apointmentManagementSystem.service.AuthService;
import com.apointmentManagementSystem.service.JwtFilterService;
import com.apointmentManagementSystem.utils.ErrorMessageConstant;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private IUserRepository userRepository;


	@Autowired
	private JwtFilterService jwtService;

	@Autowired
	private AuthenticationManager authManager;


	@Override
	public AuthResponseDto authenticateUser(AuthRequestDto authRequest) throws UserPrincipalNotFoundException {
	
		authManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), 
																		 authRequest.getPassword()));
		
		User getUser = userRepository.findByEmailIgnoreCaseAndIsActiveTrue(authRequest.getEmail())
									 .orElseThrow(() -> new UserPrincipalNotFoundException(ErrorMessageConstant.INVALID_USERNAME_PASSWORD));

		String jwtToken = jwtService.generateToken(new CustomeUserDetail(getUser));
		
		return new AuthResponseDto(jwtToken , getUser.getId());
		
		

	}

}
