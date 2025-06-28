package com.thewa.movieticket.service;
import com.thewa.movieticket.model.Movie;
import com.thewa.movieticket.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
	private final MovieRepository movieRepository;
	
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	@Transactional
	public Movie getMovieById(Long id) {
		return movieRepository.getMovieById(id);
	}
	
	@Transactional
	public List<Movie> getAllMovies() {
		return movieRepository.getAllMovies();
	}
	
	@Transactional
	public String addMovie(Movie movie) {
		return movieRepository.addMovie(movie);
	}
	
	@Transactional
	public String updateMovie(Movie movie, Long id) {
		return movieRepository.updateMovie(movie, id);
	}
	
	@Transactional
	public String removeMovie(Long id) {
		return movieRepository.removeMovie(id);
	}
	
	@Transactional
	public List<Movie> getMovieByGenre(String genre) {
		return movieRepository.getMovieByGenre(genre);
	}
	
	@Transactional
	public List<Movie> getMovieByTitle(String title) {
		return movieRepository.getMovieByTitle(title);
	}
	
	@Transactional
	public List<Movie> getMovieByYear(String year) {
		return movieRepository.getMovieByYear(year);
	}
}