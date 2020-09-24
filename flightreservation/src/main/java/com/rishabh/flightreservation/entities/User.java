package com.rishabh.flightreservation.entities;

import javax.persistence.Entity;


@Entity
public class User extends AbstarctEntity {
	
	private String firstName;
	private String lastName;
	private String email;
	
	
	public String getFirstname() {
		return firstName;
	}
	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}
	public String getLastname() {
		return lastName;
	}
	public void setLastname(String lastname) {
		this.lastName = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	

}
