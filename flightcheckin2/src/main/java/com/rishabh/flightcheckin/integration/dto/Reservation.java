package com.rishabh.flightcheckin.integration.dto;


public class Reservation {
	
	private Long Id;
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	private Boolean checkedIn;
	private int numberOfBags;
	
	
	private Passenger passenger;
	

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
