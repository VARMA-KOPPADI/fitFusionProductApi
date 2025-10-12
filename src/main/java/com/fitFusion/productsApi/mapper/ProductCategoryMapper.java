package com.fitFusion.productsApi.mapper;

import com.fitFusion.productsApi.dto.ProductCategoryDto;
import com.fitFusion.productsApi.entity.ProductCategory;
import org.modelmapper.ModelMapper;

public class ProductCategoryMapper {
    public static final ModelMapper mapper = new ModelMapper();

    public static ProductCategory convertToDto(ProductCategoryDto productCategorydto) {
        return mapper.map(productCategorydto, ProductCategory.class);
    }
    public static ProductCategoryDto ConvertToEntity(ProductCategory productCategory) {
        return mapper.map(productCategory, ProductCategoryDto.class);
    }
}