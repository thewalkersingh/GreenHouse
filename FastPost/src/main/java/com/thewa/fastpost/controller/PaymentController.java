package com.thewa.fastpost.controller;
import com.thewa.fastpost.dto.PaymentDTO;
import com.thewa.fastpost.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
	private final PaymentService paymentService;
	
	public PaymentController(PaymentService paymentService) {this.paymentService = paymentService;}
	
	@PostMapping("/add")
	public ResponseEntity<PaymentDTO> createPayment(@RequestBody PaymentDTO paymentDTO) {
		PaymentDTO createdPayment = paymentService.createPayment(paymentDTO);
		return ResponseEntity.ok(createdPayment);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable Long id) {
		PaymentDTO payment = paymentService.getPaymentById(id);
		return ResponseEntity.ok(payment);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<PaymentDTO>> getAllPayments() {
		List<PaymentDTO> payments = paymentService.getAllPayments();
		return ResponseEntity.ok(payments);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<PaymentDTO> updatePayment(@PathVariable Long id, @RequestBody PaymentDTO paymentDTO) {
		PaymentDTO updatedPayment = paymentService.updatePayment(id, paymentDTO);
		return ResponseEntity.ok(updatedPayment);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
		paymentService.deletePayment(id);
		return ResponseEntity.noContent().build();
	}
}