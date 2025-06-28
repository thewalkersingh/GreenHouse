package com.thewa.fastpost.controller;
import com.thewa.fastpost.dto.SenderDTO;
import com.thewa.fastpost.service.SenderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sender")
public class SenderController {
	private final SenderService senderService;
	
	public SenderController(SenderService senderService) {this.senderService = senderService;}
	
	@PostMapping("/create")
	public ResponseEntity<SenderDTO> createSender(@RequestBody SenderDTO senderDTO) {
		SenderDTO createdSender = senderService.createSender(senderDTO);
		return ResponseEntity.ok(createdSender);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<SenderDTO> getSender(@PathVariable Long id) {
		SenderDTO sender = senderService.getSenderById(id);
		return ResponseEntity.ok(sender);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<SenderDTO>> getAllSender() {
		List<SenderDTO> sender = senderService.getAllSenders();
		return ResponseEntity.ok(sender);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<SenderDTO> updateSender(@PathVariable Long id, @RequestBody SenderDTO senderDTO) {
		SenderDTO updateSender = senderService.updateSender(id, senderDTO);
		return ResponseEntity.ok(updateSender);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<SenderDTO> deleteSender(@PathVariable Long id) {
		senderService.deleteSender(id);
		return ResponseEntity.noContent().build();
	}
}