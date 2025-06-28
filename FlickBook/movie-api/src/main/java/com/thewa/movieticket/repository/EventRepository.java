package com.thewa.movieticket.repository;
import com.thewa.movieticket.model.Event;
import com.thewa.movieticket.model.Movie;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EventRepository {
	private final EntityManager entityManager;
	private final MovieRepository movieRepository;
	
	public EventRepository(EntityManager entityManager, MovieRepository movieRepository) {
		this.entityManager = entityManager;
		this.movieRepository = movieRepository;
	}
	
	public List<Event> getAllShows() {
		Session session = entityManager.unwrap(Session.class);
		return session.createQuery("SELECT s FROM Event s", Event.class).getResultList();
	}
	
	public Event getShowById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		return session.find(Event.class, id);
	}
	
	public List<Event> getShowByMovie(String movie) {
		Session session = entityManager.unwrap(Session.class);
		List<Movie> movies = movieRepository.getMovieByTitle(movie);
		List<Event> events = new ArrayList<>();
		for (Movie m : movies) {
			events.add(getShowById(m.getId()));
		}
		return events;
	}
	
	public String add(Event showTime) {
		Session session = entityManager.unwrap(Session.class);
		session.persist(showTime);
		return "Event added";
	}
	
	public String update(Event showTime) {
		Session session = entityManager.unwrap(Session.class);
		Event oldEvent = session.find(Event.class, showTime.getId());
		oldEvent.setSeats(showTime.getSeats());
		oldEvent.setScreen(showTime.getScreen());
		oldEvent.setStartTime(showTime.getStartTime());
		oldEvent.setEndTime(showTime.getEndTime());
		session.merge(oldEvent);
		return "Event updated";
	}
	
	public String delete(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Event showTime = session.find(Event.class, id);
		session.remove(showTime);
		return "Event deleted";
	}
}