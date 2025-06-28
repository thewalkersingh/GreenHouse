package com.thewa.myhealthpal.service;

import com.thewa.myhealthpal.entity.Prescription;
import com.thewa.myhealthpal.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {
	
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	// Get all prescriptions
	public List<Prescription> getAllPrescriptions() {
		return prescriptionRepository.findAll();
	}
	
	// Get prescriptions by appointment ID
	public List<Prescription> getPrescriptionsByAppointmentId(Long appointmentId) {
		return prescriptionRepository.findByAppointmentId(appointmentId);
	}
	
	// Add a prescription
	public Prescription addPrescription(Prescription prescription) {
		return prescriptionRepository.save(prescription);
	}
	
	// Update prescription details
	public Prescription updatePrescription(Long id, Prescription prescriptionDetails) {
		Prescription prescription = prescriptionRepository.findById(id).orElse(null);
		if (prescription != null) {
			prescription.setMedicine(prescriptionDetails.getMedicine());
			prescription.setDosage(prescriptionDetails.getDosage());
			return prescriptionRepository.save(prescription);
		}
		return null;
	}
	
	// Delete prescription
	public void deletePrescription(Long id) {
		prescriptionRepository.deleteById(id);
	}
}