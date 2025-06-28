package com.thewa.movieticket.service;
import com.thewa.movieticket.model.Theatre;
import com.thewa.movieticket.repository.TheatreRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {
	private final TheatreRepository theatreRepository;
	
	public TheatreService(TheatreRepository theatreRepository) {
		this.theatreRepository = theatreRepository;
	}
	
	@Transactional
	public List<Theatre> getAllTheatre() {
		return theatreRepository.getAll();
	}
	
	@Transactional
	public Theatre getById(Long id) {
		return theatreRepository.getById(id);
	}
	
	@Transactional
	public List<Theatre> getByLocation(String location) {
		return theatreRepository.getByLocation(location);
	}
	
	@Transactional
	public String addTheatre(Theatre theatre) {
		return theatreRepository.add(theatre);
	}
	
	@Transactional
	public String updateTheatre(Theatre theatre, Long id) {
		return theatreRepository.update(theatre,id);
	}
}