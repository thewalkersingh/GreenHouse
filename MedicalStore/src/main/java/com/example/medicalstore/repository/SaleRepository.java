package com.example.medicalstore.repository;
import com.example.medicalstore.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}