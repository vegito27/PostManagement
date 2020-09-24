package com.rishabh.flightcheckin.integration;

import  com.rishabh.flightcheckin.integration.dto.*;

public interface ReservationRestClient {
	
	public Reservation findReservation(Long Id);
	
	public Reservation updateReservation(ReservationRequestUpdation update); 

	
}
