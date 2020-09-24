package com.rishabh.flightcheckin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rishabh.flightcheckin.integration.ReservationRestClient;
import com.rishabh.flightcheckin.integration.dto.*;


@Controller
public class checkInController {
	
	@Autowired
	ReservationRestClient restClient;

	@RequestMapping("/showStartController")
	public String showStartCheckin() {
		return "startCheckIn";	
	}
	
	@RequestMapping("/startCheckIn")
	public String startCheckIn(@RequestParam("reservationId") Long reservationId,ModelMap modelmap) {
		
		Reservation reservation=restClient.findReservation(reservationId);
		
		System.out.print(reservation);
		
		modelmap.addAttribute("reservation",reservation);
		
		return "displayReservationDetails";
		
	}
	
	@RequestMapping(value="/completeCheckIn",method=RequestMethod.POST)
	public String completeCheckIn(@RequestParam("reservationId")Long reservationId,@RequestParam("numberOfBags")int numberOfBags){
		
		ReservationRequestUpdation reservationupdaterequest =new ReservationRequestUpdation();
		
		reservationupdaterequest.setId(reservationId);
		
		reservationupdaterequest.setCheckedIn(true);
		
		reservationupdaterequest.setNumberOfBags(numberOfBags);
		
		restClient.updateReservation(reservationupdaterequest);
			
		return "checkInConfirmation";
		
		
		
	}
	
	
	
}
