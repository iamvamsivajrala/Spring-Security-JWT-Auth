package com.jwt.auth.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.auth.entity.Products;

public interface ProductsRepo extends JpaRepository<Products, Integer> {

}
