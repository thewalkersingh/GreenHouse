package com.thewa.myhealthpal.controller;
import com.thewa.myhealthpal.entity.Patient;
import com.thewa.myhealthpal.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	/**
	 * Get all patients.
	 *
	 * @return List of patients.
	 */
	@GetMapping
	public List<Patient> getAllPatients() {
		return patientService.getAllPatients();
	}
	
	/**
	 * Get a specific patient by ID.
	 *
	 * @param id Patient ID.
	 * @return Patient object.
	 */
	@GetMapping("/{id}")
	public Patient getPatientById(@PathVariable Long id) {
		return patientService.getPatientById(id);
	}
	
	/**
	 * Add a new patient.
	 *
	 * @param patient Patient object.
	 * @return Added Patient object.
	 */
	@PostMapping
	public Patient addPatient(@RequestBody Patient patient) {
		return patientService.addPatient(patient);
	}
	
	/**
	 * Update a patient's information.
	 *
	 * @param id      Patient ID.
	 * @param patient Patient object with updated details.
	 * @return Updated Patient object.
	 */
	@PutMapping("/{id}")
	public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
		return patientService.updatePatient(id, patient);
	}
	
	/**
	 * Delete a patient by ID.
	 *
	 * @param id Patient ID.
	 */
	@DeleteMapping("/{id}")
	public void deletePatient(@PathVariable Long id) {
		patientService.deletePatient(id);
	}
}