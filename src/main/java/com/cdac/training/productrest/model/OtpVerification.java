package com.cdac.training.productrest.model;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class OtpVerification {

	int otp;

	public String generateOtp() {
		// Generate a random 6-digit OTP
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		setOtp(otp);
		return String.valueOf(otp);
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}
	
	

}
