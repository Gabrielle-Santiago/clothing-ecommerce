package com.gabrielle.ecommerce.adapter.http.controller;

import com.gabrielle.ecommerce.application.dto.payment.*;
import com.gabrielle.ecommerce.application.service.payment.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final CreatePaymentUseCase create;

    public PaymentController(CreatePaymentUseCase create) {
        this.create = create;
    }

    @PostMapping
    public ResponseEntity<PaymentResponse> create(@Valid @RequestBody PaymentRequest request){
        PaymentResponse response = create.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
