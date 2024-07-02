package com.cdac.training.productrest.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

	@Service
	public class EmailService {
		
		 public EmailService() {
		        // Default constructor
		    }

		 private String serviceId;
		   
	    @Autowired
	    private JavaMailSender javaMailSender;

	    public EmailService(JavaMailSender javaMailSender) {
	        this.javaMailSender = javaMailSender;
	    }

	    public void sendOtpEmail(String to, String otp) {
	        
	        SimpleMailMessage message = new SimpleMailMessage();
	        
	        message.setFrom("foodgmail.com"); // Update with your email address
	       
	        message.setTo(to);
	      
	        message.setSubject("Your OTP for Verification");
	        
	        message.setText("Your OTP is: " + otp);
	       
	        System.out.print(message);
//	      
	        javaMailSender.send(message);
	        
	    }
		 private String email;

		    // Getter and setter methods
		    public String getEmail() {
		        return email;
		    }

		    public void setEmail(String email) {
		        this.email = email;
		    }
	    }
