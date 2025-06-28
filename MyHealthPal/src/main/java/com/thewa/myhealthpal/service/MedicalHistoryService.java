package com.thewa.myhealthpal.service;
import com.thewa.myhealthpal.entity.MedicalHistory;
import com.thewa.myhealthpal.repository.MedicalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalHistoryService {
	@Autowired
	private MedicalHistoryRepository medicalHistoryRepository;
	
	// Get all medical history
	public List<MedicalHistory> getAllMedicalHistory() {
		return medicalHistoryRepository.findAll();
	}
	
	// Get medical history by patient ID
	public List<MedicalHistory> getMedicalHistoryByPatientId(Long patientId) {
		return medicalHistoryRepository.findPatientById(patientId);
	}
	
	// Add medical history
	public MedicalHistory addMedicalHistory(MedicalHistory history) {
		return medicalHistoryRepository.save(history);
	}
	
	// Update medical history
	public MedicalHistory updateMedicalHistory(Long id, MedicalHistory historyDetails) {
		MedicalHistory history = medicalHistoryRepository.findById(id).orElse(null);
		if (history != null) {
			history.setCondition(historyDetails.getCondition());
			history.setDiagnosisDate(historyDetails.getDiagnosisDate());
			return medicalHistoryRepository.save(history);
		}
		return null;
	}
	
	// Delete medical history
	public void deleteMedicalHistory(Long id) {
		medicalHistoryRepository.deleteById(id);
	}
}