package com.example.medicalstore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class MedicalStoreApplication {
   public static void main(String[] args) {
	  SpringApplication.run(MedicalStoreApplication.class, args);
   }
}
//Customers: http://localhost:8080/customers
//Medicines: http://localhost:8080/medicines