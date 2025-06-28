// src/api/movieService.js
import axios from "axios";

const API_URL = "http://localhost:8080/api/movie";

export const getAllMovies = async () => {
  const response = await axios.get(`${API_URL}/all`);
  return response.data;
};

export const getMovieById = async (id) => {
  const response = await axios.get(`${API_URL}/${id}`);
  return response.data;
};

// New function to book a movie
export const bookMovie = async (bookingDetails) => {
  const response = await axios.post(
    "http://localhost:8080/api/bookings/book",
    bookingDetails
  );
  return response.data;
};
