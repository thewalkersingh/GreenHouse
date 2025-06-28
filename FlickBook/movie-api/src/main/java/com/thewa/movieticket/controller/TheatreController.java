package com.thewa.movieticket.controller;
import com.thewa.movieticket.model.Theatre;
import com.thewa.movieticket.service.TheatreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theatre")
public class TheatreController {
	private final TheatreService theatreService;
	
	public TheatreController(TheatreService theatreService) {this.theatreService = theatreService;}
	
	@GetMapping("/all")
	public List<Theatre> getAllTheatre() {
		return theatreService.getAllTheatre();
	}
	
	@GetMapping("/{id}")
	public Theatre getTheatreById(@PathVariable Long id) {
		return theatreService.getById(id);
	}
	
	@GetMapping("/{location}")
	public List<Theatre> getTheatreByLocation(@PathVariable String location) {
		return theatreService.getByLocation(location);
	}
	
	@PostMapping("/add")
	public String addTheatre(@RequestBody Theatre theatre) {
		return theatreService.addTheatre(theatre);
	}
	
	@PutMapping("/{id}")
	public String updateTheatre(@RequestBody Theatre theatre, @PathVariable Long id) {
		return theatreService.updateTheatre(theatre, id);
	}
}