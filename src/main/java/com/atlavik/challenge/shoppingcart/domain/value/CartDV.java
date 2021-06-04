package com.atlavik.challenge.shoppingcart.domain.value;

import java.util.List;

import com.atlavik.challenge.shoppingcart.domain.common.Status;
import com.atlavik.challenge.shoppingcart.domain.entity.Product;

public class CartDV {
	String id; 
	List<Product> products;
	int totalCartProducts;
	double totalCartAmount;
	Status checkOutStatus;
	
	public CartDV() {
		super();
	}
	
	
	public CartDV(String id, List<Product> products, int totalCartProducts, double totalCartAmount,
			Status checkOutStatus) {
		super();
		this.id = id;
		this.products = products;
		this.totalCartProducts = totalCartProducts;
		this.totalCartAmount = totalCartAmount;
		this.checkOutStatus = checkOutStatus;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public int getTotalCartProducts() {
		return totalCartProducts;
	}
	public void setTotalCartProducts(int totalCartProducts) {
		this.totalCartProducts = totalCartProducts;
	}
	public double getTotalCartAmount() {
		return totalCartAmount;
	}
	public void setTotalCartAmount(double totalCartAmount) {
		this.totalCartAmount = totalCartAmount;
	}
	public Status getCheckOutStatus() {
		return checkOutStatus;
	}
	public void setCheckOutStatus(Status checkOutStatus) {
		this.checkOutStatus = checkOutStatus;
	}
	
	
}
