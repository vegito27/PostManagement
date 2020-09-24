package com.rishabh.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishabh.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
