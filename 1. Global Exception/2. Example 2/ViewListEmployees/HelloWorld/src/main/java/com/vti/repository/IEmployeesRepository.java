package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.entity.Employees;

public interface IEmployeesRepository extends JpaRepository<Employees, Integer>, JpaSpecificationExecutor<Employees> {

	boolean existsByUsername(String username);
}
