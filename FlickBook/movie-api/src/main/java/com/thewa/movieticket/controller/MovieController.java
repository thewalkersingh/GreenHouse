package com.thewa.movieticket.controller;
import com.thewa.movieticket.model.Movie;
import com.thewa.movieticket.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {
	private final MovieService movieService;
	
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@GetMapping("/{id}")
	public Movie getMovieById(@PathVariable Long id) {
		return movieService.getMovieById(id);
	}
	
	@GetMapping("/all")
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}
	
	@PostMapping("/add")
	public String addMovie(@Valid @RequestBody Movie movie, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new RuntimeException("Data provided is Invalid");
		}
		return movieService.addMovie(movie);
	}
	
	@PutMapping("/update/{id}")
	public String updateMovie(@RequestBody Movie movie, BindingResult bindingResult, @PathVariable Long id) {
		if (bindingResult.hasErrors()) {
			throw new RuntimeException("Data provided is Invalid");
		}
		return movieService.updateMovie(movie, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteMovie(@PathVariable Long id) {
		return movieService.removeMovie(id);
	}
	
	@GetMapping("/genre/{genre}")
	public List<Movie> getMovieByGenre(@PathVariable String genre) {
		return movieService.getMovieByGenre(genre);
	}
	
	@GetMapping("/title/{name}")
	public List<Movie> getMovieByName(@PathVariable String name) {
		return movieService.getMovieByTitle(name);
	}
	
	@GetMapping("/year/{year}")
	public List<Movie> getMovieByYear(@PathVariable String year) {
		return movieService.getMovieByYear(year);
	}
}