package com.app.ecom.ecommercedemo.dto;

import com.app.ecom.ecommercedemo.models.Rating;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FakeProductDto {
    private long id;
    private String title;
    private String desc;
    private String price;
    private Rating rating;
    private String category;
    private String image;

}
