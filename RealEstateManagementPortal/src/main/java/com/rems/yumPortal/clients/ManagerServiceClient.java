package com.rems.yumPortal.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rems.yumPortal.entities.Customer;
import com.rems.yumPortal.entities.Executive;

@FeignClient(name="manager-service", url="http://localhost:8083/manager")
public interface ManagerServiceClient {

	@PostMapping("/createExecutive")
	public ResponseEntity<String> createExecutive(Executive executive);

	@GetMapping("/getExecutiveDetails")
	public Executive getExecutiveDetails(@RequestParam("execid") String id);

	@GetMapping("/getAllExecutives")
	public List<Executive> getAllExecutives();

	@GetMapping("/getAllExecutivesByLocality/{locality}")
	public List<Executive> getAllExecutivesByLocality(@PathVariable String locality);

	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers();

	@GetMapping("/getCustomersById/{id}")
	public Customer getCustomerById(@RequestParam String id);

	@PutMapping("/assignExecutive")
	public String assignExecutive(@RequestParam("executiveId") String execid,
			@RequestParam("customerId") String custid);

}
