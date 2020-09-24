package com.rishabh.flightreservation.entities;


import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Reservation extends AbstarctEntity {
	
	private Boolean checkedIn;
	
	private int numberOfBags;
	
	public int getNumberOfBags() {
		return numberOfBags;
	}

	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}

	@OneToOne
	private Passenger passenger;
	
	@OneToOne
	private Flight flight;
	
	
	public Boolean getCheckedIn() {
		return checkedIn;
	}
	
	public void setCheckedIn(Boolean checkIn) {
		this.checkedIn = checkIn;
	}
	
	
	public Passenger getPassenger() {
		return passenger;
	}
	
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	
	public Flight getFlight() {
		return flight;
	}
	
	public void setFlight(Flight flight2) {
		this.flight = flight2;
	}

	@Override
	public String toString() {
		return "Reservation [checkIn=" + checkedIn + ", numberOfBags=" + numberOfBags + ", passenger=" + passenger
				+ ", flight=" + flight + "]";
	}
	
	

}
