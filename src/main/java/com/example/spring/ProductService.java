package com.example.spring;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDto addProduct(ProductDto productDto) {
        Product product = new Product(productDto.productName());
        Product savedProduct = productRepository.save(product);
        ProductDto savedProductDto = new ProductDto(savedProduct.getName());
        return savedProductDto;
    }

        public List<ProductDto> getAllProducts() {
            List<Product> products = productRepository.findAll();
            List<ProductDto> productDtos = new ArrayList<>();
            for (Product product : products) {
                ProductDto savedProductDto = new ProductDto(product.getName());
                productDtos.add(savedProductDto);
            }
            return productDtos;
        }
}
