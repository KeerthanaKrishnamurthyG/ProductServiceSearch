package com.app.ecom.ecommercedemo.repositories;

import com.app.ecom.ecommercedemo.models.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticSearchProductCrudRepository extends ElasticsearchRepository<Product,Long> {
}
