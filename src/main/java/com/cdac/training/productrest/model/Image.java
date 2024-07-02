package com.cdac.training.productrest.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "imagetable")
@Data
@ToString
public class Image 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	private Long id;
	
	@Column(name = "event")
	private String event;
	
	@Column(name = "FirstName")
	private String fname;
	
	@Column(name = "LastName")
	private String lname;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "phoneNo")
	private String phoneNo;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "bestbefore")
	private String bestbefore;
	
	private String filename;
    
	
	//constructor
	
	public Image() {
		super();
	}
	

	


	public Image(Long id, String event, String fname, String lname, String email, String phoneNo, String description,
			String bestbefore, String filename) {
		super();
		this.id = id;
		this.event = event;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phoneNo = phoneNo;
		this.description = description;
		this.bestbefore = bestbefore;
		this.filename = filename;
	}





	//getter and setter methods
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEvent() {
		return event;
	}


	public void setEvent(String event) {
		this.event = event;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getBestbefore() {
		return bestbefore;
	}


	public void setBestbefore(String bestbefore) {
		this.bestbefore = bestbefore;
	}


	public String getImage() {
		return filename;
	}


	public void setImage(String filename) {
		this.filename = filename;
	}
}
