package com.example.medicalstore.controller;
import com.example.medicalstore.model.Customer;
import com.example.medicalstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
   @Autowired
   private CustomerService customerService;
   
   @GetMapping("")
   public String getAllCustomers(Model model) {
	  List<Customer> customers = customerService.getAllCustomers();
	  model.addAttribute("customers", customers);
	  return "customers";
   }
   
   @GetMapping("/new")
   public String createCustomerForm(Model model) {
	  model.addAttribute("customer", new Customer());
	  return "create_customer";
   }
   
   @PostMapping("")
   public String saveCustomer(@ModelAttribute("customer") Customer customer) {
	  customerService.saveCustomer(customer);
	  return "redirect:/customers";
   }
}