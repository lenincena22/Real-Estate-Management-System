package com.rems.yumPortal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rems.yumPortal.entities.Customer;
import com.rems.yumPortal.entities.Executive;
import com.rems.yumPortal.service.CustomerService;
import com.rems.yumPortal.service.ManagerService;

@Controller
public class ExecutiveController {
	
	@Autowired
	private ManagerService executiveService;

	@Autowired
	private CustomerService customerService;
	
//	@GetMapping("/getExecutiveDetails")
//	public String getExecutiveDetails(@RequestParam("execid") String id, Model model) {
//		Executive executive = executiveService.getExecutiveDetails(id);
//		model.addAttribute("executive", executive);
//		return "executive";
//	}
	
	@GetMapping("/getExecutiveDetails")
	public String getExecutiveDetails(@RequestParam("execid") String id, Model model) {
		Executive executive = executiveService.getExecutiveDetails(id);
		if(executive == null) {
			model.addAttribute("message", "No Executive found with this ID!");
		}
		else {
			model.addAttribute("executive", executive);
		}
		
		return "executive";
	}
	
//	@GetMapping("/executive/getCustomerDetails")
//	public String getCustomerById(@RequestParam("custid") String id, Model model) {
//		Customer customer = customerService.getCustomerById(id);
//		model.addAttribute("customer", customer);
//		System.out.println("************ " + customer + " ************");
//		return "executive";
//	}
	
	@GetMapping("/executive/getCustomerDetails")
	public String getCustomerById(@RequestParam("custid") String id, Model model) {
		Customer customer = customerService.getCustomerById(id);
		if(customer == null) {
			model.addAttribute("message", "No Customer found with this ID!");
		}
		else {
			model.addAttribute("customer", customer);
			System.out.println("************ " + customer + " ************");
		}
		return "executive";
	}
	
}
