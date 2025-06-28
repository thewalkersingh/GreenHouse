package com.example.medicalstore.service;
import com.example.medicalstore.model.Sale;
import com.example.medicalstore.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
	@Autowired
	private SaleRepository saleRepository;
	public List<Sale> getAllSales() {
		return saleRepository.findAll();
	}
	public void saveSale(Sale sale) {
		saleRepository.save(sale);
	}
}