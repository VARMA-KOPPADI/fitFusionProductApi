package com.fitFusion.productsApi.restController;

import com.fitFusion.productsApi.dto.ProductCategoryDto;
import com.fitFusion.productsApi.dto.ProductDto;
import com.fitFusion.productsApi.exception.NoProductCategoriesFoundException;
import com.fitFusion.productsApi.exception.NoProductsFoundException;
import com.fitFusion.productsApi.response.ApiResponse;
import com.fitFusion.productsApi.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@Slf4j
public class ProductRestController {
    @Autowired
    private ProductService productService;

    @GetMapping("/categories")
    public ResponseEntity<ApiResponse<List<ProductCategoryDto>>> getAllCategories() {
        log.debug("execution completed method getAllCategories");
        ApiResponse<List<ProductCategoryDto>> response = new ApiResponse<>();
        List<ProductCategoryDto> allCategories = productService.getAllCategories();
        if (allCategories.isEmpty()) {
/*            response.setStatus(500);
            response.setData(null);
            response.setMessage("product category not available");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);*/
            throw new NoProductCategoriesFoundException("product categories not available");
        } else {
            response.setStatus(200);
            response.setMessage("fetched all product categories successfully");
            response.setData(allCategories);
            log.info("fetched all categories successfully");
            log.debug("execution completed method  getAllCategories");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/products/{categoryId}")
    public ResponseEntity<ApiResponse<List<ProductDto>>> productsByCategory(@PathVariable Long categoryId) {
        log.debug("execution started productsByCategory method");
        ApiResponse<List<ProductDto>> response = new ApiResponse<>();
        List<ProductDto> products = productService.getProductsByCategory(categoryId);
        if (products.isEmpty()) {
          /*  response.setStatus(500);
            response.setData(null);
            response.setMessage("product not available in this category");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);*/
            throw new NoProductsFoundException("products not available in this category : /products/{categoryId}");
        } else {
            response.setStatus(200);
            response.setMessage("fetched products by category successfully");
            response.setData(products);
            log.info("fetched products by category successfully");
            log.debug("execution completed method  productsByCategory");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<ApiResponse<List<ProductDto>>> searchProductByName(@PathVariable String name) {
        log.debug("execution started method searchProductByName");
        ApiResponse<List<ProductDto>> response = new ApiResponse<>();
        List<ProductDto> products = productService.getProductsByName(name);
        if (products.isEmpty()) {
           /* response.setStatus(500);
            response.setMessage("no products availabe");
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);*/
            throw new NoProductsFoundException("products not available");

        } else {
            response.setStatus(200);
            response.setMessage("fetched products successfully");
            response.setData(products);
            log.info("fetched product successfully");
            log.debug("execution completed method searchProductByName");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }


    @GetMapping("/product/{productId}")
    public ResponseEntity<ApiResponse<ProductDto>> productByID(@PathVariable Long productId) {
        log.debug("execution started method productById");
        ApiResponse<ProductDto> response = new ApiResponse<>();
        ProductDto byID = productService.getProductByID(productId);
        if (byID == null) {
          /*  response.setStatus(500);
            response.setMessage("Failed to fetch the product");
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);*/
            throw  new NoProductsFoundException("product not found with given id :"+"endPoint:/product/{productId}" );
        } else {
            response.setStatus(200);
            response.setMessage("fetched product details successfully");
            response.setData(byID);
            log.info("fetched product details successfully");
            log.debug("execution completed method productById");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }


}
