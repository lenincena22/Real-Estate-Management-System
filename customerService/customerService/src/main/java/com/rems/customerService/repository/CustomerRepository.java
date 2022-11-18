package com.rems.customerService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rems.customerService.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Optional<Customer> findByName(String name);

}
