package com.rems.yumPortal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rems.yumPortal.entities.Property;
import com.rems.yumPortal.service.PropertyService;

@Controller
public class PropertyController {

	@Autowired
	private PropertyService propertyService;

	@GetMapping("/property")
	public String goToProperty() {
		return "property";
	}

	@PostMapping("/createProperty")
	public String createProperty(Property property) {
		propertyService.createProperty(property);
		return "property";
	}

	@GetMapping("/getAllProperties")
	public String getAllProperties(Model model) {
		List<Property> properties = propertyService.getAllProperties();
		model.addAttribute("properties", properties);
		return "property";
	}

	@GetMapping("/getAllPropertiesByType/{propertyType}")
	public String getAllPropertiesByType(String propertyType, Model model) {
		List<Property> properties = propertyService.getAllPropertiesByType(propertyType);
		model.addAttribute("properties", properties);
		return "property";
	}

	@GetMapping("/getAllPropertiesByLocality/{locality}")
	public String getAllPropertiesByLocality(String locality, Model model) {
		List<Property> properties = propertyService.getAllPropertiesByLocality(locality);
		model.addAttribute("properties", properties);
		return "property";
	}
}
