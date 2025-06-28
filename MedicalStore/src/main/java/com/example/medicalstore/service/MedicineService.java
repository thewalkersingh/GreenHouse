package com.example.medicalstore.service;
import com.example.medicalstore.model.Medicine;
import com.example.medicalstore.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {
	@Autowired
	private MedicineRepository medicineRepository;
	
	public List<Medicine> getAllMedicines() {
		return medicineRepository.findAll();
	}
	public Medicine getMedicineById(int id) {
		return medicineRepository.findById(id).get();
	}
	public void saveMedicine(Medicine medicine) {
		medicineRepository.save(medicine);
	}
}