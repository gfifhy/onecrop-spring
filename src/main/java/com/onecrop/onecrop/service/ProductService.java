package com.onecrop.onecrop.service;


import com.onecrop.onecrop.model.Product;
import com.onecrop.onecrop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ProductService {
    private ProductRepository productRepository;


    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public Product deleteProduct(Product product) {
        productRepository.delete(product);
        return product;
    }

    public Optional<Product> findProductById(UUID id) {
        return productRepository.findById(id);
    }
}
