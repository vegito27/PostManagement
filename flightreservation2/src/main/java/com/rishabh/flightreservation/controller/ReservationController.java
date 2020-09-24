package com.rishabh.flightreservation.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rishabh.flightreservation.dto.ReservationRequest;
import com.rishabh.flightreservation.entities.Flight;
import com.rishabh.flightreservation.entities.Reservation;
import com.rishabh.flightreservation.repos.FlightRepository;
import com.rishabh.flightreservation.repos.PassengerRepository;
import com.rishabh.flightreservation.repos.ReservationRepository;
import com.rishabh.flightreservation.services.ReservationService;

@Controller
public class ReservationController {
	
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	FlightRepository flightrepository;
	
	@Autowired
	ReservationService reservationservice; 
	
	private static final Logger LOGGER =LoggerFactory.getLogger(ReservationController.class);
	
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId")Long flightId,ModelMap modelmap) {
		
		LOGGER.info("showCompleteReservation() invoked with the flight Id:"+flightId);
		
		Optional<Flight> flight=flightrepository.findById(flightId);
			
		modelmap.addAttribute("flight", flight.get());
		
		LOGGER.info("Flight is :"+flight);
		
		return "completeReservation";
	}
	
	
	@RequestMapping(value="/completeReservation",method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request,ModelMap modelMap) throws NullPointerException {
		
		LOGGER.info("completeReservation() invoked with the flight Id:"+request);	
		
		Reservation reservation=reservationservice.bookFlight(request);
		
	    modelMap.addAttribute("msg", "reservation created successfully and the id is " +reservation.getId());
		
		return "reservationConfirmation";
		
		
		
	}
	

}
