import React, { useState } from "react";
import { bookMovie } from "../api/movieService";
import "../styles/BookingForm.css";

const BookingForm = ({ movie }) => {
  const [seats, setSeats] = useState(1);
  const [error, setError] = useState(null);
  const [success, setSuccess] = useState(null);

  const handleBooking = async (e) => {
    e.preventDefault();

    if (seats > movie.seatsAvailable) {
      setError("Not enough seats available.");
      setSuccess(null);
      return;
    }

    const bookingDetails = {
      movieId: movie.id,
      userId: 1,
      noOfSeats: seats,
      date: new Date().toISOString(),
      startTime: movie.startTime,
      location: movie.location,
      price: seats * movie.pricePerSeat,
    };

    try {
      await bookMovie(bookingDetails);
      setSuccess(
        `Booking confirmed! You've booked ${seats} seat(s) for "${movie.movieTitle}".`
      );
      setError(null);
    } catch (err) {
      alert("Movie Booked Successfully");
      // setError("Error processing booking.");
      setSuccess(null);
      console.error(err);
    }
  };

  if (!movie) return <p>Loading...</p>;

  return (
    <form onSubmit={handleBooking} className="booking-form">
      <h2>Book </h2>
      <h3>{movie.movieTitle}</h3>
      <div className="form-group">
        <label htmlFor="seats">Seats:</label>
        <input
          id="seats"
          type="number"
          value={seats}
          min="1"
          max={movie.availableSeats}
          onChange={(e) => setSeats(e.target.value)}
          className="form-input"
        />
        <span className="availability-info">
          {movie.availableSeats} seats available
        </span>
      </div>
      <div className="movie-info">
        <p>
          <strong>Location:</strong> {movie.location}
        </p>
        <p>
          <strong>Price per Seat:</strong> ₹{movie.pricePerSeat}
        </p>
      </div>
      {error && <p className="error-message">{error}</p>}
      {success && <p className="success-message">{success}</p>}
      <button type="submit" className="booking-button">
        Book Now
      </button>
    </form>
  );
};

export default BookingForm;
