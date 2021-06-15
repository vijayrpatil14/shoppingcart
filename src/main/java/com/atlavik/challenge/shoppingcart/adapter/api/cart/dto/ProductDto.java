package com.atlavik.challenge.shoppingcart.adapter.api.cart.dto;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.atlavik.challenge.shoppingcart.domain.common.Category;
import com.atlavik.challenge.shoppingcart.domain.entity.Products;

import io.swagger.annotations.ApiModelProperty;

public class ProductDto {
	@ApiModelProperty(hidden = true)
	private UUID id; 
	private String name; 
	private String description;
	private Category category;
	private String code;
	private double unitPrice;
	private int quantity;
	@ApiModelProperty(hidden = true)
	private ZonedDateTime createdDate;
	@ApiModelProperty(hidden = true)
	private ZonedDateTime updatedDate;

	public ProductDto() {
		super();
	}

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
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

	public static List<ProductDto> toProductDtos(List<Products> products) {
		return products.stream().map(ProductDto::toProductDto).collect(Collectors.toList());
	}

	public static ProductDto toProductDto(Products product) {
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setDescription(product.getDescription());
		productDto.setCategory(product.getCategory());
		productDto.setCode(product.getCode());
		productDto.setUnitPrice(product.getUnitPrice());
		productDto.setQuantity(product.getQuantity());
		productDto.setCreatedDate(product.getCreatedDate());
		productDto.setUpdatedDate(product.getUpdatedDate());
		return productDto;
	}
}
