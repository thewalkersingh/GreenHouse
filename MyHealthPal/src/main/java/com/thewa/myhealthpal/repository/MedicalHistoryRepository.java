package com.thewa.myhealthpal.repository;
import com.thewa.myhealthpal.entity.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {
	// Custom query to find medical history by condition
	List<MedicalHistory> findByCondition(String condition);
	
	List<MedicalHistory> findPatientById(Long id);
}