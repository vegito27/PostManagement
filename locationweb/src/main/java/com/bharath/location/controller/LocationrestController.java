package com.bharath.location.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bharath.location.entities.Location;
import com.bharath.location.repos.LocationRepo;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/locations")
public class LocationrestController {
	
	@Autowired
	LocationRepo locationrepository;
	
	@GetMapping
	public List<Location> getlocation(){
		return locationrepository.findAll();
	}
	
	@PostMapping
	public Location createlocation(@RequestBody Location location) {
		
		return locationrepository.save(location);	
		
	}
	
	@PutMapping
	public Location updatelocation(@RequestBody Location location) {
		
		return locationrepository.save(location);	
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable int id) throws Exception {
	
		locationrepository.deleteById(id);	
	}
	
	
	@GetMapping("/{id}")
	public Optional<Location> getLocation(@PathVariable int id) {
		return locationrepository.findById(id);
	}
	
	
	}
	


