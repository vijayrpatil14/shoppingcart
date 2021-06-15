package com.atlavik.challenge.shoppingcart.usecase.AddProductToShoppingCart;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.atlavik.challenge.shoppingcart.adapter.api.cart.dto.CartDto;
import com.atlavik.challenge.shoppingcart.adapter.repository.CartRepositoryMock;
import com.atlavik.challenge.shoppingcart.adapter.repository.ProductsRepositoryMock;
import com.atlavik.challenge.shoppingcart.domain.entity.Cart;
import com.atlavik.challenge.shoppingcart.domain.entity.Products;
import com.atlavik.challenge.shoppingcart.usecase.CreateShoppingCart.CreateShoppingCart;
import com.atlavik.challenge.shoppingcart.utils.Mother;

class AddProductToCartTest {

	private CartRepositoryMock cartRepository = new CartRepositoryMock();
	private CreateShoppingCart createShoppingCart = new CreateShoppingCart(cartRepository);
	private AddProductToCart addProductToCart = new AddProductToCart(cartRepository);
	private final UUID DUMMY_UUID = UUID.fromString("4144f198-a4be-4e35-8275-8e260c562b36");
	
	@BeforeEach
	void setUp() throws Exception {
		clear();
	}


	@AfterEach
	void tearDown() throws Exception {
		clear();
	}

	@Test
	void shouldAddProductToCart() throws Exception {
		createShoppingCart.create(Mother.cartDto().get());
		addProductToCart.add(DUMMY_UUID, Mother.productDto().get());
		Optional<Cart> cart = cartRepository.findById(DUMMY_UUID);
		assertTrue(cart.isPresent());
		assertEquals(1, cart.get().getProducts().size());
	}

	@Test
	void shouldIncreaseQuantityForExistingProduct() {
		createShoppingCart.create(Mother.cartDto().get());
		addProductToCart.add(DUMMY_UUID, Mother.productDto().get());
		addProductToCart.add(DUMMY_UUID, Mother.productDto().get());
		Optional<Cart> cart = cartRepository.findById(DUMMY_UUID);
		assertTrue(cart.isPresent());
		assertEquals(6, cart.get().getProducts().get(0).getQuantity());
	}
	
	private void clear() {
		// TODO Auto-generated method stub
		
	}
	
}
