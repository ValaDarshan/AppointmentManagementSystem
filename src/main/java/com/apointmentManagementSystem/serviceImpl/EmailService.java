package com.apointmentManagementSystem.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	@Value("${spring.mail.username}")
	private String sender;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendMail(String emailTo, String subject , String body) throws MessagingException {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setFrom(sender);
		helper.setTo(emailTo);
		helper.setSubject(subject);
		helper.setText(body);
		helper.setSentDate(new Date());
		
		javaMailSender.send(message);

	}

}
