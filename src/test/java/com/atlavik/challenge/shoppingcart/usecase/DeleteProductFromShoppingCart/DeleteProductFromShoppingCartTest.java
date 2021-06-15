package com.atlavik.challenge.shoppingcart.usecase.DeleteProductFromShoppingCart;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.atlavik.challenge.shoppingcart.adapter.api.cart.dto.ProductDto;
import com.atlavik.challenge.shoppingcart.adapter.repository.ProductsRepositoryMock;
import com.atlavik.challenge.shoppingcart.domain.common.Category;
import com.atlavik.challenge.shoppingcart.domain.entity.Cart;
import com.atlavik.challenge.shoppingcart.domain.entity.Products;

class DeleteProductFromShoppingCartTest {

	private final UUID CART_UUID = UUID.fromString("4144f198-a4be-4e35-8275-8e260c562b36");
	private final UUID PRODUCT_UUID = UUID.fromString("4144f198-a4be-4e35-8275-8e260c562b37");
	private ProductsRepositoryMock productsRepository = new ProductsRepositoryMock();
	private DeleteProductFromShoppingCart deleteProductFromShoppingCart = new DeleteProductFromShoppingCart(productsRepository);
	
	@BeforeEach
	void setUp() throws Exception {
		clear();
	}


	@AfterEach
	void tearDown() throws Exception {
		clear();
	}

	@Test
	void shouldDecreaseProductQuantity() {
		productsRepository.save(products(2));
		Optional<ProductDto> product = deleteProductFromShoppingCart.deleteProduct(CART_UUID, PRODUCT_UUID);		
		assertTrue(product.isPresent());
		assertEquals(1,product.get().getQuantity());
	}
	
	@Test
	void shouldDeleteProductCompletely() {
		productsRepository.save(products(1));
		Optional<ProductDto> product = deleteProductFromShoppingCart.deleteProduct(CART_UUID, PRODUCT_UUID);
		assertFalse(product.isPresent());
	}

	private Products products(int quantity) {
		Products products = new Products();
		products.setId(PRODUCT_UUID);
		products.setCart(Cart.builder().id(CART_UUID).build());
		products.setCategory(Category.ENTERTAINMENT);
		products.setCode("P12345");
		products.setCreatedDate(ZonedDateTime.now());
		products.setUpdatedDate(ZonedDateTime.now());
		products.setDescription("dummy description");
		products.setName("Dummy");
		products.setUnitPrice(1000);
		products.setQuantity(quantity);
		return products;
	}
	
	private void clear() {
		// TODO Auto-generated method stub
		
	}
	
}
