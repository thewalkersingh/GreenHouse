package com.walker.revive.controller;
import com.walker.revive.dto.TwoWheelerDTO;
import com.walker.revive.entity.TwoWheeler;
import com.walker.revive.service.TwoWheelerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/two/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class TwoWheelerController {
	@Autowired
	TwoWheelerService twoWheelerService;
	
	@GetMapping("/all")
	public List<TwoWheeler> getAllTwoWheelers() {
		return twoWheelerService.getAllTwoWheeler();
	}
	
	@GetMapping("/id/{id}")
	public TwoWheeler getTwoWheelerById(@PathVariable Long id) {
		return twoWheelerService.getTwoWheelerById(id);
	}
	
	@PostMapping("/add")
	public String addTwoWheeler(@RequestBody TwoWheelerDTO twoWheelerDTO) {
		return twoWheelerService.addTwoWheeler(twoWheelerDTO);
	}
}