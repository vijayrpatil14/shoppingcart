package com.atlavik.challenge.shoppingcart.adapter.api.cart;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atlavik.challenge.shoppingcart.adapter.api.cart.dto.CartDto;
import com.atlavik.challenge.shoppingcart.adapter.api.cart.dto.ProductDto;
import com.atlavik.challenge.shoppingcart.usecase.AddProductToShoppingCart.AddProductToCart;
import com.atlavik.challenge.shoppingcart.usecase.DeleteProductFromShoppingCart.DeleteProductFromShoppingCart;

import io.swagger.annotations.Api;

@RestController
@Api(tags = { "Altavik - UC" }, value="Add/Delete Product to/from Shopping Cart", description="Update shopping cart")
public class UpdateController {

	private final AddProductToCart addProductToCart;
	private final DeleteProductFromShoppingCart deleteProductFromShoppingCart;
	
	@Autowired
	public UpdateController(AddProductToCart addProductToCart, DeleteProductFromShoppingCart deleteProductFromShoppingCart) {
		this.addProductToCart = addProductToCart;
		this.deleteProductFromShoppingCart = deleteProductFromShoppingCart;
	}
	
	@PutMapping(value = "api/v1/carts/{cartId}/products")
	public ResponseEntity<CartDto> addProductToCart(@PathVariable("cartId") final UUID cartId, @RequestBody final ProductDto product) throws Exception {
		Optional<CartDto> cart = addProductToCart.add(cartId, product);
		return cart.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());	 
	}
	
	@DeleteMapping(value = "api/v1/carts/{cartId}/products/{productId}")
	public ResponseEntity<ProductDto> deleteProductFromCart(@PathVariable("cartId") final UUID cartId, 
									@PathVariable("productId") final UUID productId) throws Exception {
		Optional<ProductDto> result = deleteProductFromShoppingCart.deleteProduct(cartId, productId);
		return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());		
	}


}
