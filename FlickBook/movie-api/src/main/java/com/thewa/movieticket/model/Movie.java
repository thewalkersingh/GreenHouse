package com.thewa.movieticket.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "movie")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	@Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;
	private String movieName;
	private String movieYear;
	private Double movieDuration;
	private String movieDescription;
	@ElementCollection private List<String> mediaLinks;
	@ElementCollection private List<String> movieLanguage;
	@ElementCollection private List<String> genres;
	@ManyToMany @JoinTable(name = "movie_cast", joinColumns = @JoinColumn(name = "movie_id"),
	                       inverseJoinColumns = @JoinColumn(name = "cast_id")) @JsonManagedReference
	private List<Cast> casts = new ArrayList<>();
}