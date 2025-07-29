package com.example.spring;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "product", fetch=FetchType.EAGER)
    private final List<WishList> wishLists = new ArrayList<>();

    @Column(nullable = false, unique = true)
    private String name;
    // ✅ JPA가 사용할 기본 생성자
    public Product() {
    }
    public Product(String name) {
        this.name = name;
    }

    public List<WishList> getWishLists() {
        return wishLists;
    }
    public String getName() {
        return name;
    }
}