package com.atlavik.challenge.shoppingcart.domain.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
    name = "cart",
    uniqueConstraints = @UniqueConstraint(name = "uc_licensePlate", columnNames = {"licensePlate"}))
public class Cart implements Serializable {

	private static final long serialVersionUID = 5301411998374056557L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="cart")
	private List<Product> products;
	
	private int totalCartProducts;
	
	private double totalCartAmount;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Status checkOutStatus;
	
	public Cart() {
		super();
	}


	public Cart(String id, List<Product> products,  int totalCartProducts, double totalCartAmount, Status checkOutStatus) {
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


	public static long getSerialversionuid() {
		return serialVersionUID;
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
