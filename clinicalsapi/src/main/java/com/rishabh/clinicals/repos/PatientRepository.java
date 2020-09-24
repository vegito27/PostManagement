package com.rishabh.clinicals.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishabh.clinicals.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	List<Patient> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);

}
