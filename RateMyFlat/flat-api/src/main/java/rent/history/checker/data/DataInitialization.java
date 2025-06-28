package rent.history.checker.data;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import rent.history.checker.entity.*;
import rent.history.checker.repository.*;

import java.util.List;

@Configuration
public class DataInitialization {
  @Autowired
  private FlatRepository flatRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private ReviewRepository reviewRepository;
  @Autowired
  private IssueRepository issueRepository;
  @Autowired
  private OwnershipHistoryRepository ownershipHistoryRepository;
  
  @PostConstruct
  public void init() {
	// Save Users and Flats first
	List<User> users = DummyDataGenerator.generateUsers(5);
	userRepository.saveAll(users);
	
	List<Flat> flats = DummyDataGenerator.generateFlats(5);
	flatRepository.saveAll(flats);
	
	// Generate Reviews, Issues, and Ownership Histories referencing saved Flats and Users
	List<Review> reviews = DummyDataGenerator.generateReviews(10, flats, users);
	reviewRepository.saveAll(reviews);
	
	List<Issue> issues = DummyDataGenerator.generateIssues(10, flats);
	issueRepository.saveAll(issues);
	
	List<OwnershipHistory> histories = DummyDataGenerator.generateOwnershipHistories(5, flats, users);
	ownershipHistoryRepository.saveAll(histories);
	
	// Optional: Print the data in JSON format for verification
  }
}