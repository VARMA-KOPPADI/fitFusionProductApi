package com.fitFusion.productsApi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "PRODUCT_CATEGORY")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;
    private String categoryName;
    @OneToMany(mappedBy ="productCategory",cascade = CascadeType.ALL)
    private Product product;
    private String active;
}
