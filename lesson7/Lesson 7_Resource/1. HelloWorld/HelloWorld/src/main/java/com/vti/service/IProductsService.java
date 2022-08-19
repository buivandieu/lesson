package com.vti.service;

import java.util.List;


import com.vti.entity.Products;

public interface IProductsService {

	public List<Products> getAllProducts();

	public Products getProductsByID(int id);

	public void createProducts(Products Products);

	public void updateProducts(Products Products);

	public void deleteProducts(int id);

	
}
