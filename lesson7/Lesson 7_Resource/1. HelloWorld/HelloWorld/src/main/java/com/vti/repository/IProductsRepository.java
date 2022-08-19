package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Products;



public interface IProductsRepository extends JpaRepository<Products, Integer> {

}
