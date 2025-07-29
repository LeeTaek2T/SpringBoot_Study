package com.example.spring;

import jakarta.persistence.*;

@Entity
@Table
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product_id")
    private Product product;

    public WishList(Product product) {
        this.product = product;
    }

    public WishList() {

    }

    public String getProductName() {
        return product.getName();
    }
}
