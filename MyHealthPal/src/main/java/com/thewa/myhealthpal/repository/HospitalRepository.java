package com.thewa.myhealthpal.repository;

import com.thewa.myhealthpal.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
	// Custom query to find hospitals by location
	List<Hospital> findByLocation(String location);
}