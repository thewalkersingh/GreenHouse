package com.thewa.myhealthpal.controller;

import com.thewa.myhealthpal.entity.Doctor;
import com.thewa.myhealthpal.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	/**
	 * Get all doctors.
	 *
	 * @return List of doctors.
	 */
	@GetMapping
	public List<Doctor> getAllDoctors() {
		return doctorService.getAllDoctors();
	}
	
	/**
	 * Get a specific doctor by ID.
	 *
	 * @param id Doctor ID.
	 * @return Doctor object.
	 */
	@GetMapping("/{id}")
	public Doctor getDoctorById(@PathVariable Long id) {
		return doctorService.getDoctorById(id);
	}
	
	/**
	 * Add a new doctor.
	 *
	 * @param doctor Doctor object.
	 * @return Added Doctor object.
	 */
	@PostMapping
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return doctorService.addDoctor(doctor);
	}
	
	/**
	 * Update a doctor's information.
	 *
	 * @param id     Doctor ID.
	 * @param doctor Doctor object with updated details.
	 * @return Updated Doctor object.
	 */
	@PutMapping("/{id}")
	public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
		return doctorService.updateDoctor(id, doctor);
	}
	
	/**
	 * Delete a doctor by ID.
	 *
	 * @param id Doctor ID.
	 */
	@DeleteMapping("/{id}")
	public void deleteDoctor(@PathVariable Long id) {
		doctorService.deleteDoctor(id);
	}
}