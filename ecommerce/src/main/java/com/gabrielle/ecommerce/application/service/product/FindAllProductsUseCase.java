package com.gabrielle.ecommerce.application.service.product;

import com.gabrielle.ecommerce.application.dto.product.ProductResponseDTO;
import com.gabrielle.ecommerce.application.mapper.product.ProductResponseMapper;
import com.gabrielle.ecommerce.domain.Product;
import com.gabrielle.ecommerce.ports.repository.product.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindAllProductsUseCase {
    private final ProductRepository repository;
    private final ProductResponseMapper response;

    public FindAllProductsUseCase(ProductRepository repository, ProductResponseMapper response) {
        this.repository = repository;
        this.response = response;
    }

    public List<ProductResponseDTO> execute() {
        List<Product> products = repository.findAll();

        return products.stream()
                .map(response::toDTO)
                .collect(Collectors.toList());
    }
}
