package com.rishabh.clinicals.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Override
	public String toString() {
		return "Patient [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", age=" + age
				+ ", clientdata=" + clientdata + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String lastName,firstName;
	private int age;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="patient")
	private List<ClinicalData> clientdata;
	
	public List<ClinicalData> getClientdata() {
		return clientdata;
	}
	public void setClientdata(List<ClinicalData> clientdata) {
		this.clientdata = clientdata;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
