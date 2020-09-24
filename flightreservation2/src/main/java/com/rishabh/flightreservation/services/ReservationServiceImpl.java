package com.rishabh.flightreservation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishabh.flightreservation.dto.ReservationRequest;
import com.rishabh.flightreservation.entities.Flight;
import com.rishabh.flightreservation.entities.Passenger;
import com.rishabh.flightreservation.entities.Reservation;
import com.rishabh.flightreservation.repos.FlightRepository;
import com.rishabh.flightreservation.repos.PassengerRepository;
import com.rishabh.flightreservation.repos.ReservationRepository;
import com.rishabh.flightreservation.util.EmailUtil;
import com.rishabh.flightreservation.util.PDFGEnereator;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	FlightRepository flightrepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	PDFGEnereator pdfGenerator;
	
	@Autowired
	EmailUtil emailUtil;
	
	private static final Logger LOGGER =LoggerFactory.getLogger(ReservationServiceImpl.class);
	
    
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		LOGGER.info("Inside bookflight()");
		
        Long id=request.getFlightId();
        
    	LOGGER.info("Fetching flight for flight id :"+id);
		
		Flight flight=flightrepository.getOne(id);
		
		System.out.println(flight);
		System.out.println(id);
		
		
		Passenger passenger=new Passenger();
		
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		
		LOGGER.info("Saving  the Passenger :"+passenger);
		
		
		Passenger savedpassenger = passengerRepository.save(passenger);
		
		Reservation reservation=new Reservation();
		reservation.setPassenger(savedpassenger);
		reservation.setFlight(flight);
		reservation.setCheckedIn(false);
		
		LOGGER.info("Saving the  Reservation:"+reservation);
		
		Reservation savedReservation=reservationRepository.saveAndFlush(reservation);
		
		String filepath="/Users/rishabhtripathii/Documents/reservations/reservation"+savedReservation.getId()+".pdf";
		
		LOGGER.info("Saving the itinerary");
		
		pdfGenerator.generateItinerary(savedReservation, filepath);
		
		LOGGER.info("Emailing the itinerary");
		
		emailUtil.sendItinerary(passenger.getEmail(), filepath);
		
		return savedReservation;
	}

}
