package railway.com.example.RailwayAndMeal.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import railway.com.example.RailwayAndMeal.Entity.Meal;
import railway.com.example.RailwayAndMeal.Entity.Ticket;
import railway.com.example.RailwayAndMeal.communicator.MealServiceCommunicator;
import railway.com.example.RailwayAndMeal.customException.TicketBodyNotValidException;
import railway.com.example.RailwayAndMeal.customException.TicketNotFoundException;

@Service
public class RailwayService {
	@Autowired
	MealServiceCommunicator mealServiceCommunicator;
	public List<Ticket> list = new ArrayList<>();
	public Map<Long, Ticket> ticketMap = new HashMap<>();
	
	public Ticket getTicketByPnr(long pnr) {
		if (ObjectUtils.isEmpty(ticketMap.get(pnr)))
			throw new TicketNotFoundException("Ticket by given PNR does not exist");
		Ticket ticket = ticketMap.get(pnr);
		Meal meal = mealServiceCommunicator.getMealByPnr(pnr);
		ticket.setMeal(meal);
		return ticket;
	}
	
	public void addTicket(Ticket ticket) {
		ticket.setMeal(new Meal(ticket.getPnr()));
		mealServiceCommunicator.setMeal(ticket.getMeal());
		list.add(ticket);
		ticketMap.put(ticket.getPnr(), ticket);
	}
	
	public List<Ticket> getAllTickets() {
		return list;
	}
	
	public void deleteTicketByPnr(long pnr) {
		Ticket ticket = this.getTicketByPnr(pnr);
		list.remove(ticket);
		ticketMap.remove(ticket.getPnr());
		mealServiceCommunicator.deleteMeal(pnr);
	}
	
	public void updateTicket(Ticket ticket) {
		Ticket existing_ticket = this.getTicketByPnr(ticket.getPnr());
		list.remove(existing_ticket);
		ticketMap.remove(existing_ticket.getPnr());
		list.add(ticket);
		ticketMap.put(ticket.getPnr(), ticket);
	}
	
	public void updateMealPremium(Ticket ticket, Long pnr, boolean isPremium) {
		//write code here
		if (ticket.getPnr() != pnr) throw new TicketBodyNotValidException("Ticket by given PNR and Meal is not valid");
		Ticket existing_ticket = this.getTicketByPnr(ticket.getPnr());
		list.remove(existing_ticket);
		ticketMap.remove(existing_ticket.getPnr());
		Meal existing_meal = existing_ticket.getMeal();
		existing_meal.setPremium(isPremium);
		list.add(ticket);
		ticketMap.put(pnr, ticket);
		mealServiceCommunicator.updateMeal(existing_meal);
	}
}