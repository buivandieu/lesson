package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.form.DepartmentFilterForm;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IDepartmentRepository;
import com.vti.specification.AccountSpecification;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepository repository;

	

	@Override
	public Account getDepartmentByID(int id) {
		// TODO Auto-generated method stub
		return repository.getById(id);
	}

	@Override
	public Account getAccountByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createAccount(Account department) {
		// TODO Auto-generated method stub
		repository.save(department) ;
	}

	@Override
	public void updateAccount(int id, String newName) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void updateAccount(Account department) {
		// TODO Auto-generated method stub
		repository.save(department) ;
	}

	@Override
	public void deleteAccount(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public boolean isAccountExistsByID(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountExistsByName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<Account> getAllAccounts(
			Pageable pageable, 
			String search, 
			DepartmentFilterForm filterForm) {
		
		Specification<Account> where = AccountSpecification.buildWhere(search, filterForm);
		return repository.findAll(where, pageable);
	}
	

	
	

//	public List<Department> getAllDepartments() {
//		return repository.getAllDepartments();
//	}
//
//	public Department getDepartmentByID(int id) {
//		return repository.getDepartmentByID(id);
//	}
//
//	public Department getDepartmentByName(String name) {
//		return repository.getDepartmentByName(name);
//	}
//
//	public void createDepartment(Department department) {
//		repository.createDepartment(department);
//	}
//
//	public void updateDepartment(int id, String newName) {
//		repository.updateDepartment(id, newName);
//	}
//
//	public void updateDepartment(Department department) {
//		repository.updateDepartment(department);
//	}
//
//	public void deleteDepartment(int id) {
//		repository.deleteDepartment(id);
//	}
//
//	public boolean isDepartmentExistsByID(int id) {
//		return repository.isDepartmentExistsByID(id);
//	}
//
//	public boolean isDepartmentExistsByName(String name) {
//		return repository.isDepartmentExistsByName(name);
//	}
}
