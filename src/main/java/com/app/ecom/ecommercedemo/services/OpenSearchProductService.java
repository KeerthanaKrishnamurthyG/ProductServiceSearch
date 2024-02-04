package com.app.ecom.ecommercedemo.services;

import com.app.ecom.ecommercedemo.exception.ProductNotFoundException;
import com.app.ecom.ecommercedemo.models.Product;
import com.app.ecom.ecommercedemo.repositories.OpenSearchProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class OpenSearchProductService {

    private final OpenSearchProductRepository openSearchProductRepository;

    public OpenSearchProductService(OpenSearchProductRepository openSearchProductRepository) {
        this.openSearchProductRepository = openSearchProductRepository;
    }


    public Product updateProductById(Long id, Product product) {
        return openSearchProductRepository.save(product);
    }


    public List<Product> searchProductByTitle(String title){
        return openSearchProductRepository.findProductsByTitleContainingIgnoreCase(title);
    }
}
