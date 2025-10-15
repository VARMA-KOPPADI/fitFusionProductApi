package com.fitFusion.productsApi.dto;

import lombok.Data;

@Data
public class ProductCategoryDto {

    private Long categoryId;

    private String categoryName;

    private String active;
}