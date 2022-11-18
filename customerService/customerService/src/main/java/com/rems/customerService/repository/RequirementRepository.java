package com.rems.customerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rems.customerService.entities.Requirement;

public interface RequirementRepository extends JpaRepository<Requirement, Integer> {

}
