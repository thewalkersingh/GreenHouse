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
@NoArgsConstructor
@AllArgsConstructor
public class Theatre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Long totalScreens;
	@ManyToOne
	@JoinColumn(name = "location_id")
	@JsonIgnore
	private Location location;
	@OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Screen> screens = new ArrayList<>();
}