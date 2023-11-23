package com.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.entity.Patient;
import com.hms.exception.ResourceNotFoundException;
import com.hms.repo.PatientRepo;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepo patientRepo;
	
	
	public Patient create(Patient patient) {
		Patient saveP = patientRepo.save(patient);
		return saveP;
	}
	
	public Patient update(String patientId, Patient patient) {
		Patient patId = patientRepo.findById(patientId).orElseThrow(()->new ResourceNotFoundException("Not Found"));
		patId.setAddress(patient.getAddress());
		patId.setName(patient.getName());
		Patient updatePat = patientRepo.save(patId);
		return updatePat;
	}
	
	public List<Patient> getAll() {
		List<Patient> getall = patientRepo.findAll();
		return getall;
	}
	
	public Patient getDataById(String patientId) {
		Patient dataById = patientRepo.findById(patientId).orElseThrow(()->new ResourceNotFoundException("Not Found"));
		return dataById;
	}
	
	public void deleteBYId(String patientId) {
		patientRepo.deleteById(patientId);
	}

}
