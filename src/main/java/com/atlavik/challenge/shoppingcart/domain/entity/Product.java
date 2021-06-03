package com.atlavik.challenge.shoppingcart.domain.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable{

	private static final long serialVersionUID = -512086600445499521L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column(nullable = false)
	private String name;
	private String description;
	@Enumerated(EnumType.STRING)
	private Category category;
	@Column(nullable = false)
	private String code;
	@Column(nullable = false)
	private double unitPrice;
	private int quantity;
	private ZonedDateTime createdDate;
	private ZonedDateTime updatedDate;
	
	@ManyToOne
    @JoinColumn(name="id", nullable=false)
    private Cart cart;
	
	Product(){}
	
	public Product(String id, String name, String description, Category category, String code, double unitPrice,
			int quantity, ZonedDateTime createdDate, ZonedDateTime updatedDate) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.code = code;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ZonedDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(ZonedDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public ZonedDateTime getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(ZonedDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
