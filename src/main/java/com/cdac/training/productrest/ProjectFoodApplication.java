package com.cdac.training.productrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.cdac.training.productrest.service.EmailService;

@SpringBootApplication
public class ProjectFoodApplication {

	@Autowired
	private EmailService emailservice;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectFoodApplication.class, args);
	}
	
//	@EventListener(ApplicationReadyEvent.class)
//	public void sendemail()
//	{
//		emailservice.sendOtpEmail("yashiyi11@gamil.com", "123456");	
//	}

}
