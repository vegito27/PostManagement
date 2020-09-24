package com.rishabh.flightcheckin.integration;

public interface ReservationRestClient {
	
	public Reservation findReservation(Long Id); 
	public Reservation updateReservation(); 

}
