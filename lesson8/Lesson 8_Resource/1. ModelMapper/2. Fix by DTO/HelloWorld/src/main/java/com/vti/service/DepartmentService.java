package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.entity.Department;
import com.vti.repository.IDepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository repository;
	

	
	@Override
	public Department getDepartmentByID(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public Department getDepartmentByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createDepartment(Department department) {
		repository.save(department) ;
	}

	@Override
	public void updateDepartment(int id, String newName) {
		
		
	}

	@Override
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		repository.save(department) ;
	}

	@Override
	public void deleteDepartment(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isDepartmentExistsByID(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDepartmentExistsByName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<Department> getAllDepartments(Pageable pageable) {
		// TODO Auto-generated method stub
		return repository.findAll(pageable);
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
