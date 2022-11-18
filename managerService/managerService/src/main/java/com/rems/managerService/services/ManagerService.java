package com.rems.managerService.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rems.managerService.model.Customer;
import com.rems.managerService.model.Executive;

@Service
public interface ManagerService {

	public String createExecutive(Executive executive);
	
	public Executive getExecutiveDetails(int id);

	public List<Executive> getAllExecutives();

	public List<Executive> getAllExecutivesByLocality(String locality);

	public List<Customer> getAllCustomers();
	
	public Customer getCustomerById(int id);	
	
	public void assignExecutive(int executiveid, int customerid);

}
