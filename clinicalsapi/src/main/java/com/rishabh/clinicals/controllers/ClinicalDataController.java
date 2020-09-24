package com.rishabh.clinicals.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rishabh.clinicals.dto.ClinicalDataRequest;
import com.rishabh.clinicals.models.ClinicalData;
import com.rishabh.clinicals.models.Patient;
import com.rishabh.clinicals.repos.ClinicalDataRepository;
import com.rishabh.clinicals.repos.PatientRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ClinicalDataController {
	
	@Autowired
	private ClinicalDataRepository clinicalDataRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	
	@Autowired
	ClinicalDataController(ClinicalDataRepository clinicalDataRepository,PatientRepository patientRepository){
		this.clinicalDataRepository=clinicalDataRepository;
		this.patientRepository=patientRepository;
		
	}
	
	
	@RequestMapping(value="/clinicals",method=RequestMethod.POST)
	public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequest request) {
		
		Patient patient = patientRepository.findById(request.getPatientId()).get();
		
		
		ClinicalData clinicalData = new ClinicalData();
		
		clinicalData.setComponentName(request.getComponentName());
		
		clinicalData.setComponentValue(request.getComponentValue());
		
		clinicalData.setPatient(patient);
		
		return clinicalDataRepository.saveAndFlush(clinicalData);	
	}
	
	
	
	@RequestMapping(value="/clinicals/{patientId}/{componentName}",method=RequestMethod.GET)
	
	public List<ClinicalData> getClinicalData(@PathVariable("patientId") int patientId,@PathVariable("componentName") String componentName){
		
		return 	clinicalDataRepository.findByPatientIdAndComponentNameOrderByMeasuredDateTime(patientId,componentName);	
	}
	
}
