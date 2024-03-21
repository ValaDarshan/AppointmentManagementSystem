package com.apointmentManagementSystem.utils;

public class MailTemplate {
	
	public static String FORGOT_PASSWORD = "<div style=\"font-family: Arial, sans-serif; max-width: 600px; margin: 0 auto;\">\r\n"
			+ "        <p>Hello [USER NAME],</p>\r\n"
			+ "        <p>We received a request to reset your password. Please use the following One-Time Password (OTP) to reset your password:</p>\r\n"
			+ "        <h3 style=\"background-color: #f0f0f0; padding: 10px; border-radius: 5px;\">Your OTP: <span style=\"font-weight: bold; color: #4CAF50;\">[OTP]</span></h3>\r\n"
			+ "        <p>If you didn't request to reset your password, you can safely ignore this email. Your password will remain unchanged.</p>\r\n"
			+ "        <p>Thank you!</p>\r\n"
			+ "        <p>Best Regards,<br>Mr. Manager</p>\r\n"
			+ "    </div>";

}
