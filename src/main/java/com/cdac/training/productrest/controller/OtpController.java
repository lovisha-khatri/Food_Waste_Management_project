package com.cdac.training.productrest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.training.productrest.model.OtpVerification;
import com.cdac.training.productrest.model.Registration;
import com.cdac.training.productrest.service.EmailService;
import com.cdac.training.productrest.service.RegistrationService;

@RestController
public class OtpController {
	
	
	@Autowired
	private RegistrationService rservice;
    
    @Autowired
    private OtpVerification otpVerification;
   
    @Autowired
    private EmailService emailService;

    private String storedOtp; // Store the generated OTP temporarily for verification

    @PostMapping("/generate-otp")
    public String generateOtp(@RequestBody EmailService emailRequest) {
        String email = emailRequest.getEmail(); // Assuming email is a String
        
        // Generate OTP
         storedOtp = otpVerification.generateOtp();
        // Send OTP to the email address
        emailService.sendOtpEmail(email, storedOtp);
        
        // Indicate that OTP generation and sending were successful
        return storedOtp ;
    }

    
	
    @PostMapping("/verify-otp")
    public String verifyOtp(@RequestBody OtpVerification otpEnteredByUser) {
    	
    	if (storedOtp == null) {
 	        return "OTP not generated";
 	    }
      int otpnew=otpEnteredByUser.getOtp();
      int storedopt=Integer.parseInt(storedOtp);
        if (otpnew==storedopt) {
            // OTP is correct
            return "OTP verified successfully";
        } else {
            // OTP is incorrect
            return "Invalid OTP";            
        }
    }
}
