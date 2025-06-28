package com.thewa.movieticket.controller;
import com.thewa.movieticket.model.Booking;
import com.thewa.movieticket.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {
	private final BookingService bookingService;
	
	public BookingController(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	
	@PostMapping("/book")
	public String bookMovie(@RequestBody Booking bookingRequest) {
		return bookingService.saveBooking(bookingRequest);
	}
	
	@GetMapping("/id/{id}")
	public Booking getBookingById(@PathVariable Long id) {
		return bookingService.getMyBooking(id);
	}
	
	@GetMapping("/get/{username}")
	public List<Booking> getBookingByUsername(@PathVariable String username) {
		return bookingService.getBookingByUsername(username);
	}
	
	@DeleteMapping("/cancel/{id}")
	public String cancelBooking(@PathVariable Long id) {
		return bookingService.cancelBooking(id);
	}
	
	@PutMapping("/update/{bookingId}/{seats}")
	public String updateSeats(@PathVariable Long bookingId, @PathVariable int seats) {
		return bookingService.updateSeats(bookingId, seats);
	}
	
	@PutMapping("/update/{booking}")
	public String updateBooking(@RequestBody Booking booking) {
		return bookingService.updateMovieBooking(booking);
	}
}