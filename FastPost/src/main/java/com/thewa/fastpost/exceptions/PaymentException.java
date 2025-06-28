package com.thewa.fastpost.exceptions;
public class PaymentException extends RuntimeException {
	public PaymentException(String message) {
		super(message);
	}
	
	public String SenderNotFound(String message) {
		return "Sender not found";
	}
	
	public String ReceiverNotFound(String message) {
		return "Receiver not found";
	}
}