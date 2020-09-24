package com.bharath.location.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import  com.bharath.location.entities.Location;
import com.bharath.location.repos.LocationRepo;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationRepo repository;
	
	@Override
	public Location savelocation(Location location) {
		
		return repository.save(location);
	}

	@Override
	public Location updatelocation(Location location) {
	
		return repository.save(location);
	}

	@Override
	public  Optional<Location> getLocationbyid(int id) {
		
		return (Optional<Location>)repository.findById(id);		
		
	}

	@Override
	public List<Location> getAllLocations() {
		
		return repository.findAll();
			
	}

	@Override
	public void deleteById(int id) {
		
		repository.deleteById(id);
	}
	

	public LocationRepo getRepository() {
		return repository;
	}

	public void setRepository(LocationRepo repository) {
		this.repository = repository;
	}

	@Override
	public void deletelocation(Location loc) {
		
		repository.delete(loc);
	}


}
