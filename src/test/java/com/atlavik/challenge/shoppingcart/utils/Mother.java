package com.atlavik.challenge.shoppingcart.utils;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.atlavik.challenge.shoppingcart.adapter.api.cart.dto.CartDto;
import com.atlavik.challenge.shoppingcart.adapter.api.cart.dto.ProductDto;
import com.atlavik.challenge.shoppingcart.domain.common.Category;
import com.atlavik.challenge.shoppingcart.domain.entity.Products;

public class Mother {
	
	public static Optional<CartDto> cartDto() {
		CartDto cartDto = new CartDto();
		cartDto.setId(UUID.fromString("4144f198-a4be-4e35-8275-8e260c562b36"));
		cartDto.setCountryCode("USA");
		cartDto.setCurrency("USD");
		cartDto.setCreated(ZonedDateTime.now());
		cartDto.setUpdated(ZonedDateTime.now());
		cartDto.setProducts(new ArrayList<ProductDto>());
		
		return Optional.of(cartDto);
	}
	
	public static Optional<CartDto> cartDtoWithItems() {
		CartDto cartDto = new CartDto();
		cartDto.setId(UUID.fromString("4144f198-a4be-4e35-8275-8e260c562b36"));
		cartDto.setCountryCode("USA");
		cartDto.setCurrency("USD");
		cartDto.setCreated(ZonedDateTime.now());
		cartDto.setUpdated(ZonedDateTime.now());
		cartDto.setProducts(productList());
		
		return Optional.of(cartDto);
	}
	
	public static List<ProductDto> productList(){
		List<ProductDto> cartItems = new ArrayList<ProductDto>();
		cartItems.add(productDto().get());
		return cartItems;
	}
	
	public static Optional<ProductDto> productDto() {
		ProductDto productDto = new ProductDto();
		productDto.setCategory(Category.ELECTRONICS);
		productDto.setCode("USD");
		productDto.setCreatedDate(ZonedDateTime.now());
		productDto.setDescription("Apple iphone 12");
		productDto.setName("Apple iphone");
		productDto.setQuantity(3);
		productDto.setUnitPrice(100);
		productDto.setCode("XYZ123");
		productDto.setUpdatedDate(ZonedDateTime.now());
		return Optional.of(productDto);
	}
	
	public static Optional<ProductDto> cloneProductDto() {
		ProductDto cloneProduct = productDto().get();
		cloneProduct.setQuantity(cloneProduct.getQuantity() - 1);
		return Optional.of(cloneProduct);
	}

}
