package com.bharath.location.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bharath.location.entities.Location;
import com.bharath.location.repos.LocationRepo;
import com.bharath.location.service.LocationService;
import com.bharath.location.util.EmailUtil;
import com.bharath.location.util.ReportUtil;

import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;


@Controller
public class Locationcontroller {
	
	
	@Autowired
	LocationService service;
	
	
	@Autowired
	EmailUtil emailutil; 
	
	@Autowired
	LocationRepo repository;
	
	@Autowired
	ReportUtil reportUtil;
	
	@Autowired
	ServletContext sc;
	
	
	@RequestMapping("/showcreate")
	public String showcreate() {
		
		return "createLocation";
	}
	
	@RequestMapping("/saveloc")
	public String saveLocation(@ModelAttribute("location") Location location,ModelMap modelmap) {
		
		Location locationsaved=service.savelocation(location);
		
		String msg="Location saed with id :"+locationsaved.getId();
		
		modelmap.addAttribute("msg",msg);
		
		emailutil.sendEmail("trishabh889@gmail.com","Location saved","Location saved Successfully and about to return to response");
		
		return "createLocation";
	}
	
	@RequestMapping("/displaylocations")
	public String displaylocations(ModelMap modelmap) {
		
		List<Location> locations=service.getAllLocations();
		
		modelmap.addAttribute("locations",locations);
		
		return "displayLocation";
	}
	
	@RequestMapping("/deletelocation")
	public String deleteLocation(@RequestParam("id")int id,ModelMap modelmap){
		
		service.deleteById(id);

		List<Location> locations=service.getAllLocations();
		
		modelmap.addAttribute("locations",locations);
		
		return "displayLocation";
		
	}
	
	@RequestMapping("/showupdate")
	public String showupdate(@RequestParam("id") int id,ModelMap modelmap) {
		
		Optional<Location> location = service.getLocationbyid(id);
		
		if (location.isPresent()) {
		    modelmap.addAttribute("location", location.get());
		} 
		
		return "update";
	}
	
	@RequestMapping("/updateloc")
	public String updatelocation(@ModelAttribute("location") Location location,ModelMap modelmap) {
		
		service.updatelocation(location);
		
		List<Location> locations=service.getAllLocations();
		
		modelmap.addAttribute("locations",locations);
		
		return "displayLocation";
		
	}
	
	@RequestMapping("/generateReport")
	public String generateReport() {
		
		String path=sc.getRealPath("/");
		
		List<Object[]> data= repository.findTypeandCount();
		
		reportUtil.generatePieChart(path,data);
		
		return "report";
	}
	
	
		
}
