package com.fitFusion.productsApi.repository;

import com.fitFusion.productsApi.entity.Product;
import com.fitFusion.productsApi.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Long> {
}