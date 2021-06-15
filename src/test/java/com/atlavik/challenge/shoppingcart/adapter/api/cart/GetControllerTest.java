package com.atlavik.challenge.shoppingcart.adapter.api.cart;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.atlavik.challenge.shoppingcart.usecase.GetShoppingCart.GetShoppingCart;
import com.atlavik.challenge.shoppingcart.utils.Mother;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GetControllerTest {
	
	private final String URI = "/api/v1/carts/{cartId}";
	private final UUID DUMMYUUID = UUID.fromString("4144f198-a4be-4e35-8275-8e260c562b36");
	private final String CURRENCY = "USD";

	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private GetShoppingCart getShoppingCart;
	
	@Test
  public void testGet() throws Exception {
      Mockito.when(getShoppingCart.findByCartId(DUMMYUUID)).thenReturn(Mother.cartDto());
      mockMvc.perform(get(URI,DUMMYUUID)).
      andExpect(status().isOk()).
      andExpect(jsonPath("$.id", is(DUMMYUUID.toString()))).
      andExpect(jsonPath("$.currency", is(CURRENCY)));
  }
}
