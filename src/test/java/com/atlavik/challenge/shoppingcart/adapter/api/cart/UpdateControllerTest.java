package com.atlavik.challenge.shoppingcart.adapter.api.cart;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.atlavik.challenge.shoppingcart.adapter.api.cart.dto.ProductDto;
import com.atlavik.challenge.shoppingcart.usecase.AddProductToShoppingCart.AddProductToCart;
import com.atlavik.challenge.shoppingcart.usecase.DeleteProductFromShoppingCart.DeleteProductFromShoppingCart;
import com.atlavik.challenge.shoppingcart.utils.Mother;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UpdateControllerTest {

	@MockBean
	private AddProductToCart addProductToCart;
	
	@MockBean
	private DeleteProductFromShoppingCart deleteProductFromShoppingCart;
	
	@Autowired
    private MockMvc mockMvc;
	
	private final UUID DUMMY_CART_UUID = UUID.fromString("4144f198-a4be-4e35-8275-8e260c562b36");
	private final UUID DUMMY_PRODUCTS_UUID = UUID.fromString("4144f198-a4be-4e35-8275-8e260c562b36");
	private final String CURRENCY = "USD";
	private final String ADD_URI = "/api/v1/carts/{cartId}/products";
	private final String DELETE_URI = "/api/v1/carts/{cartId}/products/{productId}";
	
	@Test
	public void testAddProduct() throws Exception {
      Mockito.when(addProductToCart.add(Mockito.eq(DUMMY_CART_UUID), Mockito.any(ProductDto.class))).thenReturn(Mother.cartDtoWithItems());
      mockMvc.perform(put(ADD_URI,DUMMY_CART_UUID).
      content(asJsonString(Mother.productDto())).
      contentType(MediaType.APPLICATION_JSON).
      accept(MediaType.APPLICATION_JSON)).
      andExpect(jsonPath("$.id", is(DUMMY_CART_UUID.toString()))).
      andExpect(jsonPath("$.currency", is(CURRENCY))).
      andExpect(jsonPath("$.products[0].name", is("Apple iphone")));
	}
	
	@Test
	public void testDeleteProduct() throws Exception {
      Mockito.when(deleteProductFromShoppingCart.deleteProduct(Mockito.eq(DUMMY_CART_UUID), Mockito.eq(DUMMY_PRODUCTS_UUID))).thenReturn(Mother.cloneProductDto());
      mockMvc.perform(delete(DELETE_URI,DUMMY_CART_UUID,DUMMY_PRODUCTS_UUID).
      content(asJsonString(Mother.productDto())).
      contentType(MediaType.APPLICATION_JSON).
      accept(MediaType.APPLICATION_JSON)).
      andExpect(jsonPath("$.name", is("Apple iphone"))).
      andExpect(jsonPath("$.quantity", is(2)));
	}
	
	public static String asJsonString(final Object obj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
	    mapper.registerModule(new JavaTimeModule());
	    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	    return mapper.writeValueAsString(obj );
	}
}
