package com.thewa.movieticket.repository;
import com.thewa.movieticket.model.Movie;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class MovieRepository {
	@Autowired
	private EntityManager entityManager;
	
	public MovieRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<Movie> getAllMovies() {
		Session session = entityManager.unwrap(Session.class);
		return session.createQuery("SELECT m FROM movie m", Movie.class).getResultList();
	}
	
	public Movie getMovieById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Movie.class, id);
	}
	
	public String addMovie(Movie movie) {
		Session session = entityManager.unwrap(Session.class);
		session.persist(movie);
		return "Movie added";
	}
	
	public String removeMovie(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Movie movie = session.get(Movie.class, id);
		session.remove(movie);
		return "Movie removed";
	}
	
	public String updateMovie(Movie movie, Long id) {
		Session session = entityManager.unwrap(Session.class);
		if (session.get(Movie.class, id) == null) {
			return "Movie not found";
		}
		movie.setId(id);
		session.merge(movie);
		return "Movie updated";
	}
	
	public List<Movie> getMovieByGenre(String genre) {
		Session session = entityManager.unwrap(Session.class);
		List<Movie> moviesByGenre = new ArrayList<>();
		List<Movie> allMovies = getAllMovies();
		for (Movie movie : allMovies) {
			if (movie.getGenres().contains(genre)) {
				moviesByGenre.add(movie);
			}
		}
		return moviesByGenre;
	}
	
	public List<Movie> getMovieByTitle(String title) {
		Session session = entityManager.unwrap(Session.class);
		List<Movie> moviesByTitle = new ArrayList<>();
		for (Movie movie : getAllMovies()) {
			if (movie.getMovieName().toLowerCase().contains(title.toLowerCase())) {
				moviesByTitle.add(movie);
			}
		}
		return moviesByTitle;
	}
	
	public List<Movie> getMovieByYear(String year) {
		Session session = entityManager.unwrap(Session.class);
		List<Movie> moviesByYear = new ArrayList<>();
		for (Movie movie : getAllMovies()) {
			if (Objects.equals(movie.getMovieYear(), year))
				moviesByYear.add(movie);
		}
		return moviesByYear;
	}
}