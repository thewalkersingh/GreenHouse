package rent.history.checker.data;
import rent.history.checker.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DummyDataGenerator {
  private static final Random random = new Random();
  private static final String[] cities = {"New York", "Los Angeles", "Chicago", "Houston", "Phoenix"};
  private static final String[] states = {"NY", "CA", "IL", "TX", "AZ"};
  private static final String[] flatTypes = {"1bhk", "2bhk", "3bhk"};
  private static final String[] streetNames = {"Main St", "Elm St", "Oak St", "Maple St", "Pine St"};
  private static final String[] descriptions = {
		  "Bright and spacious apartment in a quiet neighborhood.",
		  "Modern condo with stunning city views.",
		  "Cozy studio perfect for a single professional.",
		  "Charming one-bedroom with hardwood floors.",
		  "Luxurious two-bedroom with balcony and fireplace."
  };
  private static final String[] reviewTitles =
		  {"Great place!", "Not so good", "Amazing experience", "Wouldn't recommend", "Perfect stay"};
  private static final String[] reviewTexts = {
		  "Great place, very comfortable!",
		  "Had some issues with maintenance.",
		  "Amazing location and amenities.",
		  "Wouldn't recommend due to noise.",
		  "Perfect for families."
  };
  private static final String[] issueTexts = {
		  "Water leakage in the bathroom.",
		  "Elevator not working.",
		  "Noise from construction nearby.",
		  "Broken window in the living room.",
		  "Air conditioning not functional."
  };
  private static final String[] ownershipNames =
		  {"John Doe", "Jane Smith", "Alice Johnson", "Bob Brown", "Charlie Davis"};
  
  public static List<Flat> generateFlats(int numFlats) {
	List<Flat> flats = new ArrayList<>();
	for (long i = 0; i < numFlats; i++) {
	  Flat flat = new Flat();
	  flat.setId(null); // Set ID to null to auto-generate
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
  
  public static List<User> generateUsers(int numUsers) {
	List<User> users = new ArrayList<>();
	for (long i = 0; i < numUsers; i++) {
	  User user = new User();
	  user.setId(null); // Set ID to null to auto-generate
	  user.setUsername("user" + i);
	  user.setTelephone("123456789" + i);
	  user.setPassword("password" + i);
	  user.setName("Username " + i);
	  user.setAddress(generateRandomAddress());
	  user.setEmail("user" + i + "@demo.com");
	  user.setDateOfBirth(LocalDate.now().minusYears(20 + random.nextInt(30)));
	  user.setRole("USER");
	  users.add(user);
	}
	return users;
  }
  
  private static String generateRandomAddress() {
	return String.format("%d %s", random.nextInt(1000) + 1, streetNames[random.nextInt(streetNames.length)]);
  }
  
  private static String generateRandomDescription() {
	return descriptions[random.nextInt(descriptions.length)];
  }
  
  public static List<Review> generateReviews(int numReviews, List<Flat> flats, List<User> users) {
	List<Review> reviews = new ArrayList<>();
	for (long i = 0; i < numReviews; i++) {
	  Review review = new Review();
	  review.setId(null); // Set ID to null to auto-generate
	  review.setFlat(flats.get(random.nextInt(flats.size())));
	  review.setUser(users.get(random.nextInt(users.size())));
	  review.setTitle(reviewTitles[random.nextInt(reviewTitles.length)]);
	  review.setReviewText(reviewTexts[random.nextInt(reviewTexts.length)]);
	  review.setRating(random.nextInt(5) + 1); // Rating between 1 and 5
	  review.setReviewDate(LocalDate.now().minusDays(random.nextInt(365)));
	  reviews.add(review);
	}
	return reviews;
  }
  
  public static List<Issue> generateIssues(int numIssues, List<Flat> flats) {
	List<Issue> issues = new ArrayList<>();
	for (long i = 0; i < numIssues; i++) {
	  Issue issue = new Issue();
	  issue.setId(null); // Set ID to null to auto-generate
	  issue.setFlat(flats.get(random.nextInt(flats.size())));
	  issue.setDescription(issueTexts[random.nextInt(issueTexts.length)]);
	  issue.setReportedDate(LocalDate.now().minusDays(random.nextInt(365)));
	  issue.setResolved(random.nextBoolean());
	  issue.setResolvedDate(issue.isResolved() ? issue.getReportedDate().plusDays(random.nextInt(30)) : null);
	  issues.add(issue);
	}
	return issues;
  }
  
  public static List<OwnershipHistory> generateOwnershipHistories(
		  int numHistories, List<Flat> flats,
		  List<User> users) {
	List<OwnershipHistory> histories = new ArrayList<>();
	for (long i = 0; i < numHistories; i++) {
	  OwnershipHistory history = new OwnershipHistory();
	  history.setId(null); // Set ID to null to auto-generate
	  history.setFlat(flats.get(random.nextInt(flats.size())));
	  history.setOwner(users.get(random.nextInt(users.size())));
	  history.setOwnershipStartDate(LocalDate.now().minusYears(random.nextInt(5)));
	  history.setOwnershipEndDate(history.getOwnershipStartDate().plusYears(random.nextInt(5)));
	  histories.add(history);
	}
	return histories;
  }
}