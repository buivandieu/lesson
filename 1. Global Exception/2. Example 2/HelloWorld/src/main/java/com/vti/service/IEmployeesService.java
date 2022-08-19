package com.vti.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Employees;
import com.vti.form.employees.AccountFilterForm;
import com.vti.form.employees.CreatingEployeesForm;

public interface IEmployeesService {

	public Page<Employees> getAllAccounts(Pageable pageable, String search, AccountFilterForm filterForm);

	
	
	
	public boolean isAccountExistsByUsername(String username);

	public void createAccount(CreatingEployeesForm form);

	public Employees getEmployeesByID(int id);
}
