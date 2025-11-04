package com.gabrielle.ecommerce.ports.repository;

import com.gabrielle.ecommerce.domain.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {
    Product save(Product product);
    void deleteById(UUID id);
    Optional<Product> findProdutById(UUID id);
    List<Product> findAll();
}
