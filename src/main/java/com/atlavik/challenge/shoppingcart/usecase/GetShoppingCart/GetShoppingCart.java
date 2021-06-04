package com.atlavik.challenge.shoppingcart.usecase.GetShoppingCart;

import java.util.List;
import java.util.Optional;

import com.atlavik.challenge.shoppingcart.adapter.repository.CartRepository;
import com.atlavik.challenge.shoppingcart.domain.entity.Cart;

public class GetShoppingCart {

private final CartRepository cartRepository;
	
	
	public GetShoppingCart(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}
	
	public Optional<Cart> findByCartId(final String cartId) {
		return cartRepository.findById(cartId);
	}
	
	public List<Cart> findAllCarts() {
		return cartRepository.findAll();
	}
}
