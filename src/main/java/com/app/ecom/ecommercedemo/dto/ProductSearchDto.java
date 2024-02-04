package com.app.ecom.ecommercedemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSearchDto {
    private String title;
    private Long pageNumber;
    private Long numberOfRecords;

    private SortOrder sortOrder;

}

enum SortOrder{
    ASCENDING,
    DESCENDING
}
