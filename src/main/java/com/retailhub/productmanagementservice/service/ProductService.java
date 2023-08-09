package com.retailhub.productmanagementservice.service;

import com.retailhub.productmanagementservice.model.ProductDetail;
import com.retailhub.productmanagementservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDetail> retrieveProductDetails() {
        return productRepository.retrieveProductDetails();
    }
}
