package com.app.ecom.ecommercedemo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.ecom.ecommercedemo.exception.ProductNotFoundException;
import com.app.ecom.ecommercedemo.models.Product;

@Service
public interface ProductService {
    public Product getProductById(long id) throws ProductNotFoundException;

    public List<Product> getAllProducts();

    public Product updateProductById(Long id, Product product);

    public Product deleteProductById(Long id);
}
