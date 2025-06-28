package com.thewa.movieticket.repository;
import com.thewa.movieticket.model.Booking;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingRepository {
	@Autowired
	private EntityManager entityManager;
	
	public Booking getBookingById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Booking.class, id);
	}
	
	public String saveBooking(Booking bookingRequest) {
		Session session = entityManager.unwrap(Session.class);
		session.persist(bookingRequest);
		return "Booking successful";
	}
	
	public List<Booking> getAllBookings() {
		Session session = entityManager.unwrap(Session.class);
		return session.createQuery("from Booking", Booking.class).getResultList();
	}
	
	public List<Booking> getBookingByUsername(String username) {
		List<Booking> bookings = getAllBookings();
		List<Booking> filteredBookings = new ArrayList<>();
		for (Booking booking : bookings) {
			if (booking.getUser().getUsername().equals(username))
				filteredBookings.add(booking);
		}
		return filteredBookings;
	}
	
	public String cancelBooking(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Booking booking = getBookingById(id);
		if (booking == null)
			return "Booking not found";
		session.remove(booking);
		return "Booking cancelled";
	}
	
	public String updateSeats(Long bookingId, int seats) {
		Session session = entityManager.unwrap(Session.class);
		Booking booking = getBookingById(bookingId);
		booking.setNoOfSeats(seats);
		return "Booking updated";
	}
	
	public String updateMovieBooking(Booking booking) {
		Session session = entityManager.unwrap(Session.class);
		Booking bookingToUpdate = getBookingById(booking.getId());
		session.merge(bookingToUpdate);
		return "Booking updated";
	}
}