package com.app.ecom.ecommercedemo.services;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.ecom.ecommercedemo.dto.FakeProductDto;
import com.app.ecom.ecommercedemo.exception.ProductNotFoundException;
import com.app.ecom.ecommercedemo.models.Product;

@Service
public class FakeStoreProductService implements ProductService{
    @Autowired
    RestTemplate restTemplate;
    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        HttpHeaders header = new HttpHeaders();
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<FakeProductDto>  entity = new HttpEntity<FakeProductDto>(header);
        FakeProductDto response = restTemplate.exchange("https://fakestoreapi.com/products/{id}",HttpMethod.GET,entity,FakeProductDto.class,id).getBody();
        if(response == null){
            throw new ProductNotFoundException("Product not found");
        }
        return mapProduct(response);
    }
    private static Product mapProduct(FakeProductDto prd){
        return Product.builder().category(prd.getCategory())
                                .desc(prd.getDesc())
                                .id(prd.getId())
                                .image(prd.getImage())
                                .price(prd.getPrice())
                                .rating(prd.getRating())
                                .title(prd.getTitle())
                                .build();

            
    } 
    @Override
    public List<Product> getAllProducts() {
        HttpHeaders header = new HttpHeaders();
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<FakeProductDto>  entity = new HttpEntity<FakeProductDto>(header);
        FakeProductDto[] response = restTemplate.exchange("https://fakestoreapi.com/products",HttpMethod.GET,entity,FakeProductDto[].class).getBody();
        List<Product> prdList = new ArrayList<>();
        for(FakeProductDto fakeProduct : response){
            prdList.add(mapProduct(fakeProduct));
        }
        return prdList;
    }
    @Override
    public Product updateProductById(Long id, Product product) {
        HttpHeaders header = new HttpHeaders();
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        FakeProductDto fakeProduct  = FakeProductDto.builder().category(product.getCategory())
                                .desc(product.getDesc())
                                .image(product.getImage())
                                .price(product.getPrice())
                                .rating(product.getRating())
                                .title(product.getTitle())
                                .build();
        HttpEntity<FakeProductDto>  entity = new HttpEntity<FakeProductDto>(fakeProduct,header);
        FakeProductDto resposnse = restTemplate.exchange("https://fakestoreapi.com/products/{id}",HttpMethod.PUT,entity,FakeProductDto.class,id).getBody();
        return mapProduct(resposnse);
    }
    @Override
    public Product deleteProductById(Long id) {
        HttpHeaders header = new HttpHeaders();
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<FakeProductDto>  entity = new HttpEntity<FakeProductDto>(header);
        FakeProductDto response =  restTemplate.exchange("https://fakestoreapi.com/products/{id}",HttpMethod.DELETE,entity,FakeProductDto.class,id).getBody();
        return mapProduct(response);
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }


}
