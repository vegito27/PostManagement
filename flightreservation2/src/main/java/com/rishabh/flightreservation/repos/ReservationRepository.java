package com.rishabh.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishabh.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

		
}
