package com.rems.customerService.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.rems.customerService.entities.Property;

@FeignClient(name="property-service", url="http://localhost:8082/property")
public interface PropertyServiceClient {
	
	@GetMapping("/getAllProperties")
	List<Property> getAllProperties();
}
