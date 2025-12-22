package com.gabrielle.ecommerce.application.service.product;

import com.gabrielle.ecommerce.ports.repository.product.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteProductUseCase {
    public final ProductRepository repository;

    public DeleteProductUseCase(ProductRepository repository) {
        this.repository = repository;
    }

    public void execute(UUID id){
        repository.deleteById(id);
    }
}
