package com.atlavik.challenge.shoppingcart.usecase.DeleteProductFromShoppingCart;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.atlavik.challenge.shoppingcart.adapter.api.cart.dto.ProductDto;
import com.atlavik.challenge.shoppingcart.adapter.repository.ProductsRepository;
import com.atlavik.challenge.shoppingcart.domain.entity.Products;
import com.atlavik.challenge.shoppingcart.usecase.CreateShoppingCart.CreateShoppingCart;

@Service
public class DeleteProductFromShoppingCart {

	private static final Logger LOG = LoggerFactory.getLogger(DeleteProductFromShoppingCart.class);
	private final ProductsRepository productsRepository;

	@Autowired
	public DeleteProductFromShoppingCart(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

	public Optional<ProductDto> deleteProduct(UUID cartId, UUID productId) {
		Optional<Products> availableproduct = productsRepository.findByCartIdAndProductId(cartId, productId);
		return Optional.ofNullable(availableproduct.map(product -> deleteProductFromCart(product)).orElse(null));
	}

	@Transactional
	private ProductDto deleteProductFromCart(Products availableproduct) {	
		try {
			return checkAndPerformDeletion(availableproduct);
		}
		catch(ObjectOptimisticLockingFailureException e) {
			LOG.warn("Concurrent transaction error while deleting product cart. Will try again...");
			return checkAndPerformDeletion(availableproduct);
		}
	}

	private ProductDto checkAndPerformDeletion(Products availableproduct) {
		if(availableproduct.getQuantity() > 1) {
			reduceQuantity(availableproduct);
			return ProductDto.toProductDto(availableproduct);
		} else {
			deleteProductCompletelyFromCart(availableproduct);
		}
		return null;
	}

	private Products reduceQuantity(Products availableproduct) {
		availableproduct.setQuantity(availableproduct.getQuantity() - 1);
		productsRepository.save(availableproduct);
		return availableproduct;
	}


	private void deleteProductCompletelyFromCart(Products availableproduct) {
		productsRepository.delete(availableproduct);
	}
}
