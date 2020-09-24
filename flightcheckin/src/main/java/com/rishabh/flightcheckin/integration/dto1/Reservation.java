package com.rishabh.flightcheckin.integration.dto;


import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Reservation extends AbstarctEntity {
	
	private Boolean checkedIn;
	private int numberOfBags;
	
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
	
	public int getNumberofBags() {
		return numberOfBags;
	}
	
	public void setNumberofBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
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
