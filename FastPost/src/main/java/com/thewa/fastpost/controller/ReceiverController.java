package com.thewa.fastpost.controller;
import com.thewa.fastpost.dto.ReceiverDTO;
import com.thewa.fastpost.service.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receiver")
public class ReceiverController {
	@Autowired
	private ReceiverService receiverService;
	
	@PostMapping("/add")
	public ResponseEntity<ReceiverDTO> createReceiver(@RequestBody ReceiverDTO receiverDTO) {
		ReceiverDTO createdReceiver = receiverService.createReceiver(receiverDTO);
		return ResponseEntity.ok(createdReceiver);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<ReceiverDTO> getReceiverById(@PathVariable Long id) {
		ReceiverDTO receiver = receiverService.getReceiverById(id);
		return ResponseEntity.ok(receiver);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<ReceiverDTO>> getAllReceivers() {
		List<ReceiverDTO> receivers = receiverService.getAllReceivers();
		return ResponseEntity.ok(receivers);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ReceiverDTO> updateReceiver(
			@PathVariable Long id,
			@RequestBody ReceiverDTO receiverDTO) {
		ReceiverDTO updatedReceiver = receiverService.updateReceiver(id, receiverDTO);
		return ResponseEntity.ok(updatedReceiver);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteReceiver(@PathVariable Long id) {
		receiverService.deleteReceiver(id);
		return ResponseEntity.noContent().build();
	}
}