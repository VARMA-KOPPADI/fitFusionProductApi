package com.fitFusion.productsApi.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductDto {
    private long productId;
    private String name;
    private String description;
    private String title;
    private BigDecimal unitPrice;
    private String imageURL;
    private boolean active;
    private int unitsInStock;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;
}
