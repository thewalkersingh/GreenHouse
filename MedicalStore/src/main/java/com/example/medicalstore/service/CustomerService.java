package com.example.medicalstore.service;
import com.example.medicalstore.model.Customer;
import com.example.medicalstore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
//	public Customer getCustomerById(int id) {
//		return customerRepository.findById(id).get();
//	}
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
	}
}