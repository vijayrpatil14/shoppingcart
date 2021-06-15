package com.atlavik.challenge.shoppingcart.adapter.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atlavik.challenge.shoppingcart.domain.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, UUID>{

}
