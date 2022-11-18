package com.rems.yumPortal.entities;

import java.util.Set;

import javax.persistence.ElementCollection;

import lombok.Data;

@Data
public class Executive {

	public int id;
	public String name;
	public String contactNumber;
	public String locality;
	public String emailId;
	
	@ElementCollection
	private Set<Customer> customers;
}
