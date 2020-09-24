package com.rishabh.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishabh.flightreservation.entities.User;


public interface UserRepository extends JpaRepository<User,Long> {
	

}
