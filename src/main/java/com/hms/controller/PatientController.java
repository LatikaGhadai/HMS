package com.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.entity.Patient;
import com.hms.service.PatientService;
import com.hms.util.ApiResponse;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/save")
	public Patient create(@RequestBody Patient patient) {
		Patient createP = patientService.create(patient);
		return createP;
	}
	
	@PutMapping("/update/{patientId}")
	public Patient update(@PathVariable String patientId,@RequestBody Patient patient) {
		Patient updateP = patientService.update(patientId, patient);
		return updateP;
	}
	
	@GetMapping("/alldata")
	public List<Patient>getAll(){
		List<Patient> all = patientService.getAll();
		return all;
	}
	
	@GetMapping("data/{patientId}")
	public Patient getById(@PathVariable String patientId) {
		Patient dataById = patientService.getDataById(patientId);
		return dataById;
	}
	@DeleteMapping("delete/{patientId}")
	public ResponseEntity<ApiResponse>delete(@PathVariable String patientId){
		patientService.deleteBYId(patientId);
		return new ResponseEntity<>(new ApiResponse("Deleted Successfully"),HttpStatus.OK);
	}

}
