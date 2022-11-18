package com.rems.yumPortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.rems.yumPortal.clients.ManagerServiceClient;
import com.rems.yumPortal.entities.Executive;

@Service
public class ManagerService {

	@Autowired
	private ManagerServiceClient managerClient;

//	public void createExecutive(Executive executive) {
//		managerClient.createExecutive(executive);
//	}
	
	public boolean createExecutive(Executive executive) {
		ResponseEntity<String> resp = managerClient.createExecutive(executive);
		if(resp.getStatusCode().value() != 201) {
			return true;
		}
		return false;
	}

	public Executive getExecutiveDetails(@RequestParam String id) {
		return managerClient.getExecutiveDetails(id);
	}

	public List<Executive> getAllExecutives() {
		return managerClient.getAllExecutives();
	}

//	public Customer getCustomerById(@RequestParam String id) {
//		return managerClient.getCustomerById(id);
//	}

	public List<Executive> getAllExecutivesByLocality(String locality) {
		return managerClient.getAllExecutivesByLocality(locality);
	}

	public String assignExecutive(@RequestParam("executiveId") String execid,
			@RequestParam("customerId") String custid) {
		return managerClient.assignExecutive(execid, custid);
	}
	
//	public boolean assignExecutive(@RequestParam("executiveId") String execid,
//			@RequestParam("customerId") String custid) {
//		ResponseEntity<String> resp = managerClient.assignExecutive(execid, custid);
//		if(resp.getStatusCode().value() != 200) {
//			return true;
//		}
//		return false; 
//	}
	
}
