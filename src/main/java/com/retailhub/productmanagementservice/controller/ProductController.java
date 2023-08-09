package com.retailhub.productmanagementservice.controller;

import com.retailhub.productmanagementservice.model.ProductDetail;
import com.retailhub.productmanagementservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/product-details")
    public ResponseEntity<List<ProductDetail>> retrieveProductDetails() {
        return new ResponseEntity<>(productService.retrieveProductDetails(), HttpStatus.OK);
    }
}
