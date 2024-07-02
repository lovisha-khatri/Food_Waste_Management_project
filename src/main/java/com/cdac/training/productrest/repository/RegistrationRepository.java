package com.cdac.training.productrest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.training.productrest.model.Registration;
public interface RegistrationRepository extends JpaRepository<Registration, Long> 
{
	
	public Optional<Registration> findByEmail(String email);
	boolean existsByEmail(String email);
	public Registration findByfname(String fname);
	

}
