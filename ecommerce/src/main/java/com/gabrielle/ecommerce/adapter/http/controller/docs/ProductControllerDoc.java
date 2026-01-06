package com.gabrielle.ecommerce.adapter.http.controller.docs;

import com.gabrielle.ecommerce.application.dto.product.ProductRequestDTO;
import com.gabrielle.ecommerce.application.dto.product.ProductResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Tag(
        name = "Product generation",
        description = "Registration endpoints")
public interface ProductControllerDoc {

    @Operation(
            summary = "Product creation",
            description = "Register a new product"
    )
    ResponseEntity<ProductResponseDTO> createProduct(
            @Valid @RequestBody ProductRequestDTO requestDTO
    );

    @Operation(
            summary = "Excludes product",
            description = "Delete a product"
    )
    ResponseEntity<Void> deleteById(
            @PathVariable UUID id
    );

    @Operation(
            summary = "Looking for the product",
            description = "Search for a specific product by ID"
    )
    ResponseEntity<ProductResponseDTO> getProductById(
            @PathVariable UUID id
    );

    @Operation(
            summary = "Get all the products",
            description = "Shows all registered products"
    )
    ResponseEntity<List<ProductResponseDTO>> getAllProducts();
}
