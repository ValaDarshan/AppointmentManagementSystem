package com.apointmentManagementSystem.configuration;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.apointmentManagementSystem.entity.Role;
import com.apointmentManagementSystem.entity.User;
import com.apointmentManagementSystem.exception.ResourceNotFoundException;
import com.apointmentManagementSystem.repository.IRolePermissionRepository;
import com.apointmentManagementSystem.repository.IUserRepository;
import com.apointmentManagementSystem.utils.ErrorMessageConstant;

public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IRolePermissionRepository rolePermissionRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User getUser = userRepository.findByEmailIgnoreCaseAndIsActiveTrue(username).orElseThrow(() -> new ResourceNotFoundException(ErrorMessageConstant.INVALID_USERNAME_PASSWORD));
		return new CustomeUserDetail(getUser , getAuthority(getUser.getRole()));
	}
	
	public Set<SimpleGrantedAuthority> getAuthority(Role role) {
		
		Set<SimpleGrantedAuthority> authorities = rolePermissionRepository.findAllByRoleIdAndIsActiveTrue(role.getId()).stream()
																			 .map(rolePermission -> new SimpleGrantedAuthority(rolePermission.getPermission().getAction()))
																			 .collect(Collectors.toSet());
		authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
		
		return authorities;
		
		
	}

}
