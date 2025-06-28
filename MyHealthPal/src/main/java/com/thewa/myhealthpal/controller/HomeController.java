package com.thewa.myhealthpal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(Model model) {
		// Add any data you want to show on the home.html page
		model.addAttribute("welcomeMessage", "Welcome to the Medical Management System");
		return "home.html";  // home.html.jsp or home.html.html depending on the template engine
	}
	
	@GetMapping("/doctors")
	public String doctors(Model model) {
		return "doctors";  // doctors.jsp or doctors.html
	}
	
	@GetMapping("/patients")
	public String patients(Model model) {
		return "patients";  // patients.jsp or patients.html
	}
	
	@GetMapping("/medicines")
	public String medicines(Model model) {
		return "medicines";  // medicines.jsp or medicines.html
	}
	
	@GetMapping("/login")
	public String login() {
		return "login"; // login.jsp or login.html
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard"; // dashboard.jsp or dashboard.html
	}
}