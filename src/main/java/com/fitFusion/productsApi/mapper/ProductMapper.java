package com.fitFusion.productsApi.mapper;

import com.fitFusion.productsApi.dto.ProductDto;
import com.fitFusion.productsApi.entity.Product;
import org.modelmapper.ModelMapper;

public class ProductMapper {
    public static final ModelMapper mapper =new ModelMapper();
    public static ProductDto convertToDto(Product product)
    {
        return mapper.map(product,ProductDto.class);
    }
    public static Product convertToEntity(ProductDto productDto)
    {
        return mapper.map(productDto,Product.class);
    }
}