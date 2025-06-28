package com.thewa.myhealthpal.repository;

import com.thewa.myhealthpal.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
	// Custom query to find medicine by name
	List<Medicine> findByName(String name);
}