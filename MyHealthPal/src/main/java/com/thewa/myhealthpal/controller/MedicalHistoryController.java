package com.thewa.myhealthpal.controller;

import com.thewa.myhealthpal.entity.MedicalHistory;
import com.thewa.myhealthpal.service.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-history")
public class MedicalHistoryController {
	
	@Autowired
	private MedicalHistoryService medicalHistoryService;
	
	/**
	 * Get all medical history records.
	 *
	 * @return List of medical history records.
	 */
	@GetMapping
	public List<MedicalHistory> getAllMedicalHistory() {
		return medicalHistoryService.getAllMedicalHistory();
	}
	
	/**
	 * Get medical history by patient ID.
	 *
	 * @param patientId Patient ID.
	 * @return List of medical history records for the patient.
	 */
	@GetMapping("/patient/{patientId}")
	public List<MedicalHistory> getMedicalHistoryByPatientId(@PathVariable Long patientId) {
		return medicalHistoryService.getMedicalHistoryByPatientId(patientId);
	}
	
	/**
	 * Add new medical history.
	 *
	 * @param medicalHistory MedicalHistory object.
	 * @return Added MedicalHistory object.
	 */
	@PostMapping
	public MedicalHistory addMedicalHistory(@RequestBody MedicalHistory medicalHistory) {
		return medicalHistoryService.addMedicalHistory(medicalHistory);
	}
	
	/**
	 * Update a medical history record.
	 *
	 * @param id             MedicalHistory ID.
	 * @param medicalHistory MedicalHistory object with updated details.
	 * @return Updated MedicalHistory object.
	 */
	@PutMapping("/{id}")
	public MedicalHistory updateMedicalHistory(
			@PathVariable Long id, @RequestBody MedicalHistory medicalHistory) {
		return medicalHistoryService.updateMedicalHistory(id, medicalHistory);
	}
	
	/**
	 * Delete a medical history record by ID.
	 *
	 * @param id MedicalHistory ID.
	 */
	@DeleteMapping("/{id}")
	public void deleteMedicalHistory(@PathVariable Long id) {
		medicalHistoryService.deleteMedicalHistory(id);
	}
}