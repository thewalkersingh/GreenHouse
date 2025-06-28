package com.thewa.movieticket.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double pricePerSeat;
	private String startTime;
	private String endTime;
	private String date;
	@ManyToOne
	@JoinColumn(name = "movie_id")
	@JsonIgnore
	private Movie movie;
	@ManyToOne
	@JoinColumn(name = "screen_id")
	@JsonIgnore
	private Screen screen;
	@OneToMany(mappedBy = "event")
	@JsonManagedReference
	private List<Seat> seats = new ArrayList<>();
}