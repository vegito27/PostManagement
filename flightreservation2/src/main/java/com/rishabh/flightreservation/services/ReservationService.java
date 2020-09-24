package com.rishabh.flightreservation.services;

import com.rishabh.flightreservation.dto.ReservationRequest;
import com.rishabh.flightreservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);

}
