package com.thewa.myhealthpal.service;

import com.thewa.myhealthpal.entity.Doctor;
import com.thewa.myhealthpal.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	// Get all doctors
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}
	
	// Get doctor by ID
	public Doctor getDoctorById(Long id) {
		return doctorRepository.findById(id).orElse(null);
	}
	
	// Add a new doctor
	public Doctor addDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	// Update doctor information
	public Doctor updateDoctor(Long id, Doctor doctorDetails) {
		Doctor doctor = doctorRepository.findById(id).orElse(null);
		if (doctor != null) {
			doctor.setName(doctorDetails.getName());
			doctor.setSpecialization(doctorDetails.getSpecialization());
			doctor.setHospital(doctorDetails.getHospital());
			return doctorRepository.save(doctor);
		}
		return null;
	}
	
	// Delete doctor
	public void deleteDoctor(Long id) {
		doctorRepository.deleteById(id);
	}
}