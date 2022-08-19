package com.vti.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vti.entity.Employees;
import com.vti.entity.Reports;
import com.vti.entity.Department;
import com.vti.form.department.CreatingDepartmentForm;
import com.vti.form.department.DepartmentFilterForm;
import com.vti.form.department.UpdatingDepartmentForm;
import com.vti.repository.IEmployeesRepository;
import com.vti.repository.IReportsRepository;
import com.vti.repository.IDepartmentRepository;
import com.vti.specification.department.DepartmentSpecification;

@Service
public class ReportsService implements IReportsService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private IReportsRepository repository;
	
	
	

	@Override
	public Page<Reports> getAllReportss(Pageable pageable) {
		
		return repository.findAll(pageable) ;
	}

}
