package com.thewa.movieticket.service;
import com.thewa.movieticket.model.Booking;
import com.thewa.movieticket.repository.BookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
	private final BookingRepository bookingRepository;
	
	public BookingService(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}
	
	@Transactional
	public String saveBooking(Booking bookingRequest) {
		return bookingRepository.saveBooking(bookingRequest);
	}
	
	@Transactional
	public Booking getMyBooking(Long id) {
		return bookingRepository.getBookingById(id);
	}
	
	@Transactional
	public List<Booking> getBookingByUsername(String username) {
		return bookingRepository.getBookingByUsername(username);
	}
	
	@Transactional
	public String cancelBooking(Long id) {
		return bookingRepository.cancelBooking(id);
	}
	
	@Transactional
	public String updateSeats(Long bookingId, int seats) {
		return bookingRepository.updateSeats(bookingId, seats);
	}
	
	@Transactional
	public String updateMovieBooking(Booking booking) {
		return bookingRepository.updateMovieBooking(booking);
	}
}