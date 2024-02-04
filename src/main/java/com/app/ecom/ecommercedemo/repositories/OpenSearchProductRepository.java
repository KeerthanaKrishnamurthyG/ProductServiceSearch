package com.app.ecom.ecommercedemo.repositories;
import com.app.ecom.ecommercedemo.models.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface OpenSearchProductRepository extends ElasticsearchRepository<Product,String>{

    public List<Product> findProductsByTitleContainingIgnoreCase(String title);
}
