package com.app.ecom.ecommercedemo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ecom.ecommercedemo.models.Product;
import com.app.ecom.ecommercedemo.services.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
    ProductService productService;

    ProductController(ProductService productService){
        this.productService = productService;
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return this.productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return this.productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product updateProductById(@PathVariable("id") Long id,@RequestBody Product product){
        return this.productService.updateProductById(id,product);
    }

    @DeleteMapping("/{id}")
    public Product deleteProductById(@PathVariable("id") Long id){
        return this.productService.deleteProductById(id);
    }
}
