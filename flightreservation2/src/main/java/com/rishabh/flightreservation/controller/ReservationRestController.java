package com.rishabh.flightreservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishabh.flightreservation.dto.ReservationRequestUpdation;
import com.rishabh.flightreservation.entities.Reservation;
import com.rishabh.flightreservation.repos.ReservationRepository;


@RestController
@CrossOrigin
public class ReservationRestController {
	
	private static final Logger LOGGER =LoggerFactory.getLogger(ReservationRestController.class);
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long Id) {	
		
		LOGGER.info("Inside findReservation() for id: "+Id);
		
		Reservation res=reservationRepository.getOne(Id);
	
		
		return res;
		
	}
	
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationRequestUpdation request) {
		
		LOGGER.info("Inside updateReservation() for : "+request);
		
		Reservation reservation=reservationRepository.getOne(request.getId());
		
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		
		LOGGER.info("Saving Reservation");
		
		
		return reservationRepository.save(reservation);
	}
	

}
