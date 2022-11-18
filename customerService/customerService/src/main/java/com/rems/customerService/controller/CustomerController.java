package com.rems.customerService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rems.customerService.entities.Customer;
import com.rems.customerService.entities.Property;
import com.rems.customerService.entities.Requirement;
import com.rems.customerService.services.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/createCustomer")
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
		customerService.createCustomer(customer);
		return new ResponseEntity<>("Customer Created Successfully!", HttpStatus.CREATED);
	}

	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return ResponseEntity.ok(customerService.getAllCustomers());
	}

//	old version
//	@GetMapping("/getCustomerDetails/{id}")
//	public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
//		Customer customer = customerService.getCustomerDetails(id);
//		return ResponseEntity.ok(customer);
//	}

	@GetMapping("/getCustomerDetails")
	public ResponseEntity<Customer> getCustomerById(@RequestParam("custid") String id) {
		Customer customer = customerService.getCustomerDetails(Integer.parseInt(id));
		return ResponseEntity.ok(customer);
	}

	@GetMapping("/getProperties")
	public ResponseEntity<List<Property>> getAllProperties() throws Exception {
		return ResponseEntity.ok(customerService.getAllProperties());
	}

	@GetMapping("/getAllRequirements")
	public ResponseEntity<List<Requirement>> getAllRequirements() {
		return ResponseEntity.ok(customerService.getAllRequirements());
	}

	@PostMapping("/createRequirement")
	public ResponseEntity<String> createRequirement(@RequestBody List<Requirement> requirement) {
		customerService.createRequirement(requirement);
		return new ResponseEntity<>("Requirement Created Successfully!", HttpStatus.CREATED);
	}

	@PutMapping("/assignRequirements")
	public ResponseEntity<String> assignRequirements(@RequestParam("customerId") String custid,
			@RequestParam("requirementId") String reqid) {
		customerService.assignRequirements(Integer.parseInt(custid), Integer.parseInt(reqid));
		return new ResponseEntity<>("Requirement Assigned Successfully!", HttpStatus.OK);
	}
	
//	old  version
//	@PutMapping("/{customerId}/assignRequirements/{requirementId}")
//	public ResponseEntity<String> assignRequirements(@pathvariable("customerId") int custid,
//			@pathvariable("requirementId") int reqid) {
//		customerService.assignRequirements(custid, reqid);
//		return new ResponseEntity<>("Requirement Assigned Successfully!", HttpStatus.OK);
//	}
}
