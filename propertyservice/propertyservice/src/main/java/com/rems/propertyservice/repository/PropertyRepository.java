package com.rems.propertyservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rems.propertyservice.model.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {

	public List<Property> findAllByPropertyType(String PropertyType);
	
	public List<Property> findAllByLocality(String locality);

}
