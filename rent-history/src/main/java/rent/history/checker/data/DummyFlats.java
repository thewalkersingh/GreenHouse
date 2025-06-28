package rent.history.checker.data;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import rent.history.checker.entity.Flat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DummyFlats {
	public static List<Flat> generateFlats(int numFlats) {
		List<Flat> flats = new ArrayList<>();
		Random random = new Random();
		String[] cities = {"New York", "Los Angeles", "Chicago", "Houston", "Phoenix"};
		String[] states = {"NY", "CA", "IL", "TX", "AZ"};
		String[] flatTypes = {"1bhk", "2bhk", "3bhk"};
		
		for (long i = 0; i < numFlats; i++) {
			Flat flat = new Flat();
			flat.setId(i); // Auto-incrementing ID
			flat.setAddress(generateRandomAddress());
			flat.setCity(cities[random.nextInt(cities.length)]);
			flat.setState(states[random.nextInt(states.length)]);
			flat.setFlatType(flatTypes[random.nextInt(flatTypes.length)]);
			flat.setArea(new BigDecimal(random.nextInt(200) + 30)); // Area between 30 and 230 sqm
			flat.setPrice(new BigDecimal(random.nextInt(5000) + 1000)); // Price between $1000 and $6000
			flat.setDescription(generateRandomDescription());
			flat.setAvailable(random.nextBoolean()); // Randomly set available
			
			flats.add(flat);
		}
		
		return flats;
	}
	
	private static String generateRandomAddress() {
		Random random = new Random();
		String[] streetNames = {"Main St", "Elm St", "Oak St", "Maple St", "Pine St"};
		return String.format("%d %s", random.nextInt(1000) + 1, streetNames[random.nextInt(streetNames.length)]);
	}
	
	private static String generateRandomDescription() {
		Random random = new Random();
		String[] descriptions = {
				"Bright and spacious apartment in a quiet neighborhood.",
				"Modern condo with stunning city views.",
				"Cozy studio perfect for a single professional.",
				"Charming one-bedroom with hardwood floors.",
				"Luxurious two-bedroom with balcony and fireplace."
		};
		return descriptions[random.nextInt(descriptions.length)];
	}
	
	public static void generateFlats() {
		// Generate the desired number of flats
		int numFlats = 5;
		List<Flat> flats = generateFlats(numFlats);
		// Use Jackson ObjectMapper to convert the list of flats to JSON
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String json = objectMapper.writeValueAsString(flats);
			System.out.println(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}