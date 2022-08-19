package com.vti.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Department;

public interface IDepartmentService {

	public Page<Department> getAllDepartments(Pageable pageable, String search);
}
