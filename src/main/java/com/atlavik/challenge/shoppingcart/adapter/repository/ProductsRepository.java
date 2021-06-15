package com.atlavik.challenge.shoppingcart.adapter.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atlavik.challenge.shoppingcart.domain.entity.Products;


@Repository
public interface ProductsRepository extends JpaRepository<Products, UUID>{
	
	Optional<Products> findByCartIdAndProductId(UUID cartId, UUID productId);

}
