package com.apointmentManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequestDto {
	
	private String firstName;
	private String lastName;
	private String email;
	private int role;
	
}
