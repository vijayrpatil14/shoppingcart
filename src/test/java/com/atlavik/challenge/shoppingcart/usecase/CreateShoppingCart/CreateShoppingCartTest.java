package com.atlavik.challenge.shoppingcart.usecase.CreateShoppingCart;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.atlavik.challenge.shoppingcart.adapter.repository.CartRepositoryMock;
import com.atlavik.challenge.shoppingcart.utils.Mother;

class CreateShoppingCartTest {

	private final UUID DUMMY_UUID = UUID.fromString("4144f198-a4be-4e35-8275-8e260c562b36");
	private CartRepositoryMock cartRepository = new CartRepositoryMock();
	private CreateShoppingCart createShoppingCart = new CreateShoppingCart(cartRepository);
	
	@BeforeEach
	void setUp() throws Exception {
		clear();
	}


	@AfterEach
	void tearDown() throws Exception {
		clear();
	}

	@Test
	void shouldCreateShoppingCart() {
		createShoppingCart.create(Mother.cartDto().get());
		assertEquals(1, cartRepository.count());
		assertTrue(cartRepository.findById(DUMMY_UUID).isPresent());
	}

	private void clear() {
		// TODO Auto-generated method stub
		
	}
	
}
