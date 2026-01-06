package com.gabrielle.ecommerce.adapter.http.controller.docs;

import com.gabrielle.ecommerce.application.dto.purchase.PurchaseRequest;
import com.gabrielle.ecommerce.application.dto.purchase.PurchaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Tag(
        name = "Purchase creation",
        description = "Registration endpoints"
)
public interface PurchaseControllerDoc {

    @Operation(
            summary = "Purchase creation",
            description = "Register a new purchase"
    )
    ResponseEntity<PurchaseResponse> create(
            @RequestBody @Valid PurchaseRequest request
    );

    @Operation(
            summary = "Excludes purchase",
            description = "Delete purchase"
    )
    ResponseEntity<Void> deleteById(
            @PathVariable UUID id
    );

    @Operation(
            summary = "Get all the purchase",
            description = "Shows all registered purchase"
    )
    ResponseEntity<List<PurchaseResponse>> getAllPurchases();
}
