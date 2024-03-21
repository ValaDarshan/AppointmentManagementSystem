package com.apointmentManagementSystem.service;

import java.time.LocalDateTime;

public interface OtpService {
	
	void saveOtp(String email, String otp, int userId, LocalDateTime expiry);
	
	

}
