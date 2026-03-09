package com.gabrielle.ecommerce.adapter.http.controller;

import com.gabrielle.ecommerce.adapter.http.controller.docs.PurchaseControllerDoc;
import com.gabrielle.ecommerce.application.dto.purchase.PurchaseRequest;
import com.gabrielle.ecommerce.application.dto.purchase.PurchaseResponse;
import com.gabrielle.ecommerce.application.service.purchase.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseController implements PurchaseControllerDoc {

    private final CreatePurchaseUseCase createPurchase;
    private final DeletePurchaseUseCase deletePurchase;
    private final FindAllPurchasesUseCase findAllPurchases;
    private final PurchaseService purchaseService;

    public PurchaseController(CreatePurchaseUseCase createPurchase, DeletePurchaseUseCase deletePurchase, FindAllPurchasesUseCase findAllPurchases, PurchaseService purchaseService) {
        this.createPurchase = createPurchase;
        this.deletePurchase = deletePurchase;
        this.findAllPurchases = findAllPurchases;
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public ResponseEntity<PurchaseResponse> create(@RequestBody @Valid PurchaseRequest request) {
        PurchaseResponse purchase = createPurchase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(purchase);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id){
        deletePurchase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<PurchaseResponse>> getAllPurchases(){
        List<PurchaseResponse> response = findAllPurchases.execute();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/payment")
    public ResponseEntity<Void> startPayment(@PathVariable UUID id) {
        purchaseService.startPayment(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/cancel")
    public ResponseEntity<Void> cancel(@PathVariable UUID id) {
        purchaseService.cancel(id);
        return ResponseEntity.ok().build();
    }
}

