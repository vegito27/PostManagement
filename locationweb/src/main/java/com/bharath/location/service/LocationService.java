package com.bharath.location.service;

import com.bharath.location.entities.Location;

import java.util.List;
import java.util.Optional;


public interface LocationService {
	
	Location savelocation(Location locaton);
	
	Location updatelocation(Location location);
	
	void deletelocation(Location loc);
	
	Optional<Location> getLocationbyid(int id);
	
	List<Location> getAllLocations();
	
	void deleteById(int id);
	
	
}
