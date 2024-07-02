package com.cdac.training.productrest.model;

import jakarta.persistence.*;

@Entity
public class Registration {
	
	@Override
	public String toString() {
		return "Registrationdataoftheclasss [id=" + id + ", email=" + email + ", fname=" + fname + ", lname=" + lname + ", password="
				+ password + " , food=" +food + " ,radio =" +radio + "  ]";
	}

	@Id //Primary Key
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String email;
	 
	@Column(name="first_name")
	private String fname;
	
	@Column(name="last_name")
	private String lname;
	
	private String password;
	
	@Column(name="food_name")
	private String food;
	
	@Column(name="radio_data")
	private String radio;

	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Registration(Long id, String email, String fname, String lname, String password,String food,String radio) {
		super();
		this.id = id;
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.password = password;
		this.food=food;
		this.radio=radio;
		
	}

	public String getRadio() {
		return radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	

	
	
}
