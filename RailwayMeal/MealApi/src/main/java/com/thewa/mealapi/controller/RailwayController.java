package com.thewa.mealapi.controller;
import java.util.List;

import com.thewa.mealapi.Entity.Ticket;
import com.thewa.mealapi.customException.TicketBodyNotValidException;
import com.thewa.mealapi.service.RailwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/railway")
public class RailwayController {
	@Autowired
	private RailwayService railwayservice;
	
	@PostMapping("/ticket")
	public void addTicket(@RequestBody Ticket ticket, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) throw new TicketBodyNotValidException("Request Body violates restrictions");
		railwayservice.addTicket(ticket);
	}
	
	@GetMapping("/tickets")
	public List<Ticket> getAllTickets() {
		return railwayservice.getAllTickets();
	}
	
	@GetMapping("/ticket/{pnr}")
	public Ticket getTicketByPnr(@PathVariable long pnr) {
		return railwayservice.getTicketByPnr(pnr);
	}
	
	@DeleteMapping("/ticket/{pnr}")
	public void deleteTicket(@PathVariable long pnr) {
		railwayservice.deleteTicketByPnr(pnr);
	}
	
	@PutMapping("/ticket")
	public void updateTicket(@RequestBody Ticket ticket) {
		railwayservice.updateTicket(ticket);
	}
	
	@PutMapping("/ticket/{pnr}/premium/{isPremium}")
	public void updateTicketPremium(@RequestBody Ticket ticket, Long pnr, @PathVariable boolean isPremium) {
		railwayservice.updateMealPremium(ticket, pnr, isPremium);
	}
}