package com.atlavik.challenge.shoppingcart.usecase.AddProductToShoppingCart;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.atlavik.challenge.shoppingcart.adapter.api.cart.dto.CartDto;
import com.atlavik.challenge.shoppingcart.adapter.api.cart.dto.ProductDto;
import com.atlavik.challenge.shoppingcart.adapter.repository.CartRepository;
import com.atlavik.challenge.shoppingcart.domain.entity.Cart;
import com.atlavik.challenge.shoppingcart.domain.entity.Products;

@Service
public class AddProductToCart {

	private static final Logger LOG = LoggerFactory.getLogger(AddProductToCart.class);
	private final CartRepository cartRepository;

	@Autowired
	public AddProductToCart(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	public Optional<CartDto> add(UUID cartId, ProductDto newProduct) {
		Optional<Cart> existingCart = cartRepository.findById(cartId);
		return Optional.ofNullable(existingCart.map(cart -> addProductAndSaveCart(cart,newProduct))
				.map(CartDto::toCartDto).orElse(null));
	}

	@Transactional
	private Cart addProductAndSaveCart(Cart existingCart,  ProductDto newProduct) {
		try {
				addProductToCart(existingCart, newProduct);
				return cartRepository.save(existingCart);
			}
		catch(ObjectOptimisticLockingFailureException e) {
			LOG.warn("Somebody has already added the product:{} in concurrent transaction. Will try again...", newProduct.getId());
			cartRepository.save(existingCart);
		}
		return existingCart;
	}

	private Cart addProductToCart(Cart existingCart,  ProductDto newProduct) {
		Optional<Products> product = confirmProductExistance(existingCart, newProduct);
		if(product.isPresent()) {
			increaseQuantity(product.get(), newProduct.getQuantity());
		}
		else {
			addProduct(existingCart,newProduct);
		}
		existingCart.setUpdated(ZonedDateTime.now());
		return existingCart;
	}

	private Optional<Products> confirmProductExistance(Cart existingCart,  ProductDto newProductDto){
		return existingCart.getProducts().stream()
				.filter(product -> (newProductDto.getCode().equals(product.getCode()))).findFirst();
	} 
	
	private Products increaseQuantity(Products product, int quantity) {
		product.setQuantity(product.getQuantity() + quantity);
		product.setUpdatedDate(ZonedDateTime.now());
		return product;
	}
	
	private Cart addProduct(Cart cart, ProductDto newProductDto) {
		newProductDto.setCreatedDate(ZonedDateTime.now());
		newProductDto.setUpdatedDate(ZonedDateTime.now());
		cart.addProduct(Products.toProducts(newProductDto));
		return cart;
	}


	
}
