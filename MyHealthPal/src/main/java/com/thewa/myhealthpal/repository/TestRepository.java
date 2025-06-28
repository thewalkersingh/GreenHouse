package com.thewa.myhealthpal.repository;

import com.thewa.myhealthpal.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
	// Custom query to find tests by patient
	List<Test> findByPatientId(Long patientId);
}