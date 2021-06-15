//package com.atlavik.challenge.shoppingcart.adapter.api.cart;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.UUID;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.atlavik.challenge.shoppingcart.adapter.api.cart.dto.CartDto;
//import com.atlavik.challenge.shoppingcart.adapter.api.cart.dto.ProductDto;
//import com.atlavik.challenge.shoppingcart.usecase.AddProductToShoppingCart.AddProductToCart;
//import com.atlavik.challenge.shoppingcart.usecase.CreateShoppingCart.CreateShoppingCart;
//import com.atlavik.challenge.shoppingcart.usecase.GetShoppingCart.GetShoppingCart;
//import com.atlavik.challenge.shoppingcart.utils.Mother;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class CartControllerTest {
//
//	@Autowired
//    private MockMvc mockMvc;
//	
//	@MockBean
//	private GetShoppingCart getShoppingCart;
//	
//	@MockBean
//	private CreateShoppingCart createShoppingCart;
//	
//	@MockBean
//	private AddProductToCart addProductToCart;
//	
//	private final UUID uuid = UUID.fromString("4144f198-a4be-4e35-8275-8e260c562b36");
//	
//	
//	@Test
//    public void testGet() throws Exception {
//        Mockito.when(getShoppingCart.findByCartId(uuid)).thenReturn(Mother.cartDto());
//        mockMvc.perform(get("/api/v1/carts/{cartId}",uuid)).
//        andExpect(status().isOk()).
//        andExpect(jsonPath("$.id", is("4144f198-a4be-4e35-8275-8e260c562b36"))).
//        andExpect(jsonPath("$.currency", is("USD")));
//    }
//	
//	@Test
//    public void testCreate() throws Exception {
//		Mockito.when(createShoppingCart.create(Mockito.any(CartDto.class))).thenReturn(Mother.cartDto());
//        mockMvc.perform(post("/api/v1/carts").
//        content(asJsonString(Mother.cartDto())).
//        contentType(MediaType.APPLICATION_JSON).
//        accept(MediaType.APPLICATION_JSON)).
//        andExpect(jsonPath("$.id", is("4144f198-a4be-4e35-8275-8e260c562b36"))).
//        andExpect(jsonPath("$.currency", is("USD")));
//    }
//	
//	@Test
//    public void testAddProduct() throws Exception {
//        Mockito.when(addProductToCart.add(Mockito.eq(uuid), Mockito.any(ProductDto.class))).thenReturn(Mother.cartDtoWithItems());
//        mockMvc.perform(put("/api/v1/carts/{cartId}/products",uuid).
//        content(asJsonString(Mother.productDto())).
//        contentType(MediaType.APPLICATION_JSON).
//        accept(MediaType.APPLICATION_JSON)).
//        andExpect(jsonPath("$.id", is("4144f198-a4be-4e35-8275-8e260c562b36"))).
//        andExpect(jsonPath("$.currency", is("USD"))).
//        andExpect(jsonPath("$.products[0].name", is("Apple iphone")));
//    }
//	
//	public static String asJsonString(final Object obj) throws JsonProcessingException {
//		ObjectMapper mapper = new ObjectMapper();
//	    mapper.registerModule(new JavaTimeModule());
//	    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//	    
//	     return mapper.writeValueAsString(obj );
//	}
//}
