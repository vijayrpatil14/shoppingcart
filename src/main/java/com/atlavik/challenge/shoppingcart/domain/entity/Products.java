package com.atlavik.challenge.shoppingcart.domain.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.atlavik.challenge.shoppingcart.adapter.api.cart.dto.ProductDto;
import com.atlavik.challenge.shoppingcart.domain.common.Category;

@Entity
@Table(name = "products")
public class Products implements Serializable{

	private static final long serialVersionUID = -512086600445499521L;

	@Id
	@GeneratedValue
	@Column( columnDefinition = "uuid", updatable = false )
	private UUID productId;
	@Version
	private int version;
	@Column(nullable = false)
	private String name;
	private String description;
	@Enumerated(EnumType.STRING)
	@Column
	private Category category;
	@Column(nullable = false)
	private String code;
	@Column(nullable = false)
	private double unitPrice;
	private int quantity;
	private ZonedDateTime createdDate;
	private ZonedDateTime updatedDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Cart cart;
	
	public Products(){}
	
	public Products(UUID productId, String name, String description, Category category, String code, double unitPrice,
			int quantity, ZonedDateTime createdDate, ZonedDateTime updatedDate) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.category = category;
		this.code = code;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public UUID getId() {
		return productId;
	}
	public void setId(UUID id) {
		this.productId = id;
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
	
	public static ProductBuilder builder() {
		return new ProductBuilder();
	}

	public static class ProductBuilder {
		UUID id;
		String name;
		String description;
		Category category;
		String code;
		double unitPrice;
		int quantity;
		ZonedDateTime createdDate;
		ZonedDateTime updatedDate;
		
		ProductBuilder(){}
		
		public ProductBuilder id(final UUID id) {
			this.id = id;
			return this;
		}
		
		public ProductBuilder name(final String name) {
			this.name = name;
			return this;
		}
		
		public ProductBuilder description(final String description) {
			this.description = description;
			return this;
		}
		
		public ProductBuilder category(final Category category) {
			this.category = category;	
			return this;
		}
		
		public ProductBuilder code(final String code) {
			this.code = code;
			return this;
		}
		
		public ProductBuilder unitPrice(final double unitPrice) {
			this.unitPrice = unitPrice;
			return this;
		}
		
		public ProductBuilder quantity(final int quantity) {
			this.quantity = quantity;
			return this;
		}
		
		public ProductBuilder createdDate(final ZonedDateTime createdDate) {
			this.createdDate = createdDate;
			return this;
		}
		
		public ProductBuilder updatedDate(final ZonedDateTime updatedDate) {
			this.updatedDate = updatedDate;
			return this;
		}
		
		public Products build() {
			return new Products(id, name, description, category, code, unitPrice, quantity,
					createdDate, updatedDate);
		}
	}
	
	public static List<Products> toProducts(List<ProductDto> productsDto) {
		return productsDto.stream().map(Products::toProducts).collect(Collectors.toList());
	}
	
	public static Products toProducts(ProductDto productDto) {
		Products product = new Products();
		//product.setId(productDto.getId());
		product.setName(productDto.getName());
		product.setDescription(productDto.getDescription());
		product.setCategory(productDto.getCategory());
		product.setCode(productDto.getCode());
		product.setUnitPrice(productDto.getUnitPrice());
		product.setQuantity(productDto.getQuantity());
		product.setCreatedDate(productDto.getCreatedDate());
		product.setUpdatedDate(productDto.getUpdatedDate());
		return product;
	}
	
}
