package com.thewa.myhealthpal.repository;

import com.thewa.myhealthpal.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
	// Custom query to find prescriptions by appointment
	List<Prescription> findByAppointmentId(Long appointmentId);
}