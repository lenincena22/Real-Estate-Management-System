package com.rems.managerService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rems.managerService.clients.CustomerServiceClient;
import com.rems.managerService.exceptions.DuplicateExecutiveException;
import com.rems.managerService.model.Customer;
import com.rems.managerService.model.Executive;
import com.rems.managerService.repository.ExecutiveRepository;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ExecutiveRepository executiveRepo;

	@Autowired
	private CustomerServiceClient customerClient;

//	@Override
//	public void createExecutive(Executive executive) {
//		executiveRepo.save(executive);
//	}
	
	@Override
	public String createExecutive(Executive executive) {
		Optional<Executive> existingExecutive = executiveRepo.findByName(executive.getName());
		
		if(existingExecutive.isEmpty()) {
			executiveRepo.save(executive);
			return "Customer Created Successfully";
		}
		else	{
			throw new DuplicateExecutiveException("Executive  Already Exists!");
		}
	}

//	@Override
//	public Executive getExecutiveDetails(int id) {
//		Executive executive = executiveRepo.findById(id).get();
//		return executive;
//	}
	
	@Override
	public Executive getExecutiveDetails(int id) {
		Executive executive = null;
		Optional<Executive> exe = executiveRepo.findById(id);
		if (exe.isPresent()) {
			return exe.get();
		}
		return executive;
	}

	@Override
	public List<Executive> getAllExecutives() {
		List<Executive> executives = executiveRepo.findAll();
		return executives;
	}

	@Override
	public List<Executive> getAllExecutivesByLocality(String locality) {
		List<Executive> executives = executiveRepo.findByLocality(locality);
		return executives;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers = customerClient.getAllCustomers();
		return customers;
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer customer = customerClient.getCustomerById(id);
		return customer;
	}

	@Override
	public void assignExecutive(int execid, int custid) {
		Executive executive = executiveRepo.findById(execid).get();
		Customer customer = customerClient.getCustomerById(custid);
		System.out.println("*****" + customer + "*****");
		executive.getCustomers().add(customer);
		executiveRepo.save(executive);
	}

//	@Override
//	public void assignExecutive(int execid, int custid) {
//		Customer cust = customerClient.getCustomerById(custid);
//		if(cust==null) {
//			Executive executive = executiveRepo.findById(execid).get();
//			Customer customer = customerClient.getCustomerById(custid);
//			executive.getCustomers().add(customer);
//			executiveRepo.save(executive);
//		}
//		else	{
//			throw new ExecutiveNotFoundException("Customer Not Found!");
//		}
//	}

}
