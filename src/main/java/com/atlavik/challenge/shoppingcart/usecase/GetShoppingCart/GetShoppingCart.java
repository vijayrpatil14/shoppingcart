package com.atlavik.challenge.shoppingcart.usecase.GetShoppingCart;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.atlavik.challenge.shoppingcart.adapter.api.cart.dto.CartDto;
import com.atlavik.challenge.shoppingcart.adapter.repository.CartRepository;

@Service
public class GetShoppingCart {

	private final CartRepository cartRepository;

	public GetShoppingCart(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	public Optional<CartDto> findByCartId(final UUID cartId) {
		return Optional.ofNullable(cartRepository.findById(cartId).map(CartDto::toCartDto).orElse(null));
	}
}
