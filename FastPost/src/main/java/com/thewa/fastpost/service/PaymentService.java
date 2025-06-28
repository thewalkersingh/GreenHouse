package com.thewa.fastpost.service;
import com.thewa.fastpost.dto.PaymentDTO;
import com.thewa.fastpost.entity.Payment;
import com.thewa.fastpost.entity.Receiver;
import com.thewa.fastpost.entity.Sender;
import com.thewa.fastpost.exceptions.PaymentException;
import com.thewa.fastpost.repository.PaymentRepository;
import com.thewa.fastpost.repository.ReceiverRepository;
import com.thewa.fastpost.repository.SenderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
	private final PaymentRepository paymentRepository;
	private final SenderRepository senderRepository;
	private final ReceiverRepository receiverRepository;
	
	public PaymentService(
			PaymentRepository paymentRepository, SenderRepository senderRepository,
			ReceiverRepository receiverRepository) {
		this.paymentRepository = paymentRepository;
		this.senderRepository = senderRepository;
		this.receiverRepository = receiverRepository;
	}
	
	public PaymentDTO createPayment(PaymentDTO paymentDTO) {
		Payment payment = new Payment();
		Optional<Sender> senderOpt = senderRepository.findById(paymentDTO.getId());
		Optional<Receiver> receiverOpt = receiverRepository.findById(paymentDTO.getReceiverId());
		if (senderOpt.isEmpty() || receiverOpt.isEmpty()) {
			throw new PaymentException("Sender or Receiver not found");
		}
		payment.setAmount(paymentDTO.getAmount());
		payment.setPaymentDate(paymentDTO.getPaymentDate());
		payment.setPaymentType(paymentDTO.getPaymentType());
		payment.setNote(paymentDTO.getNote());
		payment.setReceiver(receiverOpt.get());
		payment.setSender(senderOpt.get());
		Payment savedPayment = paymentRepository.save(payment);
		return convertToDTO(savedPayment);
	}
	
	public PaymentDTO getPaymentById(Long id) {
		Optional<Payment> paymentOpt = paymentRepository.findById(id);
		if (paymentOpt.isEmpty()) {
			throw new IllegalArgumentException("Payment not found");
		}
		return convertToDTO(paymentOpt.get());
	}
	
	public List<PaymentDTO> getAllPayments() {
		List<Payment> payments = paymentRepository.findAll();
		return payments.stream()
		               .map(this::convertToDTO)
		               .toList();
	}
	
	public PaymentDTO updatePayment(Long id, PaymentDTO paymentDTO) {
		Optional<Payment> paymentOpt = paymentRepository.findById(id);
		if (paymentOpt.isEmpty()) {
			throw new IllegalArgumentException("Payment not found for ID: " + id);
		}
		Payment payment = paymentOpt.get();
		payment.setAmount(paymentDTO.getAmount());
		payment.setPaymentDate(paymentDTO.getPaymentDate());
		payment.setPaymentType(paymentDTO.getPaymentType());
		payment.setNote(paymentDTO.getNote());
		Payment updatedPayment = paymentRepository.save(payment);
		return convertToDTO(updatedPayment);
	}
	
	public void deletePayment(Long id) {
		if (!paymentRepository.existsById(id)) {
			throw new IllegalArgumentException("Payment not found for ID: " + id);
		}
		paymentRepository.deleteById(id);
	}
	
	// Helper method to convert Payment entity to PaymentDTO
	private PaymentDTO convertToDTO(Payment payment) {
		PaymentDTO dto = new PaymentDTO();
		dto.setId(payment.getId());
		dto.setAmount(payment.getAmount());
		dto.setPaymentDate(payment.getPaymentDate());
		dto.setPaymentType(payment.getPaymentType());
		dto.setNote(payment.getNote());
		dto.setSenderId(payment.getSender().getId());
		dto.setReceiverId(payment.getReceiver().getId());
		return dto;
	}
}