package com.app.ecom.ecommercedemo.services;



import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.ecom.ecommercedemo.models.Product;

@Service
public class FakeStoreProductService implements ProductService{
    @Autowired
    RestTemplate restTemplate;
    @Override
    public Product getProductById(long id) {
        HttpHeaders header = new HttpHeaders();
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<Product>  entity = new HttpEntity<Product>(header);
         return restTemplate.exchange("https://fakestoreapi.com/products/"+id,HttpMethod.GET,entity,Product.class).getBody();

        // Category cat = Category.builder().id(1).title("Shoes").build();
        // return Product.builder().id(1).image("image URL").desc("Very Unique Product").title("title").category(cat).build();

    }
    @Override
    public List<Product> getAllProducts() {
        HttpHeaders header = new HttpHeaders();
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<Product>  entity = new HttpEntity<Product>(header);
        return restTemplate.exchange("https://fakestoreapi.com/products",HttpMethod.GET,entity,new ParameterizedTypeReference<List<Product>>() {}).getBody();
    }
    @Override
    public Product updateProductById(Long id, Product product) {
        HttpHeaders header = new HttpHeaders();
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<Product>  entity = new HttpEntity<Product>(product,header);
        return restTemplate.exchange("https://fakestoreapi.com/products/"+id,HttpMethod.PUT,entity,Product.class).getBody();
    }
    @Override
    public Product deleteProductById(Long id) {
        HttpHeaders header = new HttpHeaders();
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<Product>  entity = new HttpEntity<Product>(header);
        return restTemplate.exchange("https://fakestoreapi.com/products/"+id,HttpMethod.DELETE,entity,Product.class).getBody();
    }
    
    
}
