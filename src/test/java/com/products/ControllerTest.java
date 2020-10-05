package com.products;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.products.controller.ProductsController;
import com.products.service.ProductsService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
	
  @Autowired
  private MockMvc mockMvc;

  @InjectMocks
  private ProductsController productsController;

  @Mock
  private ProductsService ProductsService;


  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(productsController).build();
  }

  @Test
  public void getProducts()
      throws Exception {
    mockMvc.perform(get("/products/getproducts")
        .contentType(TestUtil.APPLICATION_JSON_UTF8)).andExpect(status().isOk());
  }

  @Test
  public void getProductsById()throws Exception {
	Long id = 1L;
    mockMvc.perform(get("/products/getproductsbyid/" + id)
        .contentType(TestUtil.APPLICATION_JSON_UTF8)).andExpect(status().isOk());
  }
  
}
