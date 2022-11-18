package com.rems.yumPortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rems.yumPortal.clients.PropertyServiceClient;
import com.rems.yumPortal.entities.Property;

@Service
public class PropertyService {

	@Autowired
	private PropertyServiceClient propertyClient;

	public void createProperty(Property property) {
		propertyClient.createProperty(property);
	}

	public List<Property> getAllProperties() {
		return propertyClient.getAllProperties();
	}
	
	public List<Property> getAllPropertiesByType(String propertyType) {
		return propertyClient.getAllPropertiesByType(propertyType);
	}
	
	public List<Property> getAllPropertiesByLocality(String locality) {
		return propertyClient.getAllPropertiesByLocality(locality);
	}
}
