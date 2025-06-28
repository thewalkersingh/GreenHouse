package com.example.medicalstore.repository;
import com.example.medicalstore.model.SalesDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesDetailRepository extends JpaRepository<SalesDetail, Integer> {
}