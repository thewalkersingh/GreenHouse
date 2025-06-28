package com.thewa.myhealthpal.repository;

import com.thewa.myhealthpal.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	// Custom query to find appointments by doctor
	List<Appointment> findByDoctorId(Long doctorId);
	
	// Custom query to find appointments by patient
	List<Appointment> findByPatientId(Long patientId);
}