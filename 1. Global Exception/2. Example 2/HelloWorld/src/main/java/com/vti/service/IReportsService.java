package com.vti.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Department;
import com.vti.entity.Reports;
import com.vti.form.department.CreatingDepartmentForm;
import com.vti.form.department.DepartmentFilterForm;
import com.vti.form.department.UpdatingDepartmentForm;

public interface IReportsService {

	public Page<Reports> getAllReportss(Pageable pageable);

	
}
