package com.rems.managerService.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Customer {
	
	private int id;
	private String name;
	private String address;
	private String emailId;
	private String contactNumber;
	
//	@ElementCollection
//	private Set<Executive> executive;
//	
//	@OneToMany
//	private Set<Customer> customers;
}
