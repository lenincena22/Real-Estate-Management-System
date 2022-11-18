package com.rems.yumPortal.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rems.yumPortal.entities.Customer;
import com.rems.yumPortal.entities.Property;
import com.rems.yumPortal.entities.Requirement;

@FeignClient(name = "customer-service", url = "http://localhost:8081/customer")
public interface CustomerServiceClient {

	@PostMapping("/createCustomer")
	public ResponseEntity<String> createCustomer(Customer customer);

	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers();

	@GetMapping("/getCustomerDetails")
	public Customer getCustomerById(@RequestParam("custid") String id);

	@GetMapping("/getProperties")
	public List<Property> getAllProperties();

	@GetMapping("/getAllRequirements")
	public List<Requirement> getAllRequirements();

	@PutMapping("/assignRequirements")
	public ResponseEntity<String> assignRequirements(@RequestParam("customerId") String custid,
			@RequestParam("requirementId") String reqid);
}
