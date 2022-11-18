package com.rems.propertyservice.service;

import java.util.List;

import com.rems.propertyservice.model.Property;

public interface PropertyService {
	
	public void createProperty(Property property);

	public List<Property> getAllProperties();

	public List<Property> getAllPropertiesByType(String propertyType);

	public List<Property> getAllPropertiesByLocality(String locality);
}
