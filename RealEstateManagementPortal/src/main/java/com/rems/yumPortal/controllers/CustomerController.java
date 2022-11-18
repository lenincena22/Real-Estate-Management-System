package com.rems.yumPortal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rems.yumPortal.entities.Customer;
import com.rems.yumPortal.entities.Property;
import com.rems.yumPortal.entities.Requirement;
import com.rems.yumPortal.service.CustomerService;
import com.rems.yumPortal.service.PropertyService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private PropertyService propertyService;

//	@PostMapping("/createCustomer")
//	public String createCustomer(Customer customer) {
//		customerService.createCustomer(customer);
//		return "customer";
//	}
	
	@PostMapping("/createCustomer")
	public String createCustomer(Customer customer,Model model) {
		if(!(customerService.createCustomer(customer))) {
			model.addAttribute("message", "Customer  Already Exists!");
		}
		else {
			model.addAttribute("message", "Customer Created Successfully!");
		}
		return "customer";
	}

//	@GetMapping("/getAllCustomers")
//	public String getAllCustomers(Model model) {
//		List<Customer> customers = customerService.getAllCustomers();
//		model.addAttribute("customers", customers);
//		return "customer";
//	}
	
	@GetMapping("/getAllCustomers")
	public String getAllCustomers(Model model) {
		List<Customer> customers = customerService.getAllCustomers();
		if(customers.isEmpty()) {
			model.addAttribute("message", "Customer List is empty!");
		}else {
		model.addAttribute("customers", customers);
		}
		return "customer";
	}

//	@GetMapping("/getCustomerDetails")
//	public String getCustomerById(@RequestParam("custid") String id, Model model) {
//		Customer cust = customerService.getCustomerById(id);
//		model.addAttribute("cust", cust);
//		System.out.println("************ " + cust + " ************");
//		return "customer";
//	}
	
	@GetMapping("/getCustomerDetails")
	public String getCustomerById(@RequestParam("custid") String id, Model model) {
		Customer cust = customerService.getCustomerById(id);
		if(cust == null) {
			model.addAttribute("message", "No Customer found with this ID!");
		}
		else {
			model.addAttribute("cust", cust);
			System.out.println("************ " + cust + " ************");
		}
		return "customer";
	}

	@GetMapping("/customer/getAllProperties")
	public String getAllProperties(Model model) {
		List<Property> properties = propertyService.getAllProperties();
		model.addAttribute("properties", properties);
		return "customer";
	}

	@GetMapping("/customer/getAllRequirements")
	public String getAllRequirements(Model model) {
		List<Requirement> requirements = customerService.getAllRequirements();
		model.addAttribute("requirements", requirements);
		return "customer";
	}

//	@PutMapping("/assignRequirements")
//	public String assignRequirements(@RequestParam("customerId") String custid,
//			@RequestParam("requirementId") String reqid, Model model) {
//		customerService.assignRequirements(custid, reqid);
//		return "customer";
//	}
	
//	@GetMapping("/assignRequirements")
//	public String assignRequirements(@RequestParam("customerId") String custid,
//			@RequestParam("requirementId") String reqid) {
//		customerService.assignRequirements(custid, reqid);
//		return "customer";
//	}
	
	@GetMapping("/assignRequirements")
	public String assignRequirements(@RequestParam("customerId") String custid,
			@RequestParam("requirementId") String reqid,Model model) {
		if(customerService.assignRequirements(custid, reqid)) {
			model.addAttribute("message", "Invalid Customer ID or Requirement ID!");
		}
		else {
			model.addAttribute("message", "Assigned!");
		}
		return "customer";
	}
}
