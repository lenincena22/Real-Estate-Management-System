package com.rems.yumPortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.rems.yumPortal.clients.CustomerServiceClient;
import com.rems.yumPortal.entities.Customer;
import com.rems.yumPortal.entities.Requirement;

@Service
public class CustomerService {

	@Autowired
	private CustomerServiceClient customerClient;

//	public void createCustomer(Customer customer) {
//		customerClient.createCustomer(customer);
//	}
	
	public boolean createCustomer(Customer customer) {
		ResponseEntity<String> resp = customerClient.createCustomer(customer);
		
		if(resp.getStatusCode().value() == 201) {
			return true;
		}
		return false;
	}

	public List<Customer> getAllCustomers() {
		return customerClient.getAllCustomers();
	}

	public Customer getCustomerById(@RequestParam String id) {
		return customerClient.getCustomerById(id);
	}

	public List<Requirement> getAllRequirements() {
		return customerClient.getAllRequirements();
	}

//	public String assignRequirements(@RequestParam("customerId") String custid, @RequestParam("requirementId") String reqid) {
//		return customerClient.assignRequirements(custid, reqid);
//	}
	
	public boolean assignRequirements(@RequestParam("customerId") String custid, @RequestParam("requirementId") String reqid) {
		ResponseEntity<String> resp = customerClient.assignRequirements(custid, reqid);
		if(resp.getBody().startsWith("Invalid")) {
			return true;
		}
		return false; 
	}
}
