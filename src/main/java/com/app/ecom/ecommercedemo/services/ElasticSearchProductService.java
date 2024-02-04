package com.app.ecom.ecommercedemo.services;

import com.app.ecom.ecommercedemo.exception.ProductNotFoundException;
import com.app.ecom.ecommercedemo.models.Product;
import com.app.ecom.ecommercedemo.repositories.ElasticSearchProductCrudRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class ElasticSearchProductService implements ProductService{

    private final ElasticSearchProductCrudRepository elasticSearchProductCrudRepository;

    public ElasticSearchProductService(ElasticSearchProductCrudRepository elasticSearchProductCrudRepository) {
        this.elasticSearchProductCrudRepository = elasticSearchProductCrudRepository;
    }

    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        Iterable<Product> list = elasticSearchProductCrudRepository.findAll();
        List<Product> returnList = new ArrayList<>();
        list.forEach(returnList::add);
        return returnList;
    }

    @Override
    public Product createProduct(Product product){
        return elasticSearchProductCrudRepository.save(product);
    }

    @Override
    public Product updateProductById(Long id, Product product) {
        Optional<Product> optionProduct = elasticSearchProductCrudRepository.findById(id);
        optionProduct.orElseThrow();

        product.setId(id);
        return elasticSearchProductCrudRepository.save(product);
    }

    @Override
    public Product deleteProductById(Long id) {
        Optional<Product> optionProduct = elasticSearchProductCrudRepository.findById(id);
        optionProduct.orElseThrow();
        elasticSearchProductCrudRepository.delete(optionProduct.get());
        return optionProduct.get();
    }
}
