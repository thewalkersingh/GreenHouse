package com.thewa.myhealthpal.controller;

import com.thewa.myhealthpal.entity.Prescription;
import com.thewa.myhealthpal.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {
	
	@Autowired
	private PrescriptionService prescriptionService;
	
	/**
	 * Get all prescriptions.
	 *
	 * @return List of prescriptions.
	 */
	@GetMapping
	public List<Prescription> getAllPrescriptions() {
		return prescriptionService.getAllPrescriptions();
	}
	
	/**
	 * Get prescriptions by appointment ID.
	 *
	 * @param appointmentId Appointment ID.
	 * @return List of prescriptions for the appointment.
	 */
	@GetMapping("/appointment/{appointmentId}")
	public List<Prescription> getPrescriptionsByAppointmentId(@PathVariable Long appointmentId) {
		return prescriptionService.getPrescriptionsByAppointmentId(appointmentId);
	}
	
	/**
	 * Add a new prescription.
	 *
	 * @param prescription Prescription object.
	 * @return Added Prescription object.
	 */
	@PostMapping
	public Prescription addPrescription(@RequestBody Prescription prescription) {
		return prescriptionService.addPrescription(prescription);
	}
	
	/**
	 * Update a prescription.
	 *
	 * @param id           Prescription ID.
	 * @param prescription Prescription object with updated details.
	 * @return Updated Prescription object.
	 */
	@PutMapping("/{id}")
	public Prescription updatePrescription(@PathVariable Long id, @RequestBody Prescription prescription) {
		return prescriptionService.updatePrescription(id, prescription);
	}
	
	/**
	 * Delete a prescription by ID.
	 *
	 * @param id Prescription ID.
	 */
	@DeleteMapping("/{id}")
	public void deletePrescription(@PathVariable Long id) {
		prescriptionService.deletePrescription(id);
	}
}