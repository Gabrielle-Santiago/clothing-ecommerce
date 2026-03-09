package com.gabrielle.ecommerce.adapter.http.controller;

import com.gabrielle.ecommerce.application.service.purchase.PurchaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    private final PurchaseService purchaseService;

    public WebhookController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping("/approve/{id}")
    public ResponseEntity<Void> approve(@PathVariable UUID id) {
        purchaseService.approve(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reject/{id}")
    public ResponseEntity<Void> reject(@PathVariable UUID id) {
        purchaseService.reject(id);
        return ResponseEntity.ok().build();
    }
}
