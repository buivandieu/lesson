package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.vti.entity.Products;
import com.vti.repository.IProductsRepository;


@Service
public class ProductsSevice implements IProductsService {

	@Autowired
	private IProductsRepository repository;

	@Override
	public List<com.vti.entity.Products> getAllProducts() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public com.vti.entity.Products getProductsByID(int id) {
		// TODO Auto-generated method stub
		return repository.getById(id);
	}

	@Override
	public void createProducts(Products Products) {
		repository.save(Products) ;
		
	}

	@Override
	public void updateProducts(Products Products) {
		repository.save(Products) ;
		
	}

	@Override
	public void deleteProducts(int id) {
	repository.deleteById(id);
		
	}

//	public List<Products> getAllProductss() {
//		return repository.findAll();
//	}
//
//	public Department getDepartmentByID(int id) {
//		return repository.findById(id).get();
//	}
//
//	public void createDepartment(Department department) {
//		repository.save(department);
//	}
//
//	public void updateDepartment(Department department) {
//		repository.save(department);
//	}
//
//	public void deleteDepartment(int id) {
//		repository.deleteById(id);
//	}
//
//	public boolean isDepartmentExistsByID(int id) {
//		return repository.existsById(id);
//	}

}
