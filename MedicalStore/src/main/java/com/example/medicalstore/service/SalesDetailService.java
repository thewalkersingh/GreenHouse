package com.example.medicalstore.service;
import com.example.medicalstore.model.SalesDetail;
import com.example.medicalstore.repository.SalesDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesDetailService {
	@Autowired
	private SalesDetailRepository salesDetailRepository;
	public List<SalesDetail> getAllSalesDetails() {
		return salesDetailRepository.findAll();
	}
	public void saveSalesDetail(SalesDetail salesDetail) {
		salesDetailRepository.save(salesDetail);
	}
}