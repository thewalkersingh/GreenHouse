package com.thewa.fastpost.controller;
import com.thewa.fastpost.dto.TrackingDTO;
import com.thewa.fastpost.entity.Tracking;
import com.thewa.fastpost.service.TrackingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracking")
public class TrackingController {
	private final TrackingService trackingService;
	
	public TrackingController(TrackingService trackingService) {
		this.trackingService = trackingService;
	}
	
	@PostMapping
	public ResponseEntity<TrackingDTO> createTracking(@RequestBody TrackingDTO trackingDTO) {
		TrackingDTO createdTracking = trackingService.createTracking(trackingDTO);
		return ResponseEntity.ok(createdTracking);
	}
	
	@GetMapping("/id/{trackingNumber}")
	public ResponseEntity<TrackingDTO> getTrackingByNumber(@PathVariable String trackingNumber) {
		TrackingDTO tracking = trackingService.getTrackingByNumber(trackingNumber);
		return ResponseEntity.ok(tracking);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<TrackingDTO>> getAllTrackings() {
		List<TrackingDTO> trackings = trackingService.getAllTrackings();
		return ResponseEntity.ok(trackings);
	}
	
	@PutMapping("/update/{trackingNumber}")
	public ResponseEntity<TrackingDTO> updateTracking(
			@PathVariable String trackingNumber,
			@RequestBody Tracking tracking) {
		TrackingDTO updatedTracking = trackingService.updateTracking(trackingNumber, tracking);
		return ResponseEntity.ok(updatedTracking);
	}
	
	@DeleteMapping("delete/{trackingNumber}")
	public ResponseEntity<Void> deleteTracking(@PathVariable String trackingNumber) {
		trackingService.deleteTracking(trackingNumber);
		return ResponseEntity.noContent().build();
	}
}