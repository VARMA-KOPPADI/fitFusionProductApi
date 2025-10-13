package com.fitFusion.productsApi.mapper;

import com.fitFusion.productsApi.dto.ProductCategoryDto;
import com.fitFusion.productsApi.entity.ProductCategory;
import org.modelmapper.ModelMapper;

public class ProductCategoryMapper {
    public static final ModelMapper mapper = new ModelMapper();

    public static ProductCategoryDto convertToDto(ProductCategory productCategory) {
        return mapper.map(productCategory, ProductCategoryDto.class);
    }
    public static ProductCategory ConvertToEntity(ProductCategoryDto productCategoryDto) {
        return mapper.map(productCategoryDto, ProductCategory.class);
    }
}