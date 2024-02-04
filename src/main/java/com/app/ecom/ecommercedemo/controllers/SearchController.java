package com.app.ecom.ecommercedemo.controllers;

import com.app.ecom.ecommercedemo.dto.ProductSearchDto;
import com.app.ecom.ecommercedemo.models.Product;
import com.app.ecom.ecommercedemo.services.OpenSearchProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@AllArgsConstructor
public class SearchController {

    OpenSearchProductService openSearchProductService;
    @PostMapping("/byTitle")
    public List<Product> searchProductByTitle(@RequestBody ProductSearchDto product){
        return openSearchProductService.searchProductByTitle(product.getTitle());
    }
}
