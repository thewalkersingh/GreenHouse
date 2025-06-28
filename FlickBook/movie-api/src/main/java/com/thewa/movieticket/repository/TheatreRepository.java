package com.thewa.movieticket.repository;
import com.thewa.movieticket.model.Theatre;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TheatreRepository {
	@Autowired
	private EntityManager entityManager;
	
	public List<Theatre> getAll() {
		Session session = entityManager.unwrap(Session.class);
		return session.createQuery("select t from Theatre t", Theatre.class).getResultList();
	}
	
	public Theatre getById(Long theatreId) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Theatre.class, theatreId);
	}
	
	public List<Theatre> getByLocation(String location) {
		Session session = entityManager.unwrap(Session.class);
		List<Theatre> theatresByLocation = new ArrayList<Theatre>();
		List<Theatre> allTheaters = getAll();
		for (Theatre theatre : allTheaters) {
			if (theatre.getLocation().getRegion().equalsIgnoreCase(location)) {
				theatresByLocation.add(theatre);
			}
		}
		return theatresByLocation;
	}
	
	public String add(Theatre theatre) {
		Session session = entityManager.unwrap(Session.class);
		session.persist(theatre);
		return "Theatre added successfully";
	}
	
	public String update(Theatre theatre, Long id) {
		Session session = entityManager.unwrap(Session.class);
		Theatre savedTheatre = session.get(Theatre.class, id);
		savedTheatre.setName(theatre.getName());
		savedTheatre.setLocation(theatre.getLocation());
		savedTheatre.setTotalScreens(theatre.getTotalScreens());
		savedTheatre.setScreens(theatre.getScreens());
		session.merge(theatre);
		return "Theatre updated successfully";
	}
}