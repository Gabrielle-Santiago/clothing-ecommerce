package com.gabrielle.ecommerce.application.service.product;

import com.gabrielle.ecommerce.application.dto.product.ProductResponseDTO;
import com.gabrielle.ecommerce.application.mapper.product.ProductResponseMapper;
import com.gabrielle.ecommerce.domain.Product;
import com.gabrielle.ecommerce.ports.repository.product.ProductRepository;
import com.gabrielle.ecommerce.shared.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FindByProductIdUseCase {
    private final ProductRepository repository;
    private final ProductResponseMapper response;

    public FindByProductIdUseCase(ProductRepository repository, ProductResponseMapper response) {
        this.repository = repository;
        this.response = response;
    }

    public ProductResponseDTO execute(UUID id) {
        Product product = repository.findProdutById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));

        return response.toDTO(product);
    }
}
