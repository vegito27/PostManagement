package com.bharath.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bharath.location.entities.Location;
import java.util.List;

public interface LocationRepo extends JpaRepository<Location, Integer> {
	
	@Query("select type,count(type) from Location group by type")
	public List<Object[]> findTypeandCount();
	
	
		
	
	

}
