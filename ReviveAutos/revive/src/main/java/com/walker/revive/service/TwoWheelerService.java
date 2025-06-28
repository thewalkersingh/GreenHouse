package com.walker.revive.service;
import com.walker.revive.dto.TwoWheelerDTO;
import com.walker.revive.entity.TwoWheeler;
import com.walker.revive.repository.BikeMongoRepository;
import com.walker.revive.repository.TwoWheelerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TwoWheelerService {
	@Autowired
	TwoWheelerRepository twoWheelerRepository;
	
	@Autowired
	BikeMongoRepository bikeMongoRepository;
	
	@Transactional
	public List<TwoWheeler> getAllTwoWheeler() {
		return bikeMongoRepository.findAll();
	}
	
	@Transactional
	public TwoWheeler getTwoWheelerById(Long id) {
		return bikeMongoRepository.findById(id).get();
	}
	
	@Transactional
	public String addTwoWheeler(TwoWheelerDTO twoWheelerDTO) {
		TwoWheeler twoWheeler = new TwoWheeler(twoWheelerDTO);
		bikeMongoRepository.save(twoWheeler);
		return "Two Wheeler added successfully";
	}
}