package com.rems.yumPortal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rems.yumPortal.entities.Customer;
import com.rems.yumPortal.entities.Executive;
import com.rems.yumPortal.service.CustomerService;
import com.rems.yumPortal.service.ManagerService;

@Controller
public class ManagerController {

	@Autowired
	private ManagerService executiveService;

	@Autowired
	private CustomerService customerService;

//	@PostMapping("/createExecutive")
//	public String createExecutive(Executive executive) {
//		executiveService.createExecutive(executive);
//		return "manager";
//	}
	
	@PostMapping("/createExecutive")
	public String createExecutive(Executive executive, Model model) {
		if (executiveService.createExecutive(executive)) {
			model.addAttribute("message", "Executive  Already Exists!");
		}
		else {
			model.addAttribute("message", "Executive Created Successfully!");
		}
		return "manager";
	}

//	@GetMapping("/getExecutiveDetails")
//	public String getExecutiveDetails(@RequestParam("execid") String id, Model model) {
//		Executive executive = executiveService.getExecutiveDetails(id);
//		model.addAttribute("executive", executive);
//		return "executive";
//	}

//	@GetMapping("/getAllExecutives")
//	public String getAllExecutives(Model model) {
//		List<Executive> executives = executiveService.getAllExecutives();
//		model.addAttribute("executives", executives);
//		return "manager";
//	}
	
	@GetMapping("/getAllExecutives")
	public String getAllExecutives(Model model) {
		List<Executive> executives = executiveService.getAllExecutives();
		if (executives.isEmpty()) {
			model.addAttribute("message", "Executive List is empty!");
		} else {
			model.addAttribute("executives", executives);
		}
		return "manager";
	}

//	@GetMapping("/manager/getAllCustomers")
//	public String getAllCustomers(Model model) {
//		List<Customer> customers = customerService.getAllCustomers();
//		model.addAttribute("customers", customers);
//		return "manager";
//	}
	
	@GetMapping("/manager/getAllCustomers")
	public String getAllCustomers(Model model) {
		List<Customer> customers = customerService.getAllCustomers();
		if (customers.isEmpty()) {
			model.addAttribute("message", "Customer List is empty!");
		} else {
			model.addAttribute("customers", customers);
		}
		return "manager";
	}

//	@GetMapping("/manager/getCustomerDetails")
//	public String getCustomerById(@RequestParam("custid") String id, Model model) {
//		Customer cust = customerService.getCustomerById(id);
//		model.addAttribute("cust", cust);
//		System.out.println("************ " + cust + " ************");
//		return "manager";
//	}
	
	@GetMapping("/manager/getCustomerDetails")
	public String getCustomerById(@RequestParam("custid") String id, Model model) {
		Customer cust = customerService.getCustomerById(id);
		if (cust == null) {
			model.addAttribute("message", "No Customer found with this ID!");
		} else {
			model.addAttribute("cust", cust);
			System.out.println("************ " + cust + " ************");
		}
		return "manager";
	}

//	@GetMapping("/getAllExecutivesByLocality/{locality}")
//	public String getAllExecutivesByLocality(String locality, Model model) {
//		List<Executive> executives = executiveService.getAllExecutivesByLocality(locality);
//		model.addAttribute("executives", executives);
//		return "manager";
//
//	}

	@GetMapping("/getAllExecutivesByLocality/{locality}")
	public String getAllExecutivesByLocality(String locality, Model model) {
		List<Executive> executives = executiveService.getAllExecutivesByLocality(locality);
		if (executives.isEmpty()) {
			model.addAttribute("message", "Executive List is empty!");
		} else {
			model.addAttribute("executives", executives);
		}
		return "manager";

	}
	
	@GetMapping("/assignExecutive")
	public String assignExecutive(@RequestParam("executiveId") String execid, @RequestParam("customerId") String custid) {
		executiveService.assignExecutive(execid, custid);
		return "manager";
	}
	
//	@GetMapping("/assignExecutive")
//	public String assignExecutive(@RequestParam("executiveId") String execid, @RequestParam("customerId") String custid,
//			Model model) {
//		if (executiveService.assignExecutive(execid, custid)) {
//			model.addAttribute("message", "Invalid Customer ID or Executive ID!");
//		}
//		else	{
//			model.addAttribute("message", "Assigned!");
//		}
//		return "manager";
//	}
}
