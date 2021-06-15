package com.atlavik.challenge.shoppingcart.domain.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity
@Table(name = "cart")
public class Cart implements Serializable {

	private static final long serialVersionUID = 5301411998374056557L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column( columnDefinition = "uuid", updatable = false )
	private UUID id;
	@Version
	private int version;
	private String countryCode;
	private String currency;
	private ZonedDateTime created;
	private ZonedDateTime updated;
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<Products> products = new ArrayList<Products>();

	public Cart() {
		super();
	}


	public Cart(UUID cartId, List<Products> products, String countryCode, 
			String currency, ZonedDateTime created, ZonedDateTime updated) {
		super();
		this.id = cartId;
		this.products = products;
		this.countryCode = countryCode;
		this.currency = currency;
		this.created = created;
		this.updated = updated;
	}

	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}

	public UUID getCartId() {
		return id;
	}


	public void setCartId(UUID cartId) {
		this.id = cartId;
	}


	public List<Products> getProducts() {
		return products;
	}


	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCountryCode() {
		return countryCode;
	}


	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public ZonedDateTime getCreated() {
		return created;
	}


	public void setCreated(ZonedDateTime created) {
		this.created = created;
	}


	public ZonedDateTime getUpdated() {
		return updated;
	}


	public void setUpdated(ZonedDateTime updated) {
		this.updated = updated;
	}

	public Cart addProduct(Products product) {
		products.add(product);
		product.setCart(this);
		return this;
	}


	public static CartBuilder builder() {
		return new CartBuilder();
	}

	public static class CartBuilder {
		private UUID id;
		private List<Products> products;
		private String countryCode;
		private String currency;
		private ZonedDateTime created;
		private ZonedDateTime updated;

		CartBuilder(){}

		public CartBuilder id(final UUID id) {
			this.id = id;
			return this;
		}

		public CartBuilder products(final List<Products> products) {
			this.products = products;
			return this;
		}

		public CartBuilder countryCode(final String countryCode) {
			this.countryCode = countryCode;
			return this;
		}

		public CartBuilder currency(final String currency) {
			this.currency = currency;
			return this;
		}

		public CartBuilder created(final ZonedDateTime created) {
			this.created = created;
			return this;
		}

		public CartBuilder updated(final ZonedDateTime updated) {
			this.updated = updated;
			return this;
		}

		public Cart build() {
			return new Cart(id,products, countryCode, currency, created, updated);
		}
	}
}
