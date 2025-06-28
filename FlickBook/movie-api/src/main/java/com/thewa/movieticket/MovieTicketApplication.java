package com.thewa.movieticket;
import io.swagger.v3.oas.models.annotations.OpenAPI31;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPI31
@SpringBootApplication
public class MovieTicketApplication {
	public static void main(String[] args) {
		SpringApplication.run(MovieTicketApplication.class, args);
	}
}