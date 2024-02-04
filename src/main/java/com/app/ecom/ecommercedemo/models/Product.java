package com.app.ecom.ecommercedemo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(indexName = "products")
public class Product extends BaseModel{
    
    private String title;
    private String desc;
    private String price;
    private Rating rating;
    private String category;
    private String image;

}
