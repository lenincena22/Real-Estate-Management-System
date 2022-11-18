package com.rems.customerService.services;

import java.util.List;

import com.rems.customerService.entities.Customer;
import com.rems.customerService.entities.Property;
import com.rems.customerService.entities.Requirement;

public interface CustomerService {

	public String createCustomer(Customer customer);

	public List<Customer> getAllCustomers();

	public Customer getCustomerDetails(int id);

	public List<Property> getAllProperties();

	public List<Requirement> getAllRequirements();
	
	public List<Requirement> createRequirement(List<Requirement> requirement);
	
	public String assignRequirements(int custid, int reqid);
}
