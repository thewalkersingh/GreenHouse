package com.thewa.myhealthpal.service;
import com.thewa.myhealthpal.entity.Patient;
import com.thewa.myhealthpal.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
	@Autowired
	private PatientRepository patientRepository;
	
	// Get all patients
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}
	
	// Get patient by ID
	public Patient getPatientById(Long id) {
		return patientRepository.findById(id).orElse(null);
	}
	
	// Add a new patient
	public Patient addPatient(Patient patient) {
		return patientRepository.save(patient);
	}
	
	// Update patient information
	public Patient updatePatient(Long id, Patient patientDetails) {
		Patient patient = patientRepository.findById(id).orElse(null);
		if (patient != null) {
			patient.setName(patientDetails.getName());
			patient.setDateOfBirth(patientDetails.getDateOfBirth());
			patient.setGender(patientDetails.getGender());
			return patientRepository.save(patient);
		}
		return null;
	}
	
	// Delete patient
	public void deletePatient(Long id) {
		patientRepository.deleteById(id);
	}
}