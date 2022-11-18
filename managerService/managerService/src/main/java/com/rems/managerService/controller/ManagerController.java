package com.rems.managerService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rems.managerService.model.Customer;
import com.rems.managerService.model.Executive;
import com.rems.managerService.services.ManagerService;

@RestController
public class ManagerController {

	@Autowired
	private ManagerService executiveService;

	@PostMapping("/createExecutive")
	public ResponseEntity<String> createExecutive(@RequestBody Executive executive) {
		executiveService.createExecutive(executive);
		return new ResponseEntity<String>("Executive Created Successfully!", HttpStatus.CREATED);
	}
	
//  old version
//	@GetMapping("/getExecutiveDetails/{id}")
//	public ResponseEntity<Executive> getExecutiveDetails(@PathVariable int id) {
//		Executive executive = executiveService.getExecutiveDetails(id);
//		return ResponseEntity.ok(executive);
//	}
	
	@GetMapping("/getExecutiveDetails")
	public ResponseEntity<Executive> getExecutiveDetails(@RequestParam("execid") String id) {
		Executive executive = executiveService.getExecutiveDetails(Integer.parseInt(id));
		return ResponseEntity.ok(executive);
	}

	@GetMapping("/getAllExecutives")
	public ResponseEntity<List<Executive>> getAllExecutives() {
		return ResponseEntity.ok(executiveService.getAllExecutives());
	}

	@GetMapping("/getAllExecutivesByLocality/{locality}")
	public ResponseEntity<List<Executive>> getAllExecutivesByLocality(@PathVariable String locality) {
		List<Executive> executives = executiveService.getAllExecutivesByLocality(locality);
		return ResponseEntity.ok(executives);
	}

	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return ResponseEntity.ok(executiveService.getAllCustomers());
	}

	@GetMapping("/getCustomersById/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
		Customer customer = executiveService.getCustomerById(id);
		return ResponseEntity.ok(customer);
	}

	@PutMapping("/assignExecutive")
	public ResponseEntity<String> assignExecutive(@RequestParam("executiveId") String execid,
			@RequestParam("customerId") String custid) {
		executiveService.assignExecutive(Integer.parseInt(execid), Integer.parseInt(custid));
		return new ResponseEntity<>("Executive Assigned Successfully!", HttpStatus.OK);
	}

//	old version
//	@PutMapping("/{executiveId}/assignExecutive/{customerId}")
//	public ResponseEntity<String> assignExecutive(@PathVariable("executiveId") int execid,
//			@PathVariable("customerId") int custid) {
//		executiveService.assignExecutive(execid, custid);
//		return new ResponseEntity<>("Executive Assigned Successfully!", HttpStatus.OK);
//	}

}
