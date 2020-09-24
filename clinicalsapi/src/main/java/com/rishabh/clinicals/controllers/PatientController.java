package com.rishabh.clinicals.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rishabh.clinicals.models.ClinicalData;
import com.rishabh.clinicals.models.Patient;
import com.rishabh.clinicals.repos.PatientRepository;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class PatientController {
	
	
	private PatientRepository repository;
	
	Map<String,String> filters=new HashMap<>();
	
	
	@Autowired
	PatientController(PatientRepository repository){
		this.repository=repository;
	}
	
	
	
	@RequestMapping(value="/patients",method=RequestMethod.GET)
	public List<Patient> getPatients(){
		return repository.findAll();
	}
	
	
	
	
	@RequestMapping(value="/patients/{id}",method=RequestMethod.GET)
	public Patient getpatient(@PathVariable("id") int id) 
	{
		return repository.findById(id).get();
	}
	
	
	
	@RequestMapping(value="/patients",method=RequestMethod.POST)
	public Patient savePatient(@RequestBody Patient patient) {
		
		return repository.save(patient);
	}
	
	
	
	
	@RequestMapping(value="/patients/analyze/{id}",method=RequestMethod.GET)
	public Patient analyze(@PathVariable("id") int id) {
		
		Patient patient = repository.findById(id).get();

		List<ClinicalData> clinicalData = new ArrayList<>(patient.getClientdata());
		
		for (ClinicalData eachEntry : clinicalData) {
			
			if (eachEntry.getComponentName().equals("hw")) {
				
				String[] heightAndWeight = eachEntry.getComponentValue().split("/");
				
				if (heightAndWeight != null && heightAndWeight.length > 1) {
					
					float feetToMetres = Float.parseFloat(heightAndWeight[0]) * 0.4536F;
					
					float BMI = Float.parseFloat(heightAndWeight[1]) / (feetToMetres * feetToMetres);
					
					ClinicalData bmiEntry = new ClinicalData();
					
					bmiEntry.setComponentName("BMI");
					bmiEntry.setComponentValue(Float.toString(BMI));
					patient.getClientdata().add(bmiEntry);
				}
			}
		}
		return patient;
	}

	
	
}
