package com.thewa.myhealthpal.repository;

import com.thewa.myhealthpal.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	// Custom query to find patients by name
	List<Patient> findByName(String name);
}