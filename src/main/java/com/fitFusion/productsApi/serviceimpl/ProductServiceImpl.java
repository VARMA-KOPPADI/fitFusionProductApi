package com.fitFusion.productsApi.serviceimpl;

import com.fitFusion.productsApi.dto.ProductCategoryDto;
import com.fitFusion.productsApi.dto.ProductDto;
import com.fitFusion.productsApi.entity.ProductCategory;
import com.fitFusion.productsApi.mapper.ProductCategoryMapper;
import com.fitFusion.productsApi.repository.ProductCategoryRepo;
import com.fitFusion.productsApi.repository.ProductRepo;
import com.fitFusion.productsApi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductCategoryRepo productCategoryRepo;

    @Override
    public List<ProductCategoryDto> getAllCategories() {
        return productCategoryRepo.findAll()
                .stream()
                .map(ProductCategoryMapper::convertToDto)
                .collect(Collectors.toList());

    }

    @Override
    public List<ProductDto> getProductsByCategory(Long categoryId) {
        return null;
    }

    @Override
    public List<ProductDto> getProductsByName(String productName) {
        return List.of();
    }

    @Override
    public ProductDto getProductByID(Long productId) {
        return null;
    }
}
