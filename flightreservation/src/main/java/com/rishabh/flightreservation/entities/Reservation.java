package com.rishabh.flightreservation.entities.copy;

import javax.persistence.OneToOne;

public class Reservation {
	
	private Long Id;
	private Boolean checkIn;
	private int numberofBags;
	
	@OneToOne
	private Passenger passenger;
	
	@OneToOne
	private Flight flight;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Boolean getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Boolean checkIn) {
		this.checkIn = checkIn;
	}
	public int getNumberofBags() {
		return numberofBags;
	}
	public void setNumberofBags(int numberofBags) {
		this.numberofBags = numberofBags;
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
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	

}
