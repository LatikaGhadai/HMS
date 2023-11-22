package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.entity.Patient;
import com.hms.service.PatientService;

@RestController
@RequestMapping("/api")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/save")
	public String create(@RequestBody Patient patient) {
		patientService.create(patient);
		return "Saved Success";
	}
	
	@PutMapping("/update/{patientId}")
	public String update(@PathVariable String patientId,@RequestBody Patient patient) {
		patientService.update(patientId, patient);
		return "Update Sucess";
	}

}
