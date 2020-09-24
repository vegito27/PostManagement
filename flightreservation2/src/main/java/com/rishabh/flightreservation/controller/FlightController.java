package com.rishabh.flightreservation.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rishabh.flightreservation.entities.Flight;
import com.rishabh.flightreservation.repos.FlightRepository;
import org.slf4j.Logger;



@Controller
public class FlightController {
	
	@Autowired
	FlightRepository flightrepository;
	
	private static final Logger LOGGER =LoggerFactory.getLogger(FlightController.class);
	
	@RequestMapping("/findFlights")
	public String findfFlights(@RequestParam("from") String from,@RequestParam("to")String to,@RequestParam("dateOfDeparture") @DateTimeFormat(pattern="MM-dd-yyyy") Date dateOfDeparture,
			ModelMap modelMap) {
		
		LOGGER.info("Inside findFlights() from:"+from+"TO:"+to+"Departure Date: "+dateOfDeparture);
		
		List<Flight> flights=flightrepository.findFlights(from,to,dateOfDeparture);	
		
		modelMap.addAttribute("flights",flights);
		
		LOGGER.info("Flight Found are :"+flights);
		
		return "displayFlights";			
		
	}
	
	@RequestMapping("admin/showAddFlight")
	public String showAddFlight() {
		
		return "addFlight";	
		
	}
	
	
	

}
