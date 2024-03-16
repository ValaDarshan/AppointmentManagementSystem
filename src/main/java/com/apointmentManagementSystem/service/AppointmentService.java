package com.apointmentManagementSystem.service;

import com.apointmentManagementSystem.dto.AppointmentRequestDto;
import com.apointmentManagementSystem.enumEntity.AppointmentResponse;

public interface AppointmentService {
	
	void createAppointment(AppointmentRequestDto appointmentRequest , int loggedUser);
	void deleteAppointment(int id  , int loggedUser);
	void updateResponseOfAppointment(int id , AppointmentResponse response , int loggedUser);
	
	
//	void removeAppointmentWithDeveloper()
	
}
