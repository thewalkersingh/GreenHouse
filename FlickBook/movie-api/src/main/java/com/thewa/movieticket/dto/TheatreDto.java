package com.thewa.movieticket.dto;
import com.thewa.movieticket.model.Location;
import com.thewa.movieticket.model.Screen;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TheatreDto {
	private String name;
	private Long totalScreens;
	private Location location;
	private List<Screen> screens = new ArrayList<>();
}