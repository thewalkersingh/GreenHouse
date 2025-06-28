package com.thewa.myhealthpal.repository;

import com.thewa.myhealthpal.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	// Custom query to find doctors by specialization
	List<Doctor> findBySpecialization(String specialization);
}