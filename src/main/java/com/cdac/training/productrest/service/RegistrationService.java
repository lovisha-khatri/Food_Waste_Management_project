package com.cdac.training.productrest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.training.productrest.model.Registration;
import com.cdac.training.productrest.repository.RegistrationRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegistrationService {
	
	@Autowired
	private  RegistrationRepository repo;
	
	public Registration registerpage(Registration d)
	{
		return repo.save(d);
	}
	
	public Optional<Registration> loginpage(String email)
	{
		return repo.findByEmail(email);
	}
	public Registration saveUser(Registration registration) {
        return repo.save(registration);
    }
	
	
}
