package com.apointmentManagementSystem.serviceImpl;

import org.springframework.stereotype.Service;

import com.apointmentManagementSystem.dto.AppointmentRequestDto;
import com.apointmentManagementSystem.enumEntity.AppointmentResponse;
import com.apointmentManagementSystem.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	@Override
	public void createAppointment(AppointmentRequestDto appointmentRequest, int loggedUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAppointment(int id, int loggedUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateResponseOfAppointment(int id, AppointmentResponse response, int loggedUser) {
		// TODO Auto-generated method stub
		
	}
	

}
