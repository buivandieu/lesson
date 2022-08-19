package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.entity.Department;
import com.vti.entity.Reports;

public interface IReportsRepository extends JpaRepository<Reports, Integer>, JpaSpecificationExecutor<Reports> {

//	boolean existsByName(String name);
}
