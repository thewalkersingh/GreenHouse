package com.thewa.movieticket.service;
import com.thewa.movieticket.model.Event;
import com.thewa.movieticket.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
	@Autowired
	private EventRepository eventRepository;
	
	public List<Event> getAll() {
		return eventRepository.getAllShows();
	}
	
	public Event getById(Long id) {
		return eventRepository.getShowById(id);
	}
	
	public List<Event> getShowByMovie(String movie) {
		return eventRepository.getShowByMovie(movie);
	}
	
	public String addShow(Event showTime) {
		return eventRepository.add(showTime);
	}
	
	public String update(Event showTime) {
		return eventRepository.update(showTime);
	}
	
	public String delete(Long id) {
		return eventRepository.delete(id);
	}
}