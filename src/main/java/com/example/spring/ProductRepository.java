package com.example.spring;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);

//    @Query("SELECT p FROM Product p JOIN p.wishLists")
//    List<Product> findAll();


//    @EntityGraph(attributePaths = "wishLists")
//    List<Product> findAll();
}
