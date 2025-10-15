package com.fitFusion.productsApi.service;

import com.fitFusion.productsApi.dto.ProductCategoryDto;
import com.fitFusion.productsApi.dto.ProductDto;

import java.util.List;

public interface ProductService {

    public List<ProductCategoryDto> getAllCategories();

    public List<ProductDto> getProductsByCategory(Long categoryId);

    public List<ProductDto> getProductsByName(String productName);

    public ProductDto getProductByID(Long productId);

}
