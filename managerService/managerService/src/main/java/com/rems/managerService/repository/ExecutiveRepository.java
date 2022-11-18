package com.rems.managerService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rems.managerService.model.Executive;

@Repository
public interface ExecutiveRepository extends JpaRepository<Executive, Integer> {

	public List<Executive> findByLocality(String locality);
	
	public Optional<Executive> findByName(String name);
	
}
