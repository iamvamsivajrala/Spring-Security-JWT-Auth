package com.jwt.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.auth.entity.Products;
import com.jwt.auth.repo.ProductsRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductsRepo productsRepo;
	
	
	
	public List<Products> totalproducts() {
		
		return productsRepo.findAll();
	}

	
	
	public Products findByid(int id) {
		return productsRepo.findById(id).get();
	}
	
}
