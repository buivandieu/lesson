package com.vti.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.form.DepartmentFilterForm;

public interface IAccountService {

	public Page<Account> getAllAccounts(Pageable pageable, String search, DepartmentFilterForm filterForm);
	
	public Account getDepartmentByID(int id);

	public Account getAccountByName(String name);

	public void createAccount(Account department);

	public void updateAccount(int id, String newName);

	public void updateAccount(Account department);

	public void deleteAccount(int id);

	public boolean isAccountExistsByID(int id);

	public boolean isAccountExistsByName(String name);


	
	
}
