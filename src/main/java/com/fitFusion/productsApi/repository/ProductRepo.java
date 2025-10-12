package com.fitFusion.productsApi.repository;

import com.fitFusion.productsApi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Long, Product> {
}
