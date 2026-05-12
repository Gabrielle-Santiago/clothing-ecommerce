package com.gabrielle.ecommerce.adapter.http.controller.docs;

import com.gabrielle.ecommerce.application.dto.payment.PaymentRequest;
import com.gabrielle.ecommerce.application.dto.payment.PaymentResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Payments", description = "Payment management endpoints")
public interface PaymentControllerDoc {

    @Operation(
            summary = "Create payment",
            description = "Creates a payment and returns Mercado Pago checkout URL"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Payment created successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Purchase not found"
            )
    })
    ResponseEntity<PaymentResponse> create(
            @Valid @RequestBody PaymentRequest request
    );
}