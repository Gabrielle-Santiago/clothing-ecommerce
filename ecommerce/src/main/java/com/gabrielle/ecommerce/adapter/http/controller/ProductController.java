package com.gabrielle.ecommerce.adapter.http.controller;

import com.gabrielle.ecommerce.application.dto.product.ProductRequestDTO;
import com.gabrielle.ecommerce.application.dto.product.ProductResponseDTO;
import com.gabrielle.ecommerce.application.service.product.CreateProductUseCase;
import com.gabrielle.ecommerce.application.service.product.DeleteProductUseCase;
import com.gabrielle.ecommerce.application.service.product.FindAllProductsUseCase;
import com.gabrielle.ecommerce.application.service.product.FindByProductIdUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final CreateProductUseCase createProduct;
    private final DeleteProductUseCase deleteProduct;
    private final FindByProductIdUseCase findByProductId;
    private final FindAllProductsUseCase findAllProducts;

    public ProductController(CreateProductUseCase createProduct, DeleteProductUseCase deleteProduct,
                             FindByProductIdUseCase findByProductId, FindAllProductsUseCase findAllProducts) {
        this.createProduct = createProduct;
        this.deleteProduct = deleteProduct;
        this.findByProductId = findByProductId;
        this.findAllProducts = findAllProducts;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@Valid @RequestBody ProductRequestDTO requestDTO) {
        ProductResponseDTO response = createProduct.execute(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id){
        deleteProduct.execute(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable UUID id) {
        ProductResponseDTO response = findByProductId.execute(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        List<ProductResponseDTO> response = findAllProducts.execute();
        return ResponseEntity.ok(response);
    }
}
