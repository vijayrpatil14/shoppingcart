package com.atlavik.challenge.shoppingcart.usecase.CreateShoppingCart;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.atlavik.challenge.shoppingcart.adapter.api.cart.dto.CartDto;
import com.atlavik.challenge.shoppingcart.adapter.api.cart.dto.ProductDto;
import com.atlavik.challenge.shoppingcart.adapter.repository.CartRepository;
import com.atlavik.challenge.shoppingcart.usecase.AddProductToShoppingCart.AddProductToCart;

@Service
public class CreateShoppingCart {
	private static final Logger LOG = LoggerFactory.getLogger(CreateShoppingCart.class);	
	private final CartRepository cartRepository;
	
	@Autowired
	public CreateShoppingCart(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}
	
	@Transactional
	public Optional<CartDto> create(CartDto cart) {
		try {
				lockAndUpdateCart(cart);
				return Optional.ofNullable(CartDto.toCartDto(cartRepository.save(cart.toCart())));
			}
		catch(ObjectOptimisticLockingFailureException e) {
			LOG.warn("Concurrent transaction error while creating cart. Will try again...");
			return Optional.ofNullable(CartDto.toCartDto(cartRepository.save(cart.toCart())));
		}
	}

	private CartDto lockAndUpdateCart(CartDto cart) { 
		cart.setCreated(ZonedDateTime.now());
		cart.setUpdated(ZonedDateTime.now());
		cart.setProducts(new ArrayList<ProductDto>());
		return cart;
	}
}
