package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Products;
import com.vti.form.ProductsForm;
import com.vti.service.IProductsService;


@RestController
@RequestMapping(value = "api/v1/Products")
public class ProductsController {

	@Autowired
	private IProductsService service;

	@GetMapping()
	public List<Products> getAllProductss() {
		return service.getAllProducts();
	}

	@GetMapping(value = "/{id}")
	public Products getProductsByID(@PathVariable(name = "id") int id) {
		return service.getProductsByID(id);
	}

	@PostMapping()
	public void createProducts(@RequestBody Products products) {
		
		System.out.println(products.getPrice()+"111111111111");
		service.createProducts(products);
	}

	@PutMapping(value = "/{id}")
	public void updateProducts(@PathVariable(name = "id") int id, @RequestBody Products products) {
		Products Products1 = products;
		Products1.setId(id);
		service.updateProducts(Products1);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteProducts(@PathVariable(name = "id") int id) {
		service.deleteProducts(id);
	}
}
