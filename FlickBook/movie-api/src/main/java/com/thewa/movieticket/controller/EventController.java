package com.thewa.movieticket.controller;
import com.thewa.movieticket.model.Event;
import com.thewa.movieticket.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/show")
@CrossOrigin(origins = "http://localhost:3000")
public class EventController {
	private final EventService eventService;
	
	public EventController(EventService eventService) {this.eventService = eventService;}
	
	@GetMapping("/all")
	public List<Event> getAllShows() {
		return eventService.getAll();
	}
	
	@GetMapping("/{id}")
	public Event getShowById(@PathVariable Long id) {
		return eventService.getById(id);
	}
	
	@GetMapping("/{movie}")
	public List<Event> getShowByMovieName(@PathVariable String movie) {
		return eventService.getShowByMovie(movie);
	}
	
	@PostMapping("/add")
	public String addShow(@RequestBody Event showTime) {
		return eventService.addShow(showTime);
	}
	
	@PutMapping("/update/{show}")
	public String updateShow(@RequestBody Event showTime) {
		return eventService.update(showTime);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteShow(@PathVariable Long id) {
		return eventService.delete(id);
	}
}