package com.thewa.movieticket.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cast {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String about;
	@ElementCollection
	private List<String> occupation;
	private String profile_link;
	@ManyToMany(mappedBy = "casts")
	@JsonIgnore
	private List<Movie> movies;
}