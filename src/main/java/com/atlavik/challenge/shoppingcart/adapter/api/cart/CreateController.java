package com.atlavik.challenge.shoppingcart.adapter.api.cart;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atlavik.challenge.shoppingcart.adapter.api.cart.dto.CartDto;
import com.atlavik.challenge.shoppingcart.usecase.CreateShoppingCart.CreateShoppingCart;

import io.swagger.annotations.Api;

@RestController
@Api(tags = { "Atlavik - CC" }, value="Create Shopping Cart", description="Create shopping cart")
public class CreateController {
	
	private final CreateShoppingCart createShoppingCart;
	
	@Autowired
	public CreateController(CreateShoppingCart createShoppingCart) {
		this.createShoppingCart = createShoppingCart;
	}

	@PostMapping(value = "api/v1/carts")
	public ResponseEntity<CartDto> createCart(@RequestBody final CartDto cart) {
		Optional<CartDto> createdCart = createShoppingCart.create(cart);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdCart.get());
	}
}
