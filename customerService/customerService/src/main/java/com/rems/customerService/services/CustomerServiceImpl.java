package com.rems.customerService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rems.customerService.clients.PropertyServiceClient;
import com.rems.customerService.entities.Customer;
import com.rems.customerService.entities.Property;
import com.rems.customerService.entities.Requirement;
import com.rems.customerService.exceptions.CustomerNotFoundException;
import com.rems.customerService.exceptions.DuplicateCustomerException;
import com.rems.customerService.repository.CustomerRepository;
import com.rems.customerService.repository.RequirementRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private RequirementRepository requirementRepo;

	@Autowired
	private PropertyServiceClient propertyClient;

//	@Override
//	public String createCustomer(Customer customer) {
//		customerRepo.save(customer);
//		return "Customer Created Successfully...";
//	}

	@Override
	public String createCustomer(Customer customer) {
		Optional<Customer> existingCustomer = customerRepo.findByName(customer.getName());

		if (existingCustomer.isEmpty()) {
			customerRepo.save(customer);
			return "Customer Created Successfully";
		} else {
			throw new DuplicateCustomerException("Customer  Already Exists!");
		}

	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers = customerRepo.findAll();
		return customers;
	}

	@Override
	public Customer getCustomerDetails(int id) {
		Optional<Customer> result = customerRepo.findById(id);
		Customer customer = null;
		if (result.isPresent()) {
			customer = result.get();
		}
		return customer;
	}

	@Override
	public List<Property> getAllProperties() {
		List<Property> properties = propertyClient.getAllProperties();
		return properties;
	}

	@Override
	public List<Requirement> getAllRequirements() {
		List<Requirement> requirements = requirementRepo.findAll();
		return requirements;
	}

	@Override
	public List<Requirement> createRequirement(List<Requirement> requirement) {
		List<Requirement> require = requirementRepo.saveAll(requirement);
		return require;
	}

//	@Override
//	public void assignRequirements(int custid, int reqid) {
//		Customer customer = customerRepo.findById(custid).get();
//		Requirement requirement = requirementRepo.findById(reqid).get();
//		customer.getRequirements().add(requirement);
//		customerRepo.save(customer);
//	}

	@Override
	public String assignRequirements(int custid, int reqid) {
		Optional<Customer> cust = customerRepo.findById(custid);
		Optional<Requirement> req = requirementRepo.findById(reqid);

		if (cust.isPresent() && req.isPresent()) {
			Customer customer = cust.get();
			Requirement requirement = req.get();
			customer.getRequirements().add(requirement);
			customerRepo.save(customer);
			return "Requirement Assigned Successfully!";
		} else {
			throw new CustomerNotFoundException("Invalid Customer ID or Requirement ID!");
		}
	}

}
