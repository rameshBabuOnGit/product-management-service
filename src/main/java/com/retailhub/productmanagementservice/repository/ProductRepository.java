package com.retailhub.productmanagementservice.repository;

import com.retailhub.productmanagementservice.model.ProductDetail;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.apache.logging.log4j.util.Strings.trimToNull;

@Repository
public class ProductRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private static final String PRODUCT_DETAILS = "select product_id, product_name, price, description, " +
            "category, stock_quantity from product";

    private final RowMapper<ProductDetail> productDetailRowMapper = productDetailRowMapper();

    public ProductRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<ProductDetail> productDetailRowMapper() {
        return (rs, rowNum) -> ProductDetail.builder()
                .productId(rs.getInt("product_id"))
                .productName(trimToNull(rs.getString("product_name")))
                .productPrice(rs.getBigDecimal("price"))
                .productDescription(trimToNull(rs.getString("description")))
                .productCategory(trimToNull(rs.getString("category")))
                .productStockQuantity(rs.getInt("stock_quantity"))
                .build();
    }

    public List<ProductDetail> retrieveProductDetails() {
        return jdbcTemplate.query(PRODUCT_DETAILS, productDetailRowMapper);
    }
}
