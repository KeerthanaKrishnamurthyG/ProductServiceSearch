package com.app.ecom.ecommercedemo;


import com.app.ecom.ecommercedemo.controllers.ProductController;
import com.app.ecom.ecommercedemo.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.util.AssertionErrors;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@WebMvcTest
public class ProductControllerTest {


    @MockBean
    private ProductService productService;
    @Autowired
    ProductController productController;


    @Test()
    public void testController(){
        when(productController.getAllProducts()).thenReturn(new ArrayList<>());
    }
}
