package com.fitFusion.productsApi.controller;

import com.fitFusion.productsApi.dto.ProductCategoryDto;
import com.fitFusion.productsApi.dto.ProductDto;
import com.fitFusion.productsApi.response.ApiResponse;
import com.fitFusion.productsApi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ProductRestController {
    @Autowired
    private ProductService productService;

    @GetMapping("/productCategories")
    public ResponseEntity<ApiResponse<List<ProductCategoryDto>>> getAllCategories() {
        ApiResponse<List<ProductCategoryDto>> response = new ApiResponse<>();
        List<ProductCategoryDto> allCategories = productService.getAllCategories();
        if (allCategories.isEmpty()) {
            response.setStatus(500);
            response.setData(null);
            response.setMessage("product category not available");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            response.setStatus(200);
            response.setMessage("fetched all product categories successfully");
            response.setData(allCategories);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/products/{categoryId}")
    public ResponseEntity<ApiResponse<List<ProductDto>>> productsByCategory(@PathVariable Long categoryId) {
        ApiResponse<List<ProductDto>> response = new ApiResponse<>();
        List<ProductDto> products = productService.getProductsByCategory(categoryId);
        if (products.isEmpty()) {
            response.setStatus(500);
            response.setData(null);
            response.setMessage("product not available in this category");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            response.setStatus(200);
            response.setMessage("fetched products by category successfully");
            response.setData(products);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/product/{productId")
    public ResponseEntity<ApiResponse<ProductDto>> productByID(@PathVariable Long productId) {
        ApiResponse<ProductDto> response = new ApiResponse<>();
        ProductDto byID = productService.getProductByID(productId);
        if (byID == null) {
            response.setStatus(500);
            response.setMessage("Failed to fetch the product");
            response.setData(null);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            response.setStatus(200);
            response.setMessage("fetched produzct details successfully");
            response.setData(byID);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
    }


}
