package com.hms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.entity.Patient;

public interface PatientRepo extends JpaRepository<Patient, String> {

}
