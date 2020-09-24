package com.rishabh.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishabh.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
