package com.rems.yumPortal.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rems.yumPortal.entities.Property;

@FeignClient(name = "property-service", url = "http://localhost:8082/property")
public interface PropertyServiceClient {

	@PostMapping("/createProperty")
	public ResponseEntity<String> createProperty(Property property);

	@GetMapping("/getAllProperties")
	public List<Property> getAllProperties();

	@GetMapping("/getAllPropertiesByType/{propertyType}")
	public List<Property> getAllPropertiesByType(@PathVariable String propertyType);

	@GetMapping("/getAllPropertiesByLocality/{locality}")
	public List<Property> getAllPropertiesByLocality(@PathVariable String locality);
}
