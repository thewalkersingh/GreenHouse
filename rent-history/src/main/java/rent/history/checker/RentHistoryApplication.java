package rent.history.checker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.models.annotations.OpenAPI31;

@SpringBootApplication
@OpenAPI31
public class RentHistoryApplication {
	public static void main(String[] args) {
		SpringApplication.run(RentHistoryApplication.class, args);
	}
}