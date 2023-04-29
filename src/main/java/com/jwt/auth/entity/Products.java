package com.jwt.auth.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Products {
	
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String productName;
	private int productCost;
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductCost() {
		return productCost;
	}
	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}
	
	public Products(int id, String productName, int productCost) {
		super();
		this.id = id;
		this.productName = productName;
		this.productCost = productCost;
	}
	@Override
	public String toString() {
		return "Products [id=" + id + ", productName=" + productName + ", productCost=" + productCost + "]";
	}
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
