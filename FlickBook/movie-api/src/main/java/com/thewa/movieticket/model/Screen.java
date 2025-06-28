package com.thewa.movieticket.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.thewa.movieticket.constants.AudioType;
import com.thewa.movieticket.constants.VideoType;
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
public class Screen {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private AudioType audioType;
	private VideoType videoType;
	private int total_seats;
	@ManyToOne
	@JoinColumn(name = "theatre_id")
	@JsonBackReference
	private Theatre theatre;
	@OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Event> event = new ArrayList<>();
}