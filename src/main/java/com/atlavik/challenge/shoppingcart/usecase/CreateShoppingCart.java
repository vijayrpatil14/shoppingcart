package com.atlavik.challenge.shoppingcart.usecase;

import com.atlavik.challenge.shoppingcart.adapter.repository.CartRepository;
import com.atlavik.challenge.shoppingcart.domain.entity.Cart;

public class CreateShoppingCart {
	
	private final CartRepository cartRepository;
	
	
	public CreateShoppingCart(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}
	
	public void create(Cart cart) {
		cartRepository.save(cart);
	}
}
