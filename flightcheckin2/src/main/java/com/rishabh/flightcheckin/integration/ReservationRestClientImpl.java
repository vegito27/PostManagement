package com.rishabh.flightcheckin.integration;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rishabh.flightcheckin.integration.dto.Reservation;
import com.rishabh.flightcheckin.integration.dto.ReservationRequestUpdation;

@Service
public class ReservationRestClientImpl implements ReservationRestClient{

	private static final String FLIGHTRESERVATION_RESERVATIONS = "http://localhost:8080/flightreservation/reservations/";

	@Override
	public Reservation findReservation(Long Id) {
		
		RestTemplate rest=new RestTemplate();
		Reservation reservation=rest.getForObject(FLIGHTRESERVATION_RESERVATIONS+Id, Reservation.class);
		
		return reservation;
		
	}
	
	@Override
	public Reservation updateReservation(ReservationRequestUpdation update) {
		
		RestTemplate ret=new RestTemplate();
		Reservation reservation=ret.postForObject(FLIGHTRESERVATION_RESERVATIONS, update,Reservation.class);
		
		return reservation;
	}
	
	
	
	
	

}
