package com.atlavik.challenge.shoppingcart.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atlavik.challenge.shoppingcart.domain.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, String>{

}
