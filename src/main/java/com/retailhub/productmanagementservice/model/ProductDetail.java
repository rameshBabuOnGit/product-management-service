package com.retailhub.productmanagementservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDetail {
    private int productId;
    private String productName;
    private BigDecimal productPrice;
    private String productDescription;
    private String productCategory;
    private int productStockQuantity;
}
