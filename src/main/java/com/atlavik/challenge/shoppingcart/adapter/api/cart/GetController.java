package com.atlavik.challenge.shoppingcart.adapter.api.cart;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.atlavik.challenge.shoppingcart.adapter.api.cart.dto.CartDto;
import com.atlavik.challenge.shoppingcart.usecase.GetShoppingCart.GetShoppingCart;

import io.swagger.annotations.Api;

@RestController
@Api(tags = { "Altavik - GC" }, value="Get Shopping Cart", description="Get shopping cart")
public class GetController {

	private final GetShoppingCart getShoppingCart;
	
	@Autowired
	public GetController(GetShoppingCart getShoppingCart) {
		this.getShoppingCart = getShoppingCart;
	}
	
	@GetMapping(value = "api/v1/carts/{cartId}")
	public ResponseEntity<CartDto> getCart(@PathVariable("cartId") final UUID cartId) {
		Optional<CartDto> cart = getShoppingCart.findByCartId(cartId);
		return cart.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());		
	}
}
