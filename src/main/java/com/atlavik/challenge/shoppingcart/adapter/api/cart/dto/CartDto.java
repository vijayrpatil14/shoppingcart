package com.atlavik.challenge.shoppingcart.adapter.api.cart.dto;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import com.atlavik.challenge.shoppingcart.domain.entity.Cart;
import com.atlavik.challenge.shoppingcart.domain.entity.Products;

import io.swagger.annotations.ApiModelProperty;

public class CartDto {
	@ApiModelProperty(hidden = true)
	private UUID id;
	private String countryCode;
	private String currency;
	@ApiModelProperty(hidden = true)
	private List<ProductDto> products;
	@ApiModelProperty(hidden = true)
	private ZonedDateTime created;
	@ApiModelProperty(hidden = true)
	private ZonedDateTime updated;

	public CartDto() {
		super();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public List<ProductDto> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}
	public ZonedDateTime getCreated() {
		return created;
	}
	public void setCreated(ZonedDateTime created) {
		this.created = created;
	}
	public ZonedDateTime getUpdated() {
		return updated;
	}
	public void setUpdated(ZonedDateTime updated) {
		this.updated = updated;
	}

	public static CartDto toCartDto(Cart cart) {
		CartDto cartDto = new CartDto();
		cartDto.setId(cart.getCartId());
		cartDto.setCountryCode(cart.getCountryCode());
		cartDto.setCurrency(cart.getCurrency());
		cartDto.setProducts(ProductDto.toProductDtos(cart.getProducts()));
		cartDto.setCreated(cart.getCreated());
		cartDto.setUpdated(cart.getUpdated());
		return cartDto;
	}

	public Cart toCart() {
		return Cart.builder()
				.id(id)
				.products(Products.toProducts(products))
				.countryCode(countryCode)
				.currency(currency)
				.created(created)
				.updated(updated)
				.build();
	}
}
