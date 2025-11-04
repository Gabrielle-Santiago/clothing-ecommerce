package com.gabrielle.ecommerce.application.service.product;

import com.gabrielle.ecommerce.application.dto.product.ProductRequestDTO;
import com.gabrielle.ecommerce.application.dto.product.ProductResponseDTO;
import com.gabrielle.ecommerce.application.mapper.product.ProductRequestMapper;
import com.gabrielle.ecommerce.application.mapper.product.ProductResponseMapper;
import com.gabrielle.ecommerce.domain.Product;
import com.gabrielle.ecommerce.ports.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateProductUseCase {
    public final ProductRepository repository;
    public final ProductRequestMapper request;
    public final ProductResponseMapper response;

    public CreateProductUseCase(ProductRepository repository, ProductRequestMapper request, ProductResponseMapper response) {
        this.repository = repository;
        this.request = request;
        this.response = response;
    }

    @Transactional
    public ProductResponseDTO execute(ProductRequestDTO requestDTO) {
        Product productToCreate = request.toDomain(requestDTO);
        Product savedProduct = repository.save(productToCreate);
        return response.toDTO(savedProduct);
    }
}
