package railway.com.example.RailwayAndMeal.communicator;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import railway.com.example.RailwayAndMeal.Entity.Meal;

@Service
public class MealServiceCommunicator {
	private final RestTemplate restTemplate;
	String baseURL = "http://localhost:8081/pantry";

	MealServiceCommunicator(RestTemplateBuilder restTemplateBuilder) {
		restTemplate = restTemplateBuilder.build();
	}

	public Meal getMealByPnr(long pnr) {
		String url = baseURL + "/meal/" + pnr;
		Meal meal = restTemplate.getForObject(url, Meal.class);
		return meal;
	}

	public void setMeal(Meal meal) {
		String url = baseURL + "/meal";
		restTemplate.postForEntity(url, meal, Object.class);
	}

	public void deleteMeal(Long pnr) {
		String url = baseURL + "/" + pnr;
		restTemplate.exchange(url, HttpMethod.DELETE, null, Object.class);
	}

	public void updateMeal(Meal meal) {
		String url = baseURL + "/meal/" + meal.getPnr();
		HttpEntity<Meal> mealEntity = new HttpEntity<>(meal);
		restTemplate.exchange(url, HttpMethod.PUT, mealEntity, Object.class);
	}
}