package com.cdac.training.productrest.controller;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.cdac.training.productrest.model.Registration;
import com.cdac.training.productrest.service.RegistrationService;

@Controller
public class RegistrationController {
	
	@Autowired
	private RegistrationService rservice;
	
	@GetMapping("/forgot")
	public String forgotpage()
	{
		return "forgot-password";
	}
	
	@PostMapping("/forgot-password")
	    public ResponseEntity<String> showForgotPasswordForm(@RequestBody Registration registration) {
	       
	        String email=registration.getEmail();
	        Registration r;
			try {
				r = rservice.loginpage(email).orElseThrow(() ->
				        new RelationNotFoundException("User not found for this email: " + email));
				
				 if (email.equals(r.getEmail())) {
			            System.out.println("Found the email for the forgot page: " + email);
			            return ResponseEntity.ok("Email exist");
			}
			}catch (RelationNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.print("Email doesn't found");
	        }
	        return  ResponseEntity.ok("Email doesn't exists");
	    }
	@PostMapping("/security")
	public ResponseEntity<Boolean> showSecurityForm(@RequestBody  Registration registration )
	{
		String email= registration.getEmail();
		String food1= registration.getFood();
		 Registration r;
			try {
				r = rservice.loginpage(email).orElseThrow(() ->
				        new RelationNotFoundException("User not found for this email: " + email));
					 if(email.equals(r.getEmail()))
					 {
						 if(food1.equals(r.getFood()))
						 {
							 
			            return ResponseEntity.ok(true);
						 }
					 }
			}catch (RelationNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.print("Email doesn't found"+email);
	        }
	        return  ResponseEntity.ok(false);
	}
	
	@GetMapping("/")
	public String index()
	{
		return "homepage1";
	}
	
	@GetMapping("/hello")
	public String  getpage()
	{
		return "signup";
	}
	@GetMapping("/tushar")
	public String getlogin()
	{
		return "signin";
	}
	@PostMapping("/register")
	public ResponseEntity<String> register(@Validated @RequestBody Registration registration)
	{
	
		
		try
		{
			Registration foodregistration =rservice.registerpage(registration);
			if(foodregistration!=null)
			{
				return ResponseEntity.ok("Registration successful");
			}
			else
			{
				return ResponseEntity.badRequest().body("Registration failed");
			}
		}catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An Error ocurred: "+e.getMessage());
		}
	}
	
    @PostMapping("/login")
    public ResponseEntity<String> loginDealer(@Validated @RequestBody Registration registration) throws RelationNotFoundException
    {

    	String email=registration.getEmail();
    	String password=registration.getPassword();	
    	
    	Registration r= rservice.loginpage(email).orElseThrow(() ->
    	new RelationNotFoundException("User not Found for  This email ::"+  email));
    	
    	if (email.trim().equals(r.getEmail().trim()) && password.equals(r.getPassword())) {
    		if(r.getRadio().equals("user"))
    		{
    			return ResponseEntity.ok("user");
    		}
    		if(r.getRadio().equals("ngo"))
    			{
    			return ResponseEntity.ok("ngo");
    			}
    	}
    	return ResponseEntity.ok("Not Found");
    }
   
    @PostMapping("/updatePassword")
    public ResponseEntity<String> changePassword(@RequestBody Registration registration) throws RelationNotFoundException {
        String email = registration.getEmail();
        String newPassword = registration.getPassword();
        
        // Retrieve the user by email
        Registration user = rservice.loginpage(email).orElseThrow(() ->
                new RelationNotFoundException("User not found for this email: " + email));

        // Check if the provided password matches the old password
        if (!newPassword.equals(user.getPassword())) {
            // Update the password
            user.setPassword(newPassword);
            
            // Save the updated user with the new password
            rservice.saveUser(user);
            
            return ResponseEntity.ok("Your password has been successfully updated.");
        } else {
            return ResponseEntity.badRequest().body("Your old password and  the new  password are same.");
        }
    }

}
