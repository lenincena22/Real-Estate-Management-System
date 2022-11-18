package com.rems.managerService.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rems.managerService.model.Customer;

@FeignClient(name="customer-service",url = "http://localhost:8081/customer")
public interface CustomerServiceClient {
	
	@GetMapping("/getCustomerDetails")
	public Customer getCustomerById(@RequestParam("custid") int id);
	
	
	@GetMapping("/getAllCustomers")
	List<Customer> getAllCustomers();
	
}
