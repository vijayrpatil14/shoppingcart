package com.atlavik.challenge.shoppingcart.usecase.CreateShoppingCart;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.atlavik.challenge.shoppingcart.adapter.repository.CartRepositoryMock;
import com.atlavik.challenge.shoppingcart.domain.common.Status;
import com.atlavik.challenge.shoppingcart.domain.entity.Cart;
import com.atlavik.challenge.shoppingcart.domain.entity.Product;

class CreateShoppingCartTest {

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
		createShoppingCart.create(build());
		assertEquals(1, cartRepository.count());
		assertTrue(cartRepository.findById("dummyId").isPresent());
	}

	private Cart build() {
		Cart dummy = new Cart();
		dummy.setId("dummyId");
		dummy.setProducts(products());
		dummy.setTotalCartAmount(0);
		dummy.setTotalCartProducts(0);
		dummy.setCheckOutStatus(Status.LOCKED);
		return dummy;
	}
	
	private List<Product> products(){
		List<Product> products = new ArrayList<Product>();
		return products;
	}

	private void clear() {
		// TODO Auto-generated method stub
		
	}
	
}
