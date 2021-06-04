package com.atlavik.challenge.shoppingcart.adapter.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.atlavik.challenge.shoppingcart.adapter.repository.CartRepository;
import com.atlavik.challenge.shoppingcart.domain.entity.Cart;

public class CartRepositoryMock implements CartRepository  {
	
	Map<String, Cart> shoppingCart = new HashMap<String, Cart>(); 

		@Override
		public List<Cart> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Cart> findAll(Sort sort) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Cart> findAllById(Iterable<String> ids) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Cart> List<S> saveAll(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void flush() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public <S extends Cart> S saveAndFlush(S entity) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Cart> List<S> saveAllAndFlush(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void deleteAllInBatch(Iterable<Cart> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAllByIdInBatch(Iterable<String> ids) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAllInBatch() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Cart getOne(String id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Cart getById(String id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Cart> List<S> findAll(Example<S> example) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Cart> List<S> findAll(Example<S> example, Sort sort) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Page<Cart> findAll(Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Cart> S save(S entity) {
			shoppingCart.put(entity.getId(),entity);
			return entity;
		}

		@Override
		public Optional<Cart> findById(String id) {
			Cart cart = shoppingCart.get(id);
			return Optional.ofNullable(cart);
		}

		@Override
		public boolean existsById(String id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public long count() {
			// TODO Auto-generated method stub
			return shoppingCart.size();
		}

		@Override
		public void deleteById(String id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Cart entity) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAllById(Iterable<? extends String> ids) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll(Iterable<? extends Cart> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public <S extends Cart> Optional<S> findOne(Example<S> example) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Cart> Page<S> findAll(Example<S> example, Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Cart> long count(Example<S> example) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public <S extends Cart> boolean exists(Example<S> example) {
			// TODO Auto-generated method stub
			return false;
		}
}
