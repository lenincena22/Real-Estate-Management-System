package com.rems.yumPortal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class YumPortalController {

	@GetMapping("/app")
	public String goToApp() {
		return "app";
	}

	@GetMapping("/customer")
	public String goToCustomer() {
		return "customer";
	}

	@GetMapping("/executive")
	public String goToExecutive() {
		return "executive";
	}

	@GetMapping("/login")
	public String goToLogin() {
		return "login";
	}

	@GetMapping("/manager")
	public String goToManager() {
		return "manager";
	}

	@GetMapping("/register")
	public String goToRegister() {
		return "register";
	}

}
