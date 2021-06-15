package com.atlavik.challenge.shoppingcart.usecase.GetShoppingCart;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.atlavik.challenge.shoppingcart.adapter.api.cart.dto.CartDto;
import com.atlavik.challenge.shoppingcart.adapter.repository.CartRepositoryMock;
import com.atlavik.challenge.shoppingcart.usecase.CreateShoppingCart.CreateShoppingCart;
import com.atlavik.challenge.shoppingcart.utils.Mother;

class GetShoppingCartTest {

	private final UUID DUMMY_UUID = UUID.fromString("4144f198-a4be-4e35-8275-8e260c562b36");
	private final UUID ANOTHER_UUID = UUID.fromString("4144f198-a4be-4e35-8275-8e260c562b37");
	private CartRepositoryMock cartRepository = new CartRepositoryMock();
	private CreateShoppingCart createShoppingCart = new CreateShoppingCart(cartRepository);
	private GetShoppingCart getShoppingCart = new GetShoppingCart(cartRepository);
	
	@BeforeEach
	void setUp() throws Exception {
		clear();
		createShoppingCart.create(Mother.cartDto().get());
	}

	@AfterEach
	void tearDown() throws Exception {
		clear();
	}

	@Test
	void shouldFindShoppingCartById() {
		Optional<CartDto> cart = getShoppingCart.findByCartId(DUMMY_UUID);
		assertTrue(cart.isPresent());
	}
	
	@Test
	void shouldNotFindShoppingCartById() {
		Optional<CartDto> cart = getShoppingCart.findByCartId(ANOTHER_UUID);
		assertFalse(cart.isPresent());
	}
	
	private void clear() {
		// TODO Auto-generated method stub
		
	}
	
}
